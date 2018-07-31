package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.result.DebtInfo;
import cn.sprivacy.yuantong.util.AppResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@RestController
@RequestMapping("/file")
public class AppFileController {
    private static final String EXCEL_XLS = ".xls";
    private static final String EXCEL_XLSX = ".xlsx";
    private static final String TEMPLATE_FILENAME = "呼叫上传文件模板.xlsx";
    private static final String UPLOAD_PATH = "d:/temp/";
    @GetMapping("/upload-template")
    public void getUploadTemplate(HttpServletResponse response,HttpServletRequest request) {
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("upload_template.xlsx");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        response.setContentType("application/octet-stream");
        byte[] buf = new byte[1024 * 1024];
        int len = 0;
        try {
            response.setHeader("Content-Disposition", "attachment;fileName="+ encodeDownloadFilename(TEMPLATE_FILENAME, request.getHeader("user-agent")));
            ServletOutputStream outputStream = response.getOutputStream();
            while (-1 != (len = bufferedInputStream.read(buf))) {
                outputStream.write(buf,0, len);
            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/upload")
    public AppResponse upload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file == null) {
            return AppResponse.builder().code(1).msg("请选择文件！").build();
        }
        final String contentType = file.getContentType();
        final String name = file.getName();
        final String originalFilename = file.getOriginalFilename();
        String postfix = originalFilename.substring(originalFilename.indexOf("."));
        postfix = StringUtils.isBlank(postfix)? postfix: EXCEL_XLSX;
        try {
            final String fileName = UUID.randomUUID().toString();
            final File destination = new File(UPLOAD_PATH, fileName + postfix);
            FileUtils.copyToFile(file.getInputStream(), destination);
            List<DebtInfo> debtInfos = parse(destination, postfix);
            AppResponse build = AppResponse.builder().obj(debtInfos).build();
            return build;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppResponse.builder().build();
    }

    private List<DebtInfo> parse(File srcFile,String postfix) throws Exception {
        Workbook workbook = null;
        int rowNum = 1;
        workbook = EXCEL_XLSX.equals(postfix)?new XSSFWorkbook(srcFile): new HSSFWorkbook(new FileInputStream(srcFile));
        final Sheet sheet = workbook.getSheetAt(0);
        List<DebtInfo> debtInfos = new ArrayList<>(0);
        for (; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            String name = Optional.ofNullable(row.getCell(0)).map(Cell::getStringCellValue).orElse("");
            int sex = Optional.ofNullable(row.getCell(1)).map(c -> ((int) c.getNumericCellValue())).orElse(0);
            String tel = Optional.ofNullable(row.getCell(2)).map(c -> String.valueOf(c.getNumericCellValue())).orElse("");
            int debt = Optional.ofNullable(row.getCell(3)).map(c -> ((int) c.getNumericCellValue())).orElse(0);
            String deadline =Optional.ofNullable(row.getCell(4)).map(c -> String.valueOf(c.getNumericCellValue())).orElse("");
            int delay = Optional.ofNullable(row.getCell(5)).map(c -> ((int) c.getNumericCellValue())).orElse(0);
            int utype =Optional.ofNullable(row.getCell(6)).map(c -> ((int) c.getNumericCellValue())).orElse(0);
            /*// 姓名 0
            String name = Optional.ofNullable(getValue(row.getCell(0))).map(Object::toString).orElse("");
            // 性别 1
            Integer sex = Optional.ofNullable(getValue(row.getCell(1))).map(o -> ((int) Double.parseDouble(o.toString()))).orElse(0);*/

            DebtInfo d = new DebtInfo();
//            d.setDeadline(deadline
            d.setDebt(debt).setName(name).setSex(sex).setTel(tel).setUtype(utype).setDelay(delay);
            debtInfos.add(d);
        }
        workbook.close();
        return debtInfos;
    }
    private static Object getValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }
    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     * @param filename 下载文件名
     * @param agent 客户端浏览器
     * @return 编码后的下载附件名
     * @throws IOException
     */
    public String encodeDownloadFilename(String filename, String agent) throws IOException{
        if(agent.contains("Firefox")){ // 火狐浏览器
            filename = "=?UTF-8?B?"+new BASE64Encoder().encode(filename.getBytes("utf-8"))+"?=";
        }else{ // IE及其他浏览器
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }

}

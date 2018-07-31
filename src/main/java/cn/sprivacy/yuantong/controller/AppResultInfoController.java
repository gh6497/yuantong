package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.domain.AppResultInfo;
import cn.sprivacy.yuantong.service.ResultInfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@RestController
@RequestMapping("/result")
public class AppResultInfoController {
    private final ResultInfoService resultInfoService;

    @Autowired
    public AppResultInfoController(ResultInfoService resultInfoService) {
        this.resultInfoService = resultInfoService;
    }
    @GetMapping("/page/{currentPage}/{pageSize}")
    public  PageResult<AppResultInfo> AppInfoByPage(@PathVariable("currentPage") Integer index,
                                              @PathVariable("pageSize") Integer size) {

        PageResult<AppResultInfo> page = resultInfoService.page(index, size);
        return page;

    }
}

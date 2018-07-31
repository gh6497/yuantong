package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.condition.InfoCondition;
import cn.sprivacy.yuantong.domain.AppInfo;
import cn.sprivacy.yuantong.service.InfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@RestController
@RequestMapping("/info")
public class AppInfoController {
    private final InfoService infoService;

    @Autowired
    public AppInfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    /**
     *
     */
    @GetMapping("/page/{currentPage}/{pageSize}")
    public  PageResult<AppInfo> AppInfoByPage(@PathVariable("currentPage") Integer index,
                                              @PathVariable("pageSize") Integer size, InfoCondition infoCondition) {
        System.out.println(1234);
        return infoService.page(index, size, infoCondition);

    }
}

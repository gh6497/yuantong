package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.domain.AppInfo;
import cn.sprivacy.yuantong.service.InfoService;
import cn.sprivacy.yuantong.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/page/{index}/{size}")
    public  PageResult<AppInfo> AppInfoByPage(@PathVariable("index") Integer index,
                              @PathVariable("size") Integer size) {
        return infoService.page(index, size);

    }
}

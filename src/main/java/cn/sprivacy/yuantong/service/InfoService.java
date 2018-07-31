package cn.sprivacy.yuantong.service;

import cn.sprivacy.yuantong.condition.InfoCondition;
import cn.sprivacy.yuantong.domain.AppInfo;
import cn.sprivacy.yuantong.util.PageResult;

/**
 * @author cailun
 * @date 2018年 07月27日
 */

public interface InfoService {
    PageResult<AppInfo> page(Integer currentPage, Integer pageSize, InfoCondition infoCondition);
}

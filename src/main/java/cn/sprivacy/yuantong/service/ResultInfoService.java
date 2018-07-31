package cn.sprivacy.yuantong.service;

import cn.sprivacy.yuantong.domain.AppResultInfo;
import cn.sprivacy.yuantong.util.PageResult;

/**
 * @author cailun
 * @date 2018年 07月31日
 */
public interface ResultInfoService {
    PageResult<AppResultInfo> page(Integer index, Integer size);
}


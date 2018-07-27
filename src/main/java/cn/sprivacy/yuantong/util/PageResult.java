package cn.sprivacy.yuantong.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@Data
@Accessors(chain = true)
public class PageResult<T> {
    private Long conut;

    private Integer index;

    private Integer size;

    private Integer totalPage;

    private List<T> data;
}

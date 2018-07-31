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
    /**
     * 总行数
     */
    private Long total;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer PageSize;

    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 数据
     */
    private List<T> data;
}

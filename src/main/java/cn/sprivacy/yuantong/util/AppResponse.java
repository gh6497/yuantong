package cn.sprivacy.yuantong.util;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@Data
@Accessors(chain = true)
@Builder
public class AppResponse {
    /**
     * 0 请求成功 其他失败
     */
    @Builder.Default()
    private Integer code = 0;

    /**
     * 简单消息
     */
    @Builder.Default()
    private String msg = "操作成功";

    private Object obj;

    private Integer status;

}

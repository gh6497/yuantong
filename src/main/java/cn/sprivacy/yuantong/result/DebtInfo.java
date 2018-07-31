package cn.sprivacy.yuantong.result;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author cailun
 * @date 2018年 07月30日
 */
@Data
@Accessors(chain = true)
public class DebtInfo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 欠款金额
     */
    private Integer debt;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 截止日期
     */
    private Long deadline;
    /**
     * 预期天数
     */
    private Integer delay;
    /**
     * 欠款类型
     */
    private Integer utype;


}

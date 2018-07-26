package cn.sprivacy.yuantong.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author cailun
 * @date 2018年 07月26日
 */
@Data
@Accessors(chain = true)
public class AppFile {
    private Integer id;

    private String fileName;

    private Date submitTime;

    private Byte uploadByFile;

    private Integer result;

    private Integer ownerId;
}

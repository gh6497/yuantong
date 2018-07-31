package cn.sprivacy.yuantong.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cailun
 * @date 2018年 07月26日
 */
@Entity
@Table(name = "file")
@Data
@Accessors(chain = true)
public class AppFile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "submit_time")
    private Long submitTime;

    @Column(name = "upload_byfile")
    private Boolean uploadByFile;

    @Column(name = "result")

    private Integer result;

    @Column(name = "owner_id")
    private Integer ownerId;
}

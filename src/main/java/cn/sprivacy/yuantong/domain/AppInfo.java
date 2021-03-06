package cn.sprivacy.yuantong.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @authorcailun
 * @date 2018年 07月26日
 */
@Entity
@Table(name = "info")
@Data
@Accessors(chain = true)
public class AppInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    private String name;


    private Integer sex;

    private String tel;

    private Integer debt;

    private Date deadline;

    private Integer delay;


    @Column(name = "import_date")
    private Date importDate;

    private Boolean flag;

    private Integer utype;

    @Column(name = "inFile_id")
    private Integer inFileId;

    @Column(name = "exec_date")
    private Date execDate;
}

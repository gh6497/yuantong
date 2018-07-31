package cn.sprivacy.yuantong.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cailun
 * @date 2018年 07月31日
 */
@Data
@Entity()
@Table(name = "exe_mission")
public class AppExeMission {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Integer id;


    private String name;


    private Integer sex;

    private String tel;

    private Integer debt;

    private Date deadline;

    private Integer delay;

    private Integer result;

    @Column(name = "import_date")
    private Date importDate;

    private Boolean flag;

    private Integer utype;

    @Column(name = "inFile_id")
    private Integer inFileId;

    @Column(name = "exec_date")
    private Date execDate;
}

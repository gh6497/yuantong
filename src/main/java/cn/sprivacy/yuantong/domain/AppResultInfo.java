package cn.sprivacy.yuantong.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cailun
 * @date 2018年 07月26日
 */
@Data
@Entity
@Table(name = "resultinfo")
public class AppResultInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    private String name;

    private Integer sex;

    private String tel;
    @Column(name = "contact_date")
    private Date contactDate;

    @Column(name = "contact_status")
    private String contactStatus;

    @Column(name = "case_status")
    private String caseStatus;

    @Column(name = "expect_date")
    private Date expectDate;

    @Column(name = "related_id")
    private Integer relatedId;
}

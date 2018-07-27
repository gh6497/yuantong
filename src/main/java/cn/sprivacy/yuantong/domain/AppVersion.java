package cn.sprivacy.yuantong.domain;

import javax.persistence.*;

/**
 * @author cailun
 * @date 2018年 07月26日
 */
@Entity
@Table(name = "app01_version")
public class AppVersion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String version;
}

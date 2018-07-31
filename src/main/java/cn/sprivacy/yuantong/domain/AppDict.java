package cn.sprivacy.yuantong.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author cailun
 * @date 2018年 07月31日
 */
@Data
@Entity
@Table(name = "dict")
public class AppDict {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private Integer type;

    private Integer parent;


}

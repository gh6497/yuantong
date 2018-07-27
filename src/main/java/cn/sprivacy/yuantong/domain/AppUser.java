package cn.sprivacy.yuantong.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author cailun
 * @date 2018年 07月26日
 */
@Entity
@Table(name = "app01_user")
@Data
@Accessors(chain = true)
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull
    private String username;
    @NotNull
    private String passwd;

    @Column(name = "nick_name")
    private String nickName;
}

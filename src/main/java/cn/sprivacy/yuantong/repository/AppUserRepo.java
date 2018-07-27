package cn.sprivacy.yuantong.repository;

import cn.sprivacy.yuantong.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
public interface AppUserRepo extends JpaRepository<AppUser,Integer> {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    Optional<AppUser> findByUsername(@Param("username") String username);
}

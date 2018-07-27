package cn.sprivacy.yuantong.service;

import cn.sprivacy.yuantong.domain.AppUser;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
public interface UserService {
    AppUser getUserByUsername(String username);

    AppUser getById(int id);
}

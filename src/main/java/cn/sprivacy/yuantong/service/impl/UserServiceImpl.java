package cn.sprivacy.yuantong.service.impl;

import cn.sprivacy.yuantong.domain.AppUser;
import cn.sprivacy.yuantong.repository.AppUserRepo;
import cn.sprivacy.yuantong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@Service
public class UserServiceImpl implements UserService {
    private final AppUserRepo appUserRepo;

    @Autowired
    public UserServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepo.findByUsername(username).orElse(new AppUser());
    }

    @Override
    public AppUser getById(int id) {
        return appUserRepo.findById(id).orElse(new AppUser());
    }
}

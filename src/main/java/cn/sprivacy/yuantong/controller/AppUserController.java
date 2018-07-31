package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.domain.AppUser;
import cn.sprivacy.yuantong.service.UserService;
import cn.sprivacy.yuantong.util.AppResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@RestController
@RequestMapping("/user")
public class AppUserController {
    private final UserService userService;

    @Autowired
    public AppUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AppResponse login(@RequestBody AppUser appUser, HttpServletRequest request) {
        final AppResponse build = AppResponse.builder().code(0).build();
        if (StringUtils.isNotEmpty(appUser.getUsername())) {
            final AppUser userByUsername = userService.getUserByUsername(appUser.getUsername());
            if (userByUsername.getId() != null) {
                if (!userByUsername.getPasswd().equals(appUser.getPasswd())) {

                    build.setCode(1).setMsg("用户名或密码错误");
                } else {
                    build.setObj(userByUsername.setPasswd(null));
                }
            } else {
                build.setCode(1).setMsg("用户名或密码错误");
            }
        } else {
            build.setCode(1).setMsg("用户名或密码错误");
        }
        return build;
    }
    @GetMapping("/{id}")
    public AppUser appUser(@PathVariable("id") int id) {
         return userService.getById(id);
    }
}

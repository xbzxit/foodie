package com.xbzxit.foodie.controller;

import com.xbzxit.foodie.service.UserService;
import com.xbzxit.foodie.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-13:27
 * @company www.nuzarsurf.com
 */

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {
        if(StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名不能为空");
        }

        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户已经存在");
        }
        return JSONResult.ok();
    }
}

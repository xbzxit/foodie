package com.xbzxit.foodie.controller;

import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.pojo.bo.UserBO;
import com.xbzxit.foodie.service.UserService;
import com.xbzxit.foodie.utils.CookieUtils;
import com.xbzxit.foodie.utils.JSONResult;
import com.xbzxit.foodie.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-14-13:27
 * @company www.nuzarsurf.com
 */

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
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

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        //1.用户名，密码不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPwd)) {
            JSONResult.errorMsg("用户名，密码不能为空");
        }
        //2.查询用户是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户已经存在");
        }
        //3.密码长度不能少于6位
        if (password.length()<6) {
            return JSONResult.errorMsg("密码长度不能少于6位");
        }
        //4.判断两次密码是否一致
        if (!StringUtils.equals(confirmPwd,password)) {
            return JSONResult.errorMsg("判断两次密码是否一致");
        }
        //5.实现注册
        Users userResult = userService.createUser(userBO);
        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResult), true);

        return JSONResult.ok();
    }

    /**
     * 为了信息安全将重要数据清空后再返回给前端
     * @param userResult
     * @return
     */
    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

}

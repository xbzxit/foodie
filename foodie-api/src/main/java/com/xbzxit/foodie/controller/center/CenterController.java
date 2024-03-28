package com.xbzxit.foodie.controller.center;

import com.xbzxit.foodie.pojo.Users;
import com.xbzxit.foodie.service.center.CenterUserService;
import com.xbzxit.foodie.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-28-9:13
 * @company www.nuzarsurf.com
 */

@Api(value = "center - 用户中心", tags = {"用户中心展示的相关接口"})
@RestController
@RequestMapping("/center")
public class CenterController {

    @Autowired
    private CenterUserService centerUserService;


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", httpMethod = "GET")
    @GetMapping("/userInfo")
    public JSONResult userInfo(@ApiParam(name="userId", value="用户ID", required = true) @RequestParam String userId) {
        Users users = centerUserService.queryUserInfo(userId);
        return JSONResult.ok(users);
    }

}

package com.feng.controller;

import com.feng.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SwaggerController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello,Swagger";
    }
    @RequestMapping("/feng/hello")
    @ResponseBody
    public String hello1(){
        return "hello Swagger";
    }
//    @ApiOperation("User返回类")
//    @RequestMapping(value = "/user")
//    public User User(){
//        return new User();
//    }
    @RequestMapping("/test/{username}")
    @ResponseBody
    public String test1(@ApiParam("用户名")@PathVariable("username") String username){
        return "hello"+username;
    }
    @ApiResponses({ @ApiResponse(code = 404, message = "错误了", response = User.class) })
    @ApiOperation("get测试")
    @RequestMapping("/get/{username}/{password}")
    public User hello2(@ApiParam("用户名")@PathVariable("username")String username,@ApiParam("密码")@PathVariable("password")String password) {
        return new User(username,password);
    }
}

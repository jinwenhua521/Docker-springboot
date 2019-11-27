package com.jwh.testMp.controller;


import com.jwh.testMp.entity.User;
import com.jwh.testMp.mapper.UserMapper;
import com.jwh.testMp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazzaro
 * @since 2019-11-25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("list")
    @ResponseBody
    public List<User> getUserList(){
        List<User> users = mapper.selectList(null);
        return users;
    }

}


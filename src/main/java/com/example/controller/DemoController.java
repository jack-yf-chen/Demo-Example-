package com.example.controller;

import com.example.DemoApplication;
import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/select")
    @ResponseBody
    public Object select(){
        return userMapper.getAll();
    }

    @RequestMapping(value = "/getOne")
    public Object getOne(@RequestParam(value="id") Long id){
        return userMapper.getOne(id);
    }

    @RequestMapping(value = "/insert")
    public Object insert(UserEntity user){
        try{
            user.setUpdateTime(new Date());
            user.setInsertTime(new Date());
            System.out.println(userMapper.insert(user));
            return "hello";
        }catch(Exception e){
            logger.error("Excetion:",e);
            return "error";
        }
    }

    @RequestMapping(value = "/update")
    public Object update(UserEntity user){
        try{
            user.setUpdateTime(new Date());
            userMapper.update(user);
            return "OK";
        }catch(Exception e){
            logger.error("Excetion:",e);
            return "error";
        }
    }

    @RequestMapping(value = "/delete")
    public Object delete(@RequestParam(value="id") Long id){
        try{
            userMapper.delete(id);
            return "OK";
        }catch(Exception e){
            logger.error("Excetion:",e);
            return "error";
        }
    }


    @RequestMapping(value = "/demo")
    @ResponseBody
    public Object demo(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid","12");
        map.put("username","一二");
        return map;
    }

}

package com.hegg.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hegg.springboot.common.MyResponse;
import com.hegg.springboot.model.User;
import com.hegg.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getHello() {
        return "Hello,Word!!!世界5";
    }


    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse selectByPrimaryKey(Integer id){
        User user = this.userService.selectByPrimaryKey(id);
        MyResponse response = new MyResponse();
        if(null != user){
            response.setCode("success");
            response.setMsg("成功");
            response.setData(user);
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse getAllUser(){
        List<User> list = this.userService.getAllUser();
        MyResponse response = new MyResponse();
        if(null != list && list.size() > 0){
            response.setCode("success");
            response.setMsg("成功");
            response.setData(list);
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @RequestMapping(value = "/findByPage", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse findByPage(Integer pageNum, Integer pageSize){
        Page<User> list = this.userService.findByPage(pageNum, pageSize);
        MyResponse response = new MyResponse();
        if(null != list && list.size() > 0){
            response.setCode("success");
            response.setMsg("成功");
            response.setData(list);
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @RequestMapping(value = "/findByPageInfo", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse findByPageInfo(Integer pageNum, Integer pageSize){
        PageInfo<User> list = this.userService.findByPageInfo(pageNum, pageSize);
        MyResponse response = new MyResponse();
        if(null != list && list.getList().size() > 0){
            response.setCode("success");
            response.setMsg("成功");
            response.setData(list);
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    public MyResponse insert(User user){
        int result = userService.insert(user);
        MyResponse response = new MyResponse();
        if(result == 1){
            response.setCode("success");
            response.setMsg("成功");
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/insertSelective", produces = {"application/json;charset=UTF-8"})
    public MyResponse insertSelective(User user){
        int result = userService.insertSelective(user);
        MyResponse response = new MyResponse();
        if(result == 1){
            response.setCode("success");
            response.setMsg("成功");
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteByPrimaryKey", produces = {"application/json;charset=UTF-8"})
    public MyResponse deleteByPrimaryKey(Integer id){
        int result = userService.deleteByPrimaryKey(id);
        MyResponse response = new MyResponse();
        if(result == 1){
            response.setCode("success");
            response.setMsg("成功");
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKeySelective", produces = {"application/json;charset=UTF-8"})
    public MyResponse updateByPrimaryKeySelective(User user){
        int result = userService.updateByPrimaryKeySelective(user);
        MyResponse response = new MyResponse();
        if(result == 1){
            response.setCode("success");
            response.setMsg("成功");
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/updateByPrimaryKey", produces = {"application/json;charset=UTF-8"})
    public MyResponse updateByPrimaryKey(User user){
        int result = userService.updateByPrimaryKey(user);
        MyResponse response = new MyResponse();
        if(result == 1){
            response.setCode("success");
            response.setMsg("成功");
        } else {
            response.setCode("faild");
            response.setMsg("失败");
        }
        return response;
    }
}

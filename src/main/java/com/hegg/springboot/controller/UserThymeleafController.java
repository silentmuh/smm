package com.hegg.springboot.controller;

import com.hegg.springboot.model.User;
import com.hegg.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/userThymeleafController")
public class UserThymeleafController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(Model model){  //这个地方用model来存储数据，里面存储键值对，值可以为list
        List<User> userList = userService.getAllUser();
        model.addAttribute("title","所有用户");
        model.addAttribute("userList", userList);
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 跳转至添加页面
     * @param model
     * @return
     */
    @RequestMapping("/toForm")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/create")
    public ModelAndView create(User user) {
        if(null != user.getId()){//如果id不为空，则修改
            int result = userService.updateByPrimaryKeySelective(user);
        } else {
            int result = userService.insertSelective(user);
        }
        //提交表单后重定向至list页面
        return new ModelAndView("redirect:/userThymeleafController/list");
    }


    /**
     * 根据id查询用户
     * @return
     */
    @GetMapping("getUserById/{id}")
    public ModelAndView view(@PathVariable("id") Integer id, Model model) {
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 删除用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id, Model model) {
        userService.deleteByPrimaryKey(id);
        model.addAttribute("userList", userService.getAllUser());
        //删除用户后重定向至list页面
        return new ModelAndView("redirect:/userThymeleafController/list");
    }

    /**
     * 修改用户（这里是把查询到的用户信息保存起来，跳转至form页面修改）
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.selectByPrimaryKey(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}

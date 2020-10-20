package com.gruop.cmoic.controller.admin;

import com.gruop.cmoic.pojo.Admin;
import com.gruop.cmoic.service.AdminService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;

    @RequestMapping("/toAdminLogin")
    public String toAdminLogin() {
        return "/admin/login";
    }


    /*
     * 管理员登录
     * */
    @RequestMapping("/adminLogin")
    public String adminLogin(String username, String password, Model model, HttpSession session) {
        if (username == "" || username.isEmpty()) {
            model.addAttribute("msg", "用户名不能为空");
            return "/admin/login";
        }
        if (password == "") {
            model.addAttribute("msg", "密码不能为空！");
            return "/admin/login";
        }
        Admin admin = adminService.selectByUserName(username);
        if (admin == null) {
            model.addAttribute("msg", "用户名输入错误！");
            return "/admin/login";
        }
        if (admin.getPassword().equals(password) == false) {
            model.addAttribute("msg", "密码输入错误！");
            return "/admin/login";
        }
        session.setAttribute("admin", admin);
        return "/admin/admin";
    }


}

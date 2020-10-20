package com.gruop.cmoic.controller;

import com.gruop.cmoic.pojo.User;
import com.gruop.cmoic.service.IndexUserService;
import com.gruop.cmoic.service.UserService;
import com.gruop.cmoic.service.impl.IndexUserServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class IndexUserControllerjjs {
    @Resource
    IndexUserService indexUserService;
    @Resource
    UserService userService;

    @RequestMapping("/static/userLogin")
    @ResponseBody
    public String userLogin(String loginaccount, String password, String codes, Model model, HttpSession session) {
        String key = (String) session.getAttribute("randomcode_key");
        if (key.equals(codes) == false) {
            return "5";//验证码错误
        }
        if (loginaccount == "") {
            return "1";//用户名为空
        }
        User user = indexUserService.selectByloginaccount(loginaccount);
        if (user == null) {
            return "2";//没有此用户
        }
        if (user.getPassword().equals(password) == false) {
            return "3";//密码错误
        }
        if (user.getUserstatus() == 0) {
            return "6";//用户被封号
        }
        session.setAttribute("user", user);
        return "4";//登录成功
    }

    /*
     * 退出
     * */
    @RequestMapping("/static/exitUser")
    public void exitUser(HttpSession session) {
        session.invalidate();
    }

    /*
     *修改头像
     * */
    @RequestMapping("/static/updatePath")
    public String updatePath(MultipartFile file, Integer id, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/static/images/userphotopath/");
        //旧名称
        String originalFilename = file.getOriginalFilename();
        //扩展名
        String extension = FilenameUtils.getExtension(originalFilename);
        String newFileName = UUID.randomUUID().toString();
        File file1 = new File(realPath, newFileName);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user1 = indexUserService.selectByid(id);
        user1.setAvataraddress("/static/images/userphotopath/" + newFileName);
        int upduserstatus = userService.upduserstatus(user1);
        request.getSession().setAttribute("user", user1);
        return "/index/personal-info";
    }

    /*
     *修改密码
     * */
    @RequestMapping("/static/updatePwd")
    @ResponseBody
    public String updatePwd(String password, String newPwd1, String newPwd2, HttpSession session) {
        if (newPwd1.equals(newPwd2) == false) {
            return "1";//两次密码不一致
        }
        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(password) == false) {
            return "2";//原密码错误
        }
        user.setPassword(newPwd1);
        int upduserstatus = userService.upduserstatus(user);
        if (upduserstatus > 0) {
            session.invalidate();
            return "3";//修改成功
        }
        return "2";
    }

}

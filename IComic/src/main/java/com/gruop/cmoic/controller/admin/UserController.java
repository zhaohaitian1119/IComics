package com.gruop.cmoic.controller.admin;

import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.User;
import com.gruop.cmoic.service.UserService;
import com.gruop.cmoic.utils.RandomCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 9:41
 */
@Controller
public class UserController {
    @Resource
    UserService userService;

    /*
     *跳转user.jsp页面 并查询用户信息
     * */
    @RequestMapping("/toAmdinUser")
    public String toAmdinUser(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                              @RequestParam(value = "loginname", required = false, defaultValue = "") String loginaccount,
                              @RequestParam(value = "gender", required = false, defaultValue = "") String sex,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, Model model) {
        Integer pageSize = 5;
        List<User> users = userService.selectByusernameAndloginaccountAndsex(username, loginaccount, sex, pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("list", pageInfo);
        model.addAttribute("username", username);
        model.addAttribute("loginname", loginaccount);
        model.addAttribute("gender", sex);
        return "/admin/user";
    }


    /* *添加用户控制器
     * */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user) {
        User user1 = userService.selectByloginaccount(user.getLoginaccount());
        if (user1 != null) {
            return "2";//登录账号已存在
        }
        user.setRegistrationtime(new Date());
        user.setAvataraddress("/static/images/userphotopath/1.png");
        user.setUserstatus(1);
        int i = userService.addUser(user);
        System.out.println(i);
        if (i > 0) {
            return "1";//添加成功
        } else {
            return "3";
        }
    }
   /* @RequestMapping("/addUser")
    public String addUser(User user, Model model) {
        User user1 = userService.selectByloginaccount(user.getLoginaccount());
        if (user1 != null) {
            model.addAttribute("msg", "登录账号已存在");
            return "/admin/user";
        }
        int i = userService.addUser(user);
        if (i > 0) {
            model.addAttribute("msg", "创建成功");
            return "/admin/user";
        } else {
            model.addAttribute("msg", "创建失败");
            return "/admin/user";
        }
    }*/

    /*
     *删除
     * */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public boolean deleteUser(Integer id) {

        int i = userService.delByid(id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 封号
     * */
    @RequestMapping("/closeUser")
    @ResponseBody
    public boolean closeUser(User user) {
        user.setUserstatus(0);
        int upduserstatus = userService.upduserstatus(user);
        if (upduserstatus > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     *跳转封号页面
     * */
    @RequestMapping("/closeList")
    public String closeList(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                            @RequestParam(value = "loginname", required = false, defaultValue = "") String loginaccount,
                            @RequestParam(value = "gender", required = false, defaultValue = "") String sex,
                            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, Model model) {
        Integer pageSize = 5;
        List<User> users = userService.selectByusernameAndloginaccountAndsex(username, loginaccount, sex, pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("list", pageInfo);
        model.addAttribute("loginname", loginaccount);
        return "/admin/closeList";
    }

    /*
     * 解封
     * */
    @RequestMapping("/openUser")
    @ResponseBody
    public boolean openUser(User user) {
        user.setUserstatus(1);
        int upduserstatus = userService.upduserstatus(user);
        if (upduserstatus > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取生成验证码显示到 UI 界面 验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomCode randomValidateCode = new RandomCode();
        try {
            //输出图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

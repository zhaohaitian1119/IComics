package com.gruop.cmoic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.service.AdminServicezht;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 11:42
 */
@Controller
public class AdminControllerzht {

    @Resource
    AdminServicezht adminService;

    @RequestMapping("/adminIndex")
    public String adminIndex(Model model){
        int countAdmin = adminService.countAdmin();
        int countUser = adminService.countUser();
        //留言总量
        int countMessage = adminService.countMessage();
        //封号数量
        int countClose = adminService.getCloseUsers().size();
        //浏览量 热度
        int countHeat = adminService.getHeats();
        //漫画总数
        int countComic = adminService.getComics().size();
        //评论数
        int countComment = adminService.getComments().size();
        model.addAttribute("countAdmin",countAdmin);
        model.addAttribute("countUser",countUser);
        model.addAttribute("countMessage",countMessage);
        model.addAttribute("countClose",countClose);
        model.addAttribute("countHeat",countHeat);
        model.addAttribute("countComic",countComic);
        model.addAttribute("countComment",countComment);
        return "/admin/home";
    }

    @RequestMapping("/getComics")
    public String getComics(Model model, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,2);
        List<Comic> comics = adminService.getComics();
        PageInfo<Comic> pageInfo = new PageInfo<>(comics);
        model.addAttribute("comicList",pageInfo);
        return "/admin/comicList";
    }
    @RequestMapping("/getComicSByOther")
    public String getComicSByOther(Comic comic,Model model,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Comic> lists = adminService.getComicSByOther(comic);
        PageInfo<Comic> pageInfo = new PageInfo<>(lists);
        model.addAttribute("comicList",pageInfo);
        return "admin/comicList";
    }
}

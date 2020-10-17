package com.gruop.cmoic.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.service.CommentListServicecx;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {
    @Resource
    CommentListServicecx commentListServicecx;

    @RequestMapping("/commentList")
    public String commentList(Model model, HttpServletRequest request){
        int Num=1;
        String pn=request.getParameter("pn");
        if(pn!=null){
            Num=Integer.parseInt(pn);
        }
        int pageSize=5;
        PageHelper.startPage(Num,pageSize);
        PageHelper.orderBy("id desc");
        List<News> news = commentListServicecx.selectAll(Num, pageSize);
        PageInfo pageInfo=new PageInfo(news);
        model.addAttribute("commentList",pageInfo);
        return "admin/commentList";
    }

    //根据漫画id查询
    @RequestMapping("/commentListByComicId")
    public String commentListByComicId(Integer comicid,Model model, HttpServletRequest request){
        int Num=1;
        String pn=request.getParameter("pn");
        if(pn!=null){
            Num=Integer.parseInt(pn);
        }
        int pageSize=5;
        PageHelper.startPage(Num,pageSize);
        PageHelper.orderBy("id desc");
        List<News> news = commentListServicecx.selectNewsId(comicid,Num, pageSize);
        PageInfo pageInfo=new PageInfo(news);
        model.addAttribute("commentList",pageInfo);
        return "admin/commentList";
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(int id){
        int del = commentListServicecx.del(id);
        return "redirect:/commentList";
    }
}

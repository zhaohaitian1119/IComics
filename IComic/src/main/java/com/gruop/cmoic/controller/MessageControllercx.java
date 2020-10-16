package com.gruop.cmoic.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.Information;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.service.MessageServicecx;
import com.mysql.fabric.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageControllercx {
    @Resource
    MessageServicecx messageServicecx;

    @RequestMapping("/messageList")
    public String messageList(Model model, HttpServletRequest request){
        int Num=1;
        String pn=request.getParameter("pn");
        if(pn!=null){
            Num=Integer.parseInt(pn);
        }
        int pageSize=5;
        PageHelper.startPage(Num,pageSize);
        PageHelper.orderBy("id desc");
        List<Information> information = messageServicecx.selectAll(Num, pageSize);
        PageInfo pageInfo=new PageInfo(information);
        model.addAttribute("messageList",pageInfo);
        return "admin/messageList";
    }

    @RequestMapping("/getByUserName")
    public String getByUserName(HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        System.out.println(name);
        List<Information> information = messageServicecx.selByUserName(name);
        PageInfo pageInfo=new PageInfo(information);
        model.addAttribute("messageList",pageInfo);
        return "admin/messageList";
    }

//    @RequestMapping("/static/deleteMessage")
//    @ResponseBody
//    public String deleteMessage(int id){
//        Map<String,Object> map=new HashMap<>();
//        int del = messageServicecx.del(id);
//        if(del>0){
//            map.put("data","ok");
//        }else{
//            map.put("data","no");
//        }
//        return JSONObject.toJSONString(map);
//    }

    @RequestMapping("/deleteMessage")
    public String deleteMessage(int id){
        int del = messageServicecx.del(id);
        return "redirect:/messageList";
    }
}

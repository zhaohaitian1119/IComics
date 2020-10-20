package com.gruop.cmoic.controller;

import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.service.ComicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ComicControllerjjs {
    @Resource
    ComicService comicService;

    /*
     * 分类首页默认查询全部
     * 并根据地区和进度查询
     * */
    @RequestMapping("/static/protfolio")
    public String protfolio(Model model,
                            @RequestParam(value = "area", required = false, defaultValue = " ") String area,
                            @RequestParam(value = "ccode", required = false, defaultValue = " ") String ccode) {

        List<Comic> comics = comicService.selectAll(area, ccode);
        model.addAttribute("comicList", comics);
        return "/index/protfolio";
    }

    /*
     *根据题材查询漫画
     * */
    @RequestMapping("/static/protfolio1")
    public String protfolio1(@RequestParam(value = "comiclistid", required = false, defaultValue = "0") Integer comiclistid,
                             Model model) {
        List<Comic> comics = comicService.selectByType(comiclistid);
        model.addAttribute("comicList", comics);
        return "/index/protfolio";
    }

}

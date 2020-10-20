package com.gruop.cmoic.controller;

import com.gruop.cmoic.pojo.Chapter;
import com.gruop.cmoic.pojo.Information;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.service.ChapterServicecx;
import com.gruop.cmoic.service.ComicServicecx;
import com.gruop.cmoic.service.CommentListServicecx;
import com.gruop.cmoic.service.MessageServicecx;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ChapterControllercx {
    @Resource
    ChapterServicecx chapterServicecx;
    @Resource
    CommentListServicecx commentListServicecx;

        @RequestMapping("/static/getUpdateChapter")
    public String getSingle(Model model){
        List<Chapter> chapters = chapterServicecx.selectAll();
        List<News> select = commentListServicecx.select();
        model.addAttribute("commentList",select);
        model.addAttribute("chapterList",chapters);
        return "index/blog";
    }

}

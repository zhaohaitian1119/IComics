package com.gruop.cmoic.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.Chapter;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.pojo.User;
import com.gruop.cmoic.service.AdminService;
import com.gruop.cmoic.service.AdminServicezht;
import com.gruop.cmoic.service.IndexServicezht;
import com.mysql.jdbc.PingTarget;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-18 14:00
 */
@Controller
public class IndexControllerzht {

    @Resource
    IndexServicezht indexService;
    @Resource
    AdminServicezht adminService;

    //初始化加载首页信息
    @RequestMapping("/")
    public String index(Model model){
        List<Comic> comics = indexService.selAll();
        model.addAttribute("heatList",comics);
        List<Comic> comicList = indexService.selComicOrderheat();
        model.addAttribute("timeList",comicList);
        //按地区对漫画进行排列
        Comic comic=new Comic();
        comic.setAddress("国漫");
        List<Comic> list=adminService.getComicSByOther(comic);
        comic.setAddress("日漫");
        List<Comic> list1=adminService.getComicSByOther(comic);
        comic.setAddress("欧美");
        List<Comic> list2=adminService.getComicSByOther(comic);
        model.addAttribute("guo",list);
        model.addAttribute("ri",list1);
        model.addAttribute("ou",list2);
        PageHelper.orderBy("uploadtime desc");
        List<Chapter> chapters = indexService.selChapterOrderupdatime();
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapters);
        model.addAttribute("zhang",pageInfo);
        return "/index/index";
    }

    //根据id查看漫画详细信息
    @RequestMapping("/getDetail")
    public  String getDetail(Integer id,Model model){
        Comic comic = indexService.selComicById(id);
        model.addAttribute("comic",comic);

        //按地区对漫画进行排列
        Comic comics=new Comic();
        comics.setAddress("国漫");
        List<Comic> list=adminService.getComicSByOther(comics);
        comics.setAddress("日漫");
        List<Comic> list1=adminService.getComicSByOther(comics);
        comics.setAddress("欧美");
        List<Comic> list2=adminService.getComicSByOther(comics);
        for (Comic comic1 : list2) {
            System.out.println(comic1);
        }
        //查询评论

        List<News> news = null;
        news = indexService.selNewsByComicId(id);
        for (News news1 : news) {
            if(news1.getUserid()!=null){
                List<User> users = indexService.selUserById(news1.getUserid());
                news1.setUsername(users.get(0).getUsername());
            }
        }



        //查看章节
        List<Chapter> chapters = adminService.selBycomicsId(id);
        model.addAttribute("guo",list);
        model.addAttribute("ri",list1);
        model.addAttribute("ou",list2);
        model.addAttribute("isFavorite",false);
        model.addAttribute("chapterList",chapters);
        model.addAttribute("commentList",news);
        return "/index/detail";
    }
    //根据id查询章节信息
    @RequestMapping("/getSingle")
    public String getSingle(Integer comicid,Integer cnumber,Model model){
        Chapter chapter = indexService.selByComicsdiBychapternum(comicid, cnumber);
        List<Comic> comicList = indexService.selComicsById(chapter.getComicsid());
        chapter.setComicsname(comicList.get(0).getComicname());
        model.addAttribute("chapter",chapter);
        return "/index/single-blog";
    }
}

package com.gruop.cmoic.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.pojo.Chapter;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.service.AdminServicezht;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2020-10-16 11:42
 */
@Controller
public class AdminControllerzht {

    @Resource
    AdminServicezht adminService;

    //动态查询后台首页数据
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

    //查询漫画详细信息 按时间排序
    @RequestMapping("/getComics")
    public String getComics(Model model, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Comic> comics = adminService.getComics();
        PageInfo<Comic> pageInfo = new PageInfo<>(comics);
        model.addAttribute("comicList",pageInfo);
        return "/admin/comicList";
    }
    //根据 名称 地区 作者 连载状态查询
    @RequestMapping("/getComicSByOther")
    public String getComicSByOther(Comic comic,Model model,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<Comic> lists = adminService.getComicSByOther(comic);
        PageInfo<Comic> pageInfo = new PageInfo<>(lists);
        model.addAttribute("comicList",pageInfo);
        return "admin/comicList";
    }
    //添加漫画信息
    @RequestMapping("/addComic")
    public String addChapter(MultipartFile file, Comic comic, HttpServletRequest request){
        //获取原文件名
        String oldFileName = file.getOriginalFilename();
        if(oldFileName == null || oldFileName.length() == 0){
            return "/admin/404.jsp";
        }
        if(file.getSize()>(1024*1024*1024)){
            return "/admin/404.jsp";
        }
        //获取上传路径
        String path = request.getSession().getServletContext().getRealPath("static/images/fengmian");
        //获取扩展名
        String prefix = FilenameUtils.getExtension(oldFileName);

        //生成新的文件名
        String newFileName = System.currentTimeMillis()+(RandomUtils.nextInt(1000)+".")+ prefix;
        //封装file对象
        File file1 = new File(path,newFileName);

        try {
            file.transferTo(file1);
            comic.setPhotopath("static/images/fengmian/"+newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        comic.setHeat(0);
        comic.setUpdatetime(new Date());
        int i = adminService.addComic(comic);
        if(i>0){
            return "redirect:/getComics";
        }else{
            return "/admin/404.jsp";
        }

    }

    /**
     * 删除漫画 通过漫画id
     * @param id
     * @return
     */
    @RequestMapping("/deleteComicById")
    @ResponseBody
    public boolean deleteComicById(int id){
        int a=adminService.deleteComicById(id);
        System.out.println(a);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }

    //根据漫画id查询章节信息
    @RequestMapping("/chapterList")
    public String chapterList(Integer comicid,Model model,@RequestParam(value = "pn",defaultValue = "1")Integer pn,HttpSession session){
        PageHelper.startPage(pn,5);
        List<Chapter> chapters = adminService.selBycomicsId(comicid);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapters);
        model.addAttribute("chapterList",pageInfo);
        session.setAttribute("comicid",comicid);
        System.out.println(comicid);
        return "/admin/chapterList";
    }

    //根据章节数模糊查询漫画
    @RequestMapping("/getChapterByNumber")
    public String getChapterByNumber(HttpServletRequest request,Model model){
        String cnumber = request.getParameter("cnumber");
        String comicid = request.getParameter("comicid");
        String cnumber1 = request.getParameter("cnumber");

        List<Chapter> chapter = adminService.getChapter(cnumber);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapter);
        model.addAttribute("chapterList",pageInfo);
        model.addAttribute("comicid",comicid);
        model.addAttribute("cnumber",cnumber1);
        return "/admin/chapterList";
    }

    //跳转到添加新章节页面
    @RequestMapping("/tz")
    public String tz(Integer comicid){
        System.out.println(comicid);
        return "/admin/addChapter";
    }

    //添加新章节
    @RequestMapping("/addChapter")
    public String addChapter(MultipartFile file, Chapter chapter, HttpServletRequest request){
        //获取原文件名
        String oldFileName = file.getOriginalFilename();
        if(oldFileName == null || oldFileName.length() == 0){
            return "/admin/404.jsp";
        }
        if(file.getSize()>(1024*1024*1024)){
            return "/admin/404.jsp";
        }
        //获取上传路径
        String path = request.getSession().getServletContext().getRealPath("static/images/fengmian");
        //获取扩展名
        String prefix = FilenameUtils.getExtension(oldFileName);

        //生成新的文件名
        String newFileName = System.currentTimeMillis()+(RandomUtils.nextInt(1000)+".")+ prefix;
        //封装file对象
        File file1 = new File(path,newFileName);

        try {
            file.transferTo(file1);
            chapter.setChaptercontentaddress("static/images/fengmian/"+newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chapter.setUploadtime(new Date());
        int i = adminService.addChapter(chapter);
        if(i>0){
            return "redirect:/getComics";
        }else{
            return "/admin/404.jsp";
        }

    }

    //根据章节id删除
    @RequestMapping("/deleteChapterById")
    @ResponseBody
    public boolean deleteChapterById(int id){
        int a=adminService.deleteChapterById(id);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }


}

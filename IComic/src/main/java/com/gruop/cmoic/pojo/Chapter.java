package com.gruop.cmoic.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private Integer id;

    private Integer comicsid;

    private Integer chapternum;

    private String chaptername;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date uploadtime;

    private String chaptercontentaddress;

    private Comic comic;

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComicsid() {
        return comicsid;
    }

    public void setComicsid(Integer comicsid) {
        this.comicsid = comicsid;
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername == null ? null : chaptername.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getChaptercontentaddress() {
        return chaptercontentaddress;
    }

    public void setChaptercontentaddress(String chaptercontentaddress) {
        this.chaptercontentaddress = chaptercontentaddress == null ? null : chaptercontentaddress.trim();
    }
}
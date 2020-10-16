package com.gruop.cmoic.pojo;

import java.util.Date;

public class Chapter {
    private Integer id;

    private Integer comicsid;

    private Integer chapternum;

    private String chaptername;

    private String content;

    private Date uploadtime;

    private String chaptercontentaddress;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
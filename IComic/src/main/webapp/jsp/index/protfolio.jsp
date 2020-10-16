<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/28
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="GFX, design" />
    <meta name="description" content="GFX Design" />
    <title>IComic漫画网</title>
    <link rel="shortcut icon"	href="/pic/userPath/1.png">
    <link rel="stylesheet" href="/static/css/reset.css" />
    <link rel="stylesheet" href="/static/css/style.css" />`
    <link rel="stylesheet" href="/static/css/myportfolio.css" />`
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/mycss.css">
    <!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
    <script type="text/javascript" src="/static/js/index/jquery-3.4.1.js"></script>
    <script src="/static/js/index/jquery-migrate-1.2.1.js"></script>
    <script type="text/javascript" src="/static/js/index/bootstrap.min.js"></script>
    <script type="text/javascript" src="/static/js/index/functions.js"></script>
    <script type="text/javascript" src="/static/js/index/my.js"></script>
</head>

<body class="portfolio">


<jsp:include page="navigation.jsp"/>

<!-- HERE START PAGE HEADER DESCRIPTION -->
<div id="all_page_header">
    <div class="bg_wood_page circle-inline-border"></div>
    <div class="elastic inline-border settings-clr no-second" id="page_header">
        <h1 class="over5">漫画列表</h1>
        <div class="intro-description over5">
            <p>我们的网站收录了大量的精品漫画</p>
            <p>穿越、玄幻、都市、冒险、仙侠等~  &emsp;总有一款适合你</p>
        </div>
    </div>
</div>
<!-- end of page header description -->

<!-- HERE START CONTENT -->
<div class="content elastic">
    <div id="book-list">
        <div class="field-wrap">
            <div class="pro-search">
                <dl class="field-list">
                    <dt>题&nbsp;&nbsp;材:</dt>
                    <dd><a class="active1" href="/static/protfolio">全部</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=1">总裁</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=2">玄幻</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=3">都市</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=4">冒险</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=5">仙侠</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=6">热血</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=7">恋爱</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=8">校园</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=9">武侠</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=10">悬疑</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=11">推理</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=12">治愈</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=13">穿越</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=14">搞笑</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=15">古风</a></dd>
                    <dd><a href="/static/protfolio1?comiclistid=16">后宫</a></dd>

                </dl></div>
            <br />
            <div class="pro-search">
                <dl class="field-list">
                    <dt>地&nbsp;&nbsp;区:</dt>
                    <dd><a class="active1" href="/static/protfolio">全部</a></dd>
                    <dd><a href="/static/protfolio?area=国漫">国漫</a></dd>
                    <dd><a href="/static/protfolio?area=日漫">日漫</a></dd>
                    <dd><a href="/static/protfolio?area=欧美">欧美</a></dd>
                </dl></div>
            <br />
            <div class="pro-search">
                <dl class="field-list">
                    <dt>进&nbsp;&nbsp;度:</dt>
                    <dd><a class="active1" href="/static/protfolio">全部</a></dd>
                    <dd><a href="/static/protfolio?ccode=连载">连载</a></dd>
                    <dd><a href="/static/protfolio?ccode=完结">完结</a></dd>
                </dl></div><br />
        </div>
    </div>
    <div class="space30"></div>
    <h1 class="title-line">&nbsp;</h1>
    <div class="space50"></div>
    <div class="space"></div>
    <div class="projects-band-nohidden">
        <ul class="book-item">
            <c:forEach items="${comicList}" var="comic"  begin="0" end="9">
            <li><a href="/static/getDetail?id=${comic.id}" class="inline-border"><img src="/pic/${comic.photopath}" alt="" width="200"
                                                       height="225" /></a>
                <div class="info">
                    <a href="#" class="description center">
                        <h4 class="title mytext-title">${comic.comicname}</h4>
                    </a>
                    <p class="author center mytext-p">【${comic.author}】</p>
                    <p class="type center mytext-p">${comic.comicListsString}</p>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
    <span class="dotted-line">&nbsp;</span>
    <span class="dotted-line">&nbsp;</span>
    <br>
    <div class="space50"></div>
    <div class="navigation">
        <a href="#" class="previous-page circle-inline-border settings-clr"><span
                class="title-portfolio">上一页</span></a>
        <a href="#" class="next-page circle-inline-border settings-clr"><span
                class="title-portfolio">下一页</span></a>
    </div>
</div> <!-- #content -->

<!-- HERE START FOOTER -->
<div id="footer" class="circle-inline-border">
    <div class="elastic">
        <div class="top_footer">
            <div class="footer_widget">
                <h3 class="general-font">Pages</h3>
                <ul>
                    <li><a href="index.jsp">Home Page</a></li>
                    <li><a href="about.jsp">About Page</a></li>
                    <li><a href="services.jsp">Services Page</a></li>
                    <li><a href="portfolio.jsp">Portfolio Page</a></li>
                    <li><a href="blog.jsp">Blog Page</a></li>
                    <li><a href="contact.jsp    ">Contact Page</a></li>
                </ul>
            </div><!-- .footer_widget_1 -->

            <div class="footer_widget">
                <h3 class="general-font">Services</h3>
                <ul>
                    <li><a href="#">Website Design</a></li>
                    <li><a href="#">Development</a></li>
                    <li><a href="#">Optimization</a></li>
                    <li><a href="#">Ecommerce</a></li>
                    <li><a href="#">Photography</a></li>
                    <li><a href="#">Branding</a></li>
                </ul>
            </div><!-- .footer_widget_2 -->

            <div class="footer_widget">
                <h3 class="general-font">Why Us?</h3>
                <ul>
                    <li><a href="#">Easy to Customize</a></li>
                    <li><a href="#">Userfriendly</a></li>
                    <li><a href="#">Pixel Perfect</a></li>
                    <li><a href="#">Clean & Modern</a></li>
                    <li><a href="#">Complete Pages</a></li>
                    <li><a href="#">Add Color You Like</a></li>
                </ul>
            </div><!-- .footer_widget_3 -->
            <div class="clear"></div>

            <div class="footer_image">
                <img class="inline-border active" src="/static/images/slider/footer_home.jpg" alt="" width="450"
                     height="250" />
                <img class="inline-border" src="/static/images/slider/footer_2.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_3.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_4.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_5.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_6.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_7.jpg" alt="" width="450" height="250" />
                <img class="inline-border" src="/static/images/slider/footer_8.jpg" alt="" width="450" height="250" />

                <ul class="social-icons">
                    <li class="vimeo-social"><a href="#">&nbsp;</a></li>
                    <li class="twitter-social"><a href="#">&nbsp;</a></li>
                    <li class="flickr-social"><a href="#">&nbsp;</a></li>
                    <li class="facebook-social"><a href="#">&nbsp;</a></li>
                    <li class="dribbble-social"><a href="#">&nbsp;</a></li>
                </ul>
            </div>
        </div>

        <div class="bottom_footer">
            <div class="left">
                <p>&copy; Copyright &copy; 2013.Company name All rights reserved. </p>
                <ul class="footer_menu">
                    <li><a href="#">Term of service</a>|</li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
            <div class="right area2">
                <p>Website designed by: <a href="#">GfxPartner</a></p>
                <p>888-888-888 | <a href="#">info@gfxpartner.com</a></p>
            </div>
            <div class="clear"></div>
        </div>
    </div> <!-- end of elastic -->
</div><!-- #footer -->

</body>

</html>
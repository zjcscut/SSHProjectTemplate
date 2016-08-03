<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/30
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>ZJC的博客</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ZJC的博客">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/img/bitbug_favicon.ico" type="image/x-icon">

    <!-- Bootstrap Docs -->
    <link href="<%=request.getContextPath()%>/static/js/bootstrap/css/docs.min.css" rel="stylesheet" media="screen">
    <%--Custom css--%>
    <link href="<%=request.getContextPath()%>/static/js/custom/blog.css" rel="stylesheet" media="screen">

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/theme/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/theme/css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/theme/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen"
          href="<%=request.getContextPath()%>/theme/css/bootstrap-admin-theme-change-size.css">


    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/theme/js/twitter-bootstrap-hover-dropdown.min.js"></script>


    <!-- Custom styles -->
    <style type="text/css">
        @font-face {
            font-family: Ubuntu;
            src: url('<%=request.getContextPath()%>/theme/fonts/Ubuntu-Regular.ttf');
        }

        .bs-docs-masthead {
            background: #6f5499 linear-gradient(to bottom, #563d7c 0px, #6f5499 100%) repeat-x;
        }

        .bs-docs-masthead {
            padding: 0;
        }

        .bs-docs-masthead h1 {
            color: #fff;
            font-size: 40px;
            margin: 0;
            padding: 34px 0;
            text-align: center;
        }

        .bs-docs-masthead a:hover {
            text-decoration: none;
        }

        .meritoo-logo a {
            background-color: #fff;
            border: 1px solid rgba(66, 139, 202, 0.4);
            display: block;
            font-family: Ubuntu;
            padding: 22px 0;
            text-align: center;
        }

        .meritoo-logo a,
        .meritoo-logo a:hover,
        .meritoo-logo a:focus {
            text-decoration: none;
        }

        .meritoo-logo a img {
            display: block;
            margin: 0 auto;
        }

        .meritoo-logo a span {
            color: #4e4b4b;
            font-size: 18px;
        }

        .row-urls {
            margin-top: 4px;
        }

        .row-urls .col-md-6 {
            text-align: center;
        }

        .row-urls .col-md-6 a {
            font-size: 14px;
        }
    </style>

</head>
<body class="bootstrap-admin-with-small-navbar">
<%@ include file="pub/navbar.jsp" %>

<div class="container">
    <!-- 左边的目录以及中部的主要内容 -->
    <div class="row">

        <!-- 左边的目录菜单 占3列 -->
        <div class="col-md-3 bootstrap-admin-col-left">
            <%--博主信息--%>
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=request.getContextPath()%>/static/img/bitbug_favicon.ico"/>
                    Author Info
                </div>

                <div class="user_image">
                    <img src="<%=request.getContextPath()%>/static/img/love.jpeg">
                </div>
                <div class="nickName">Zjc</div>
                <div class="userSign">Love Cartoon,Love Life,Love Technology</div>

            </div>

            <%--类型分类目录--%>
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=request.getContextPath()%>/static/img/bitbug_favicon.ico"/>
                    Categories
                </div>
                <div>
                    <ul id="menu_items_ul" class="nav navbar-collapse collapse bootstrap-admin-navbar-side">

                    </ul>
                </div>
            </div>

            <%--日期分类目录--%>
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=request.getContextPath()%>/static/img/bitbug_favicon.ico"/>
                    Categories By Date
                </div>
                <div>
                    <ul id="menu_date_ul" class="nav navbar-collapse collapse bootstrap-admin-navbar-side">

                    </ul>
                </div>
            </div>

        </div>

        <%--博客博文内容，10列--%>
        <div id="main_content" class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title"><a>Demo 1</a></div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <p>zjc</p>
                    <p>Copyright © 2016 - ZJCSCUT &lt;github [at] ZJCSCUT [dot] pl&gt;</p>
                    <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>
                    <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
                    <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">Demo 2</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <p>zjc</p>
                    <p>Copyright © 2016 - ZJCSCUT &lt;github [at] ZJCSCUT [dot] pl&gt;</p>
                    <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>
                    <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
                    <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">Demo 2</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <p>zjc</p>
                    <p>Copyright © 2016 - ZJCSCUT &lt;github [at] ZJCSCUT [dot] pl&gt;</p>
                    <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>
                    <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
                    <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="text-muted bootstrap-admin-box-title">Demo 2</div>
                </div>
                <div class="bootstrap-admin-panel-content">
                    <p>zjc</p>
                    <p>Copyright © 2016 - ZJCSCUT &lt;github [at] ZJCSCUT [dot] pl&gt;</p>
                    <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>
                    <p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>
                    <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>
                </div>
            </div>

        </div>

    </div>
</div>

<%--获取主菜单--%>

<script type="text/javascript">

    var loadMenuItems = function () {

        $("#main_navbar_ul a").click(function () {
            var s = $(this).attr("id");
            alert(s);
            $.ajax({
                url: "<%=request.getContextPath()%>/menu/item/" + s,
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    debugger
                    if (data != null) {
                        $("#menu_items_ul").html("");
                        $.each(data, function (i, value) {
                            var ss = "<li><a id = '" + value.id + "'>" +
                                    "<i class='glyphicon glyphicon-chevron-right'></i>"
                                    + value.name +
                                    "</a></li>";
                            $("#menu_items_ul").append(ss);
                        });
                    }
                },
                error: function () {
                    alert("出错了");
                }
            })
        });
    };

    loadMenuItems();

    // 控制字体大小
    $(function () {
        var sizeChangerContainer = '.bootstrap-admin-theme-change-size';

        $('.size-changer', sizeChangerContainer).on('click', function () {
            var setLargeSize = $(this).hasClass('large');

            if (setLargeSize && $('link[href^="<%=request.getContextPath()%>/theme/css/bootstrap-admin-theme"]').length === 2) {
                return false;
            }

            $(this).addClass('active');

            if (setLargeSize) {
                $('link[href="<%=request.getContextPath()%>/theme/css/bootstrap-admin-theme-small.css"]').remove();
                $('link[href="<%=request.getContextPath()%>/theme/css/bootstrap-small.css"]').remove();

                $('.small', sizeChangerContainer).removeClass('active');
                return true;
            }

            $('head').append('<link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/theme/css/bootstrap-small.css"><link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/theme/css/bootstrap-admin-theme-small.css">');
            $('.large', sizeChangerContainer).removeClass('active');
        });
    });


</script>


<%@include file="pub/footer.jsp" %>


</body>
</html>

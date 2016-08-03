<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/31
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    function checkEmpty() {
        var q = document.getElementById("q").value.trim();
        if (q == null || q == "") {
            alert("输入的关键字不能为空!");
            return false;
        } else {
            return true;
        }
    }
</script>

<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar-sm" role="navigation">
<div class="container">
    <div class="row">
        <div class="col-lg-12">

                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left bootstrap-admin-theme-change-size">
                        <li class="text"><span>Font Size</span></li>
                        <li><a class="size-changer small">Small</a></li>
                        <li><a class="size-changer large active">Large</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-left bootstrap-admin-theme-change-size">
                        <li class="text"><span>Language</span></li>
                        <li><a class="lang-changer active">Chinese</a></li>
                        <li><a class="lang-changer">English</a></li>
                    </ul>
                </div>
        </div>
    </div>
</div>
</nav>


<!-- 主导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small"
     role="navigation">
<div class="container">
    <div class="row">
        <div class="col-lg-12">

                <div class="navbar-header">
                    <%--响应式导航栏--%>
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".main-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Index</a>
                </div>

                <div class="collapse navbar-collapse main-navbar-collapse">
                    <ul id="main_navbar_ul" class="nav navbar-nav">
                        <%--<li>--%>
                            <%--<a id="1" href="<%=request.getContextPath()%>/main/navbar/java.html">Java</a>--%>
                        <%--</li>--%>

                        <li>
                            <a id="1" >Java</a>
                        </li>

                        <%--<li>--%>
                            <%--<a id="2" href="<%=request.getContextPath()%>/main/navbar/scala.html">Scala</a>--%>
                        <%--</li>--%>
                            <li>
                                <a id="2">Scala</a>
                            </li>

                        <%--<li>--%>
                            <%--<a id="3" href="<%=request.getContextPath()%>/main/navbar/life.html">Life</a>--%>
                        <%--</li>--%>

                            <li>
                                <a id="3">Life</a>
                            </li>

                        <%--<li>--%>
                            <%--<a id="4" href="<%=request.getContextPath()%>/main/navbar/about.html">About Me</a>--%>
                        <%--</li>--%>

                            <li>
                                <a id="4">About Me</a>
                            </li>
                    </ul>

                    <form action="<%=request.getContextPath()%>/main/navbar/search.html"
                          class="navbar-form navbar-right" role="search" method="post"
                          onsubmit="return checkEmpty()">
                        <div class="form-group">
                            <input type="text" id="q" name="q" value="" class="form-control"
                                   placeholder="请输入要查询的关键字...">
                        </div>
                        <button type="submit" class="btn btn-default"><span>搜索</span></button>
                    </form>
                </div>

        </div>

    </div>
</div>
</nav>


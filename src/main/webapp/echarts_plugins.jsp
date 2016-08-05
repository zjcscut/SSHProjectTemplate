<%--
  ~ Copyright (c) zjc@scut 2016~
  ~ Free of All
  ~ Help Yourselves!
  ~ Any bugs were found please contact me at 739805340scut@gmail.com
  --%>

<%--
  Created by IntelliJ IDEA.
  User: zhangjinci
  Date: 2016/8/5
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>echarts plugins</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
</head>
<body style="padding:0">
<div style="padding:10px;clear: both;">
    <div id="psLine" style="height:600px;"></div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/js/echarts2.0/echarts-all.js"></script>
<script type="text/javascript">
    //图表
    var psLineChar = echarts.init(document.getElementById('psLine'));

    //查询
    function loadDrugs() {
        psLineChar.clear();
        psLineChar.showLoading({text: '正在努力的读取数据中...'});
        $.getJSON('<%=request.getContextPath()%>/echart/plugins/data.html', function (data) {

            if (data.success) {
                psLineChar.setOption(data.data, true);
                psLineChar.hideLoading();
            } else {
                alert('提示',data.msg);
            }
        });
    }
    //载入图表
    loadDrugs();

</script>

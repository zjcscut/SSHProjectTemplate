<%--
  ~ Copyright (c) zjc@scut 2016~
  ~ Free of All
  ~ Help Yourselves!
  ~ Any bugs were found please contact me at 739805340scut@gmail.com
  --%>

<%--
  Created by IntelliJ IDEA.
  User: zhangjinci
  Date: 2016/8/6
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=request.getContextPath()%>/static/js/echarts2.0/echarts-all.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
    <title>Echarts BarLine Chart</title>
</head>
<body>
<div id="main" style="width: 1920px;height: 1080px"></div>
<script type="text/javascript">

    var  option = {
        tooltip : {
            trigger: 'axis'
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        legend: {
            data:['蒸发量','降水量','平均温度']
        },
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value',
                name : '水量',
                axisLabel : {
                    formatter: '{value} ml'
                }
            },
            {
                type : 'value',
                name : '温度',
                axisLabel : {
                    formatter: '{value} °C'
                }
            }
        ],
        series : [

            {
                name:'蒸发量',
                type:'bar',
                data:[]
            },
            {
                name:'降水量',
                type:'bar',
                data:[]
            },
            {
                name:'平均温度',
                type:'line',
                yAxisIndex: 1,
                data:[]
            }
        ]
    };

//    模拟插入数据
    var  data1=[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3];
    var data2 = [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3];
    var data3 = [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2];


    //基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));

    var load = function(){
        option.series[0].data = data1;
        option.series[1].data = data2;
        option.series[2].data = data3;
        myChart.setOption(option);
    };

    // 异步加载数据
    <%--$.getJSON('<%=request.getContextPath()%>/echart/data/get.html').done(function (data) {--%>
        <%--// 填入数据--%>
        <%--myChart.setOption({--%>
            <%--series: [{}, {--%>
                <%--markPoint: {--%>
                    <%--data: data--%>
                <%--}--%>
            <%--}]--%>
        <%--});--%>
    <%--});--%>

    load();

</script>

</body>
</html>

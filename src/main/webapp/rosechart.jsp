<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=request.getContextPath()%>/static/js/echarts2.0/echarts-all.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
    <title>Rose Chart</title>
</head>
<body>
<div id="main" style="width: 600px;height: 400px"></div>
<script type="text/javascript">

    //基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));

//    var app = {};

    myChart.showLoading();
    // 异步加载数据
    $.getJSON('<%=request.getContextPath()%>/echart/rosechart/data.html').done(function (data) {
        myChart.hideLoading();
        // 填入数据
        // 指定图表的配置项和数据
        myChart.setOption({
            title: {
                text: '南丁格尔玫瑰图',
                subtext: '纯属虚构',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                x: 'center',
                y: 'bottom',
                data: data.names
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {
                        show: true,
                        type: ['funnel']
                    },
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            series: [
                {
                    name: '面积模式',
                    type: 'pie',
                    radius: [30, 110],
                    center: ['50%', 200],
                    roseType: 'area',
                    x: '50%',               // for funnel
                    max: 40,                // for funnel
                    sort: 'ascending',     // for funnel
                    data:data.datas
                }
            ]
        });
    });

//    app.currentIndex = -1;
//
//    app.timeTicket = setInterval(function () {
//        var dataLen = option.series[0].data.length;
//        // 取消之前高亮的图形
//        myChart.dispatchAction({
//            type: 'downplay',
//            seriesIndex: 0,
//            dataIndex: app.currentIndex
//        });
//        app.currentIndex = (app.currentIndex + 1) % dataLen;
//        // 高亮当前图形
//        myChart.dispatchAction({
//            type: 'highlight',
//            seriesIndex: 0,
//            dataIndex: app.currentIndex
//        });
//        // 显示 tooltip
//        myChart.dispatchAction({
//            type: 'showTip',
//            seriesIndex: 0,
//            dataIndex: app.currentIndex
//        });
//    }, 1000);

</script>
</body>
</html>

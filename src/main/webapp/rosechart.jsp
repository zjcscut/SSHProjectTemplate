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
<div id="main" style="width: 1000px;height: 800px"></div>
<script type="text/javascript">

    //基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));

    myChart.setOption({
        title : {
            text: '虚拟信用卡进件省份分布玫瑰图',
            subtext: '数据暂时虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['广东','福建','北京','上海','重庆','广西','天津','湖南']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'进件数',
                type:'pie',
                radius : [20, 110],
                center : ['25%', 200],
                roseType : 'radius',
                width: '40%',       // for funnel
                max: 40,            // for funnel
                itemStyle : {
                    normal : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : true
                        },
                        labelLine : {
                            show : true
                        }
                    }
                },
                data:[
                    {value:100, name:'广东'},
                    {value:50, name:'福建'},
                    {value:15, name:'北京'},
                    {value:25, name:'上海'},
                    {value:20, name:'重庆'},
                    {value:35, name:'广西'},
                    {value:30, name:'天津'},
                    {value:40, name:'湖南'}
                ]
            },
            {
                name:'进件数',
                type:'pie',
                radius : [30, 110],
                center : ['75%', 200],
                roseType : 'area',
                x: '50%',               // for funnel
                max: 40,                // for funnel
                sort : 'ascending',     // for funnel
                data:[
                    {value:100, name:'广东'},
                    {value:50, name:'福建'},
                    {value:15, name:'北京'},
                    {value:25, name:'上海'},
                    {value:20, name:'重庆'},
                    {value:35, name:'广西'},
                    {value:30, name:'天津'},
                    {value:40, name:'湖南'}
                ]
            }
        ]
    });
//    var app = {};

    <%--myChart.showLoading();--%>
    <%--// 异步加载数据--%>
    <%--$.getJSON('<%=request.getContextPath()%>/echart/rosechart/data.html').done(function (data) {--%>
        <%--myChart.hideLoading();--%>
        <%--// 填入数据--%>
        <%--// 指定图表的配置项和数据--%>
        <%--myChart.setOption({--%>
            <%--title: {--%>
                <%--text: '南丁格尔玫瑰图',--%>
                <%--subtext: '纯属虚构',--%>
                <%--x: 'center'--%>
            <%--},--%>
            <%--tooltip: {--%>
                <%--trigger: 'item',--%>
                <%--formatter: "{a} <br/>{b} : {c} ({d}%)"--%>
            <%--},--%>
            <%--legend: {--%>
                <%--x: 'center',--%>
                <%--y: 'bottom',--%>
                <%--data: data.names--%>
            <%--},--%>
            <%--toolbox: {--%>
                <%--show: true,--%>
                <%--feature: {--%>
                    <%--mark: {show: true},--%>
                    <%--dataView: {show: true, readOnly: false},--%>
                    <%--magicType: {--%>
                        <%--show: true,--%>
                        <%--type: ['funnel']--%>
                    <%--},--%>
                    <%--restore: {show: true},--%>
                    <%--saveAsImage: {show: true}--%>
                <%--}--%>
            <%--},--%>
            <%--calculable: true,--%>
            <%--series: [--%>
                <%--{--%>
                    <%--name: '面积模式',--%>
                    <%--type: 'pie',--%>
                    <%--radius: [30, 110],--%>
                    <%--center: ['50%', 200],--%>
                    <%--roseType: 'area',--%>
                    <%--x: '50%',               // for funnel--%>
                    <%--max: 40,                // for funnel--%>
                    <%--sort: 'ascending',     // for funnel--%>
                    <%--data:data.datas--%>
                <%--}--%>
            <%--]--%>
        <%--});--%>
    <%--});--%>

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

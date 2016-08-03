<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/3
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="<%=request.getContextPath()%>/static/js/echarts2/echarts.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
    <title>Echarts Map</title>
</head>

<body>
<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
<!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->

<div id="mainMap" style="height:800px;border:1px solid #ccc;padding:10px; width: 1600px"></div>

<script type="text/javascript">

    /*
     [{name: '大庆', value: [125.03,46.58,279]},{name: '菏泽', value: [115.480656,35.23375,194]}]
     [{name: '廊坊', value: [116.7,39.53,193]},{name: '武汉', value: [114.31,30.52,273]},{name: '衢州', value: [118.88,28.97,177]}]
     */
    var $xjdData = [{name: '大庆', value: 279, geoCoord: [125.03, 46.58]}, {
        name: '菏泽',
        geoCoord: [115.480656, 35.23375],
        value: 194
    }, {name: '广州', value: 100}];
    var $xfdData = [{name: '廊坊', geoCoord: [116.7, 39.53], value: 193}, {
        name: '武汉',
        geoCoord: [114.31, 30.52],
        value: 273
    }, {name: '衢州', geoCoord: [118.88, 28.97], value: 177}];
    // var converXjdData =function(){
    //     var res = [];
    //     var geoCoord;
    //     for (var len = 0; len < placeList.length; len++) {
    //         geoCoord =   geoCoordMap[placeList[len].name];

    //         res.push({
    //             name : placeList[len].name ,
    //             value : placeList[len].value,
    //             geoCoord : [
    //                 geoCoord[0] + Math.random() * 5 - 2.5,
    //                 geoCoord[1] + Math.random() * 3 - 1.5
    //             ],
    //             selected: true
    //         })
    //     }
    //     return res;
    // };
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths: {
            echarts: '<%=request.getContextPath()%>/static/js/echarts2/js'
        }
    });

    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    require(
            [
                'echarts',
                'echarts/chart/map'
            ],
            displayChart
    );

    function displayChart(ec) {


        // --- 地图 ---
        var myChart2 = ec.init(document.getElementById('mainMap'));


        myChart2.setOption({
            backgroundColor: '#1b1b1b',
            /* color: ['gold', 'aqua', 'lime'],*/
            color: [
                'rgba(37, 140, 249, 0.8)',
                'rgba(14, 241, 242, 0.8)'
                /* 'rgba(37, 140, 249, 0.8)'*/
            ],
            title: {
                text: '虚拟信用卡业务省份分布',
                subtext: '数据暂时虚构',
                x: 'center',
                textStyle: {
                    color: '#fff'
                }
            },

            legend: {
                orient: 'vertical',
                x: 'left',
                data: ['实名认证城市分布', '进件城市分布'],
                selectedMode: 'single',
                selected: {
                    '实名认证城市分布': false,
                    '进件城市分布': false
                },
                textStyle: {
                    color: '#fff'
                }
            },
            series: [
                {
                    name: '全国',
                    type: 'map',
                    roam: true,
                    hoverable: false,
                    mapType: 'china',
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,//显示地图标识的省份
                                textStyle: {color: '#FFFFFF'}//字体颜色

                            },
                            borderColor: 'rgba(100,149,237,1)',
                            borderWidth: 0.5,
                            areaStyle: {
                                color: '#1b1b1b'
                            }
                        }
                    },
                    geoCoord: {
                        '上海': [121.4648, 31.2891],
                        '东莞': [113.8953, 22.901],
                        '东营': [118.7073, 37.5513],
                        '中山': [113.4229, 22.478],
                        '临汾': [111.4783, 36.1615],
                        '临沂': [118.3118, 35.2936],
                        '丹东': [124.541, 40.4242],
                        '丽水': [119.5642, 28.1854],
                        '乌鲁木齐': [87.9236, 43.5883],
                        '佛山': [112.8955, 23.1097],
                        '保定': [115.0488, 39.0948],
                        '兰州': [103.5901, 36.3043],
                        '包头': [110.3467, 41.4899],
                        '北京': [116.4551, 40.2539],
                        '北海': [109.314, 21.6211],
                        '南京': [118.8062, 31.9208],
                        '南宁': [108.479, 23.1152],
                        '南昌': [116.0046, 28.6633],
                        '南通': [121.1023, 32.1625],
                        '厦门': [118.1689, 24.6478],
                        '台州': [121.1353, 28.6688],
                        '合肥': [117.29, 32.0581],
                        '呼和浩特': [111.4124, 40.4901],
                        '咸阳': [108.4131, 34.8706],
                        '哈尔滨': [127.9688, 45.368],
                        '唐山': [118.4766, 39.6826],
                        '嘉兴': [120.9155, 30.6354],
                        '大同': [113.7854, 39.8035],
                        '大连': [122.2229, 39.4409],
                        '天津': [117.4219, 39.4189],
                        '太原': [112.3352, 37.9413],
                        '威海': [121.9482, 37.1393],
                        '宁波': [121.5967, 29.6466],
                        '宝鸡': [107.1826, 34.3433],
                        '宿迁': [118.5535, 33.7775],
                        '常州': [119.4543, 31.5582],
                        '广州': [113.5107, 23.2196],
                        '廊坊': [116.521, 39.0509],
                        '延安': [109.1052, 36.4252],
                        '张家口': [115.1477, 40.8527],
                        '徐州': [117.5208, 34.3268],
                        '德州': [116.6858, 37.2107],
                        '惠州': [114.6204, 23.1647],
                        '成都': [103.9526, 30.7617],
                        '扬州': [119.4653, 32.8162],
                        '承德': [117.5757, 41.4075],
                        '拉萨': [91.1865, 30.1465],
                        '无锡': [120.3442, 31.5527],
                        '日照': [119.2786, 35.5023],
                        '昆明': [102.9199, 25.4663],
                        '杭州': [119.5313, 29.8773],
                        '枣庄': [117.323, 34.8926],
                        '柳州': [109.3799, 24.9774],
                        '株洲': [113.5327, 27.0319],
                        '武汉': [114.3896, 30.6628],
                        '汕头': [117.1692, 23.3405],
                        '江门': [112.6318, 22.1484],
                        '沈阳': [123.1238, 42.1216],
                        '沧州': [116.8286, 38.2104],
                        '河源': [114.917, 23.9722],
                        '泉州': [118.3228, 25.1147],
                        '泰安': [117.0264, 36.0516],
                        '泰州': [120.0586, 32.5525],
                        '济南': [117.1582, 36.8701],
                        '济宁': [116.8286, 35.3375],
                        '海口': [110.3893, 19.8516],
                        '淄博': [118.0371, 36.6064],
                        '淮安': [118.927, 33.4039],
                        '深圳': [114.5435, 22.5439],
                        '清远': [112.9175, 24.3292],
                        '温州': [120.498, 27.8119],
                        '渭南': [109.7864, 35.0299],
                        '湖州': [119.8608, 30.7782],
                        '湘潭': [112.5439, 27.7075],
                        '滨州': [117.8174, 37.4963],
                        '潍坊': [119.0918, 36.524],
                        '烟台': [120.7397, 37.5128],
                        '玉溪': [101.9312, 23.8898],
                        '珠海': [113.7305, 22.1155],
                        '盐城': [120.2234, 33.5577],
                        '盘锦': [121.9482, 41.0449],
                        '石家庄': [114.4995, 38.1006],
                        '福州': [119.4543, 25.9222],
                        '秦皇岛': [119.2126, 40.0232],
                        '绍兴': [120.564, 29.7565],
                        '聊城': [115.9167, 36.4032],
                        '肇庆': [112.1265, 23.5822],
                        '舟山': [122.2559, 30.2234],
                        '苏州': [120.6519, 31.3989],
                        '莱芜': [117.6526, 36.2714],
                        '菏泽': [115.6201, 35.2057],
                        '营口': [122.4316, 40.4297],
                        '葫芦岛': [120.1575, 40.578],
                        '衡水': [115.8838, 37.7161],
                        '衢州': [118.6853, 28.8666],
                        '西宁': [101.4038, 36.8207],
                        '西安': [109.1162, 34.2004],
                        '贵阳': [106.6992, 26.7682],
                        '连云港': [119.1248, 34.552],
                        '邢台': [114.8071, 37.2821],
                        '邯郸': [114.4775, 36.535],
                        '郑州': [113.4668, 34.6234],
                        '鄂尔多斯': [108.9734, 39.2487],
                        '重庆': [107.7539, 30.1904],
                        '金华': [120.0037, 29.1028],
                        '铜川': [109.0393, 35.1947],
                        '银川': [106.3586, 38.1775],
                        '镇江': [119.4763, 31.9702],
                        '长春': [125.8154, 44.2584],
                        '长沙': [113.0823, 28.2568],
                        '长治': [112.8625, 36.4746],
                        '阳泉': [113.4778, 38.0951],
                        '青岛': [120.4651, 36.3373],
                        '韶关': [113.7964, 24.7028]
                    },
                    data: []

                },
                {
                    name: '实名认证城市分布',
                    type: 'map',
                    mapType: 'china',
                    data: [],

                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: function (v) {
                            return 10 + v / 10
                        },
                        effect: {
                            show: true,
                            shadowBlur: 0
                        },
                        itemStyle: {
                            normal: {
                                label: {show: false}
                            },
                            emphasis: {
                                label: {position: 'top'}
                            }
                        },
                        data: $xfdData
                    }
                },
                {
                    name: '进件城市分布',
                    type: 'map',
                    mapType: 'china',
                    data: [],

                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: function (v) {
                            return 10 + v / 10
                        },
                        effect: {
                            show: true,
                            shadowBlur: 0
                        },
                        itemStyle: {
                            normal: {
                                label: {show: false}
                            },
                            emphasis: {
                                label: {position: 'top'}
                            }
                        },

                        data: $xjdData
                    }
                }

            ]
        });
    }
</script>


</body>
</html>


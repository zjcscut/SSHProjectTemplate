<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>TempalteJs解析多种格式的Json</title>
    <%--<link rel="stylesheet" type="text/css" href="style.css">--%>
</head>
<body>
<div id="container"></div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/template/template.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
<script id="demo" type="text/html">
    {{if isAdmin}}
    <div id="nav">
        <div class="menu-main">
            {{each list as value i}}
            <li class="nav-menu"><a href="javascript:void(0);">第一层遍历结果===>:{{i}}</a></li>
            {{/each}}
        </div>
    </div>
    <div class="sub-nav">
        {{each list as value i}}
        <ul class="sub-nav-items">
            {{each list[i] as value j}}
            <li class="nav-item"><a href="javascript:void(0);">第二层遍历结果:====>{{j}}</a></li>
            {{/each}}
        </ul>
        {{/each}}
    </div>
    <div class="filter-content">
        <div class="filter-section">
            {{each list as value i}}
            {{each list[i] as value j}}
            <div class="filter-list">
                {{each list[i][j] as value k}}
                <a href="javascript:void(0);" class="filter-sel">第三层遍历结果:=====>{{value}}</a>
                {{/each}}
            </div>
            {{/each}}
            {{/each}}
        </div>
    </div>
    {{/if}}

    <hr>
    <hr>
    <div class="sub-nav">
        {{each testL as value i}}
        <ul class="sub-nav-items">
            {{each testL[i] as value j}}
            <li class="nav-item"><a href="javascript:void(0);">第二层遍历结果:====>{{j}}:{{value}}</a></li>
            {{/each}}
        </ul>
        {{/each}}
    </div>

    <hr>
    <hr>

    <div class="sub-nav">
        {{each top_ten_call_out_phone_num_tuple_list as value i}}
        <ul class="sub-nav-items">
            {{each top_ten_call_out_phone_num_tuple_list[i] as value j}}
            <li class="nav-item"><a href="javascript:void(0);">第二层遍历结果:====>{{j}}:{{value}}</a></li>
            {{/each}}
        </ul>
        {{/each}}
    </div>

    <%--多层json迭代--%>
    <hr>
    <hr>
    <div class="filter-content">
        <div class="filter-section">
            {{each contacts_wecash_user_dict as value i}}
            <%--这里第一层的值竟然是 i, 无语--%>
            <div><strong>{{contacts_wecash_user_dict[i].last_call_time}}</strong></div>
            <%--遍历全部值,不灵活--%>
            <%--{{each contacts_wecash_user_dict[i] as val j}}--%>
             <%--<li>{{val}}</li>--%>
            <%--{{/each}}--%>
            <hr>
            {{/each}}
        </div>
    </div>

    <%--多层json迭代，跟json取值方式一致，注意脚标--%>
    <hr>
    <hr>
    <div class="filter-content">
        <div class="filter-section">
            {{each contacts_wecash_user_dict as value i}}
            <%--这里第一层的值竟然是 i, 无语--%>
            <div><strong>{{i}}</strong></div>
            <%--遍历全部值,不灵活--%>
            {{each contacts_wecash_user_dict[i] as val j}}
            <li>{{val}}</li>
            {{/each}}
            <hr>
            {{/each}}
        </div>
    </div>


    <hr>
    <hr>
    <%--指定for循环次数 total_contact_list--%>
    <div class="filter-content">
        {{each total_contact_list as value i}}
        {{if i < 5}}
        <span><strong>索引:{{i}},值:{{value}}</strong></span>
        {{/if}}
        {{/each}}
    </div>

    <%--一维数组，元素是对象--%>
    <%-- total_contact_info--%>

    <hr>
    <hr>
    <div class="filter-content">
        {{each total_contact_info as value i}}
        <span><strong>{{total_contact_info[i].last_call_time}}</strong></span>
        {{/each}}
    </div>

</script>


<script>
    var data = {
        isAdmin: true,
        list: {
            "电视": {
                "大陆剧": ["好大一个家", "平凡的世界", "收获的季节", "刘老根", "乡村爱情", "士兵突击", "神探狄仁杰", "武媚娘传奇"],
                "美剧": ["吸血鬼日记", "闪电侠", "行尸走肉", "童话镇", "破产姐妹", "格林"],
                "台剧": ["有爱一家人", "再见阿郎", "我的宝贝四千金", "新白娘子传奇"],
                "韩剧": ["来自星星的你", "匹诺曹", "奔跑吧玫瑰", "美女的诞生", "未来的选择",],
            },
            "电影": {
                "动作": ["A计划", "警察故事", "黄飞鸿", "特务迷城", "卧虎藏龙", "逗你玩"],
                "爱情": ["保定爱情", "山楂树之恋", "北京遇上西雅图"],
                "恐怖": ["僵尸家族", "驱鬼警察", "僵尸道长"]
            },
            "综艺": {
                "百变大咖秀": ["第一期", "第二期", "第二期", "第四期"],
                "快乐大本营": ["谢娜", "何炅", "维嘉", "杜海涛", "吴昕"],
                "天天向上": ["汪涵", "欧弟", "田园", "钱枫", "小五"],
                "康熙来了": ["小S", "蔡康永", "赵薇", "萧敬腾", "阿雅", "吴宗宪"]
            }
        },
        testL: [
            [1, 2],
            [3, 4],
            [5, 6]
        ],

        top_ten_call_out_phone_num_tuple_list: [
            [
                "558",
                44
            ],
            [
                "13929597828",
                9
            ],
            [
                "557",
                7
            ],
            [
                "13533773778",
                6
            ],
            [
                "13538898911",
                6
            ],
            [
                "13527690641",
                4
            ],
            [
                "34133221",
                4
            ],
            [
                "13682211388",
                3
            ],
            [
                "13268133257",
                3
            ],
            [
                "61643888",
                3
            ]
        ],
        contacts_wecash_user_dict: {
            "13527690641": {
                "total_time": 1116,
                "seller_name": "",
                "last_call_time": "2016-06-09 14:19:11",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 683,
                "is_current_overdue": "",
                "total_count": 16,
                "customer_type": "企业主",
                "have_call_info": 1,
                "amount": 0,
                "call_out_time": 433,
                "company_name": "",
                "call_out_count": 4,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 12,
                "comments": ""
            },
            "18613100228": {
                "total_time": 422,
                "seller_name": "",
                "last_call_time": "2016-03-29 15:51:42",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 422,
                "is_current_overdue": "",
                "total_count": 5,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": "200.0",
                "call_out_time": 0,
                "company_name": "广州万惠",
                "name": "罗亮",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 5,
                "comments": ""
            },
            "13631368434": {
                "total_time": 60,
                "seller_name": "",
                "last_call_time": "2016-06-22 16:43:03",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 60,
                "is_current_overdue": "",
                "total_count": 2,
                "customer_type": "企业主",
                "have_call_info": 1,
                "amount": 0,
                "call_out_time": 0,
                "company_name": "",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 2,
                "comments": ""
            },
            "13751729500": {
                "total_time": 100,
                "seller_name": "",
                "last_call_time": "2016-06-14 19:33:01",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 100,
                "is_current_overdue": "",
                "total_count": 2,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": "4120.0",
                "call_out_time": 0,
                "company_name": "PPmoney",
                "name": "王晖",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 2,
                "comments": ""
            },
            "13268133257": {
                "total_time": 2327,
                "seller_name": "",
                "last_call_time": "2016-07-12 19:25:24",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 1850,
                "is_current_overdue": "",
                "total_count": 19,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": "4520.0",
                "call_out_time": 477,
                "company_name": "PPmoney",
                "name": "向刚",
                "call_out_count": 3,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 16,
                "comments": ""
            },
            "13922411729": {
                "total_time": 64,
                "seller_name": "",
                "last_call_time": "2016-03-02 11:16:33",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 64,
                "is_current_overdue": "",
                "total_count": 2,
                "customer_type": "企业主",
                "have_call_info": 1,
                "amount": 0,
                "call_out_time": 0,
                "company_name": "",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 2,
                "comments": ""
            },
            "13902345657": {
                "total_time": 11,
                "seller_name": "",
                "last_call_time": "2016-03-21 12:21:29",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 11,
                "is_current_overdue": "",
                "total_count": 1,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": "0.0",
                "call_out_time": 0,
                "company_name": "北京万古恒信科技有限公司",
                "name": "刘志伟",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 1,
                "comments": ""
            },
            "15999966300": {
                "total_time": 204,
                "seller_name": "",
                "last_call_time": "2016-02-01 14:47:42",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 204,
                "is_current_overdue": "",
                "total_count": 1,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": 0,
                "call_out_time": 0,
                "company_name": "ppmoney",
                "name": "沙才洪",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 1,
                "comments": ""
            },
            "13926459770": {
                "total_time": 515,
                "seller_name": "",
                "last_call_time": "2016-02-18 17:17:15",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 515,
                "is_current_overdue": "",
                "total_count": 4,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": 0,
                "call_out_time": 0,
                "company_name": "广州万惠投资管理公司",
                "name": "脉剑菲",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 4,
                "comments": ""
            },
            "18617321792": {
                "total_time": 271,
                "seller_name": "",
                "last_call_time": "2016-04-12 19:35:44",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 271,
                "is_current_overdue": "",
                "total_count": 1,
                "customer_type": "企业主",
                "have_call_info": 1,
                "amount": "200.0",
                "call_out_time": 0,
                "company_name": "",
                "name": "许攀",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 1,
                "comments": ""
            },
            "15602286236": {
                "total_time": 33,
                "seller_name": "",
                "last_call_time": "2016-05-26 18:36:17",
                "school_name": "",
                "max_overdue_day": 0,
                "is_overdue": 0,
                "apply_status": "",
                "call_in_time": 33,
                "is_current_overdue": "",
                "total_count": 2,
                "customer_type": "白领",
                "have_call_info": 1,
                "amount": "0.0",
                "call_out_time": 0,
                "company_name": "广州万惠",
                "name": "杨淑娟",
                "call_out_count": 0,
                "risk_info": "",
                "seller_type": "",
                "channel": "闪银",
                "call_in_count": 2,
                "comments": ""
            }
        },
        total_contact_list: [
            "558",
            "13060997050",
            "13929597828",
            "13538898911",
            "13802516680",
            "4007280312",
            "13570999559",
            "13556016422",
            "13533773778",
            "13268133257",
            "02062651473",
            "02085505470",
            "02061005621",
            "01057794628",
            "13533103987",
            "84494477",
            "4006018125",
            "02028087036",
            "4000633491",
            "13527690641",
            "84783579",
            "34784360",
            "13751729500",
            "02066644577",
            "13682211388",
            "13250558882",
            "13631368434",
            "02062651470",
            "057188157855",
            "13602469995",
            "18664541117",
            "557",
            "02062651471",
            "13924279347",
            "02066209621",
            "4001696188",
            "02869514652",
            "02869514651",
            "07609501330013",
            "15920109602",
            "15814825147",
            "4008440001",
            "05373254086",
            "075588644822",
            "13533059725",
            "15602286236",
            "13249751652",
            "34133221",
            "02160651475",
            "02066646088",
            "02161116451",
            "4009998877",
            "61643888",
            "84128667",
            "15626094211",
            "17710215012",
            "13826059865",
            "02029831009",
            "02066695509",
            "02124099106",
            "051289178348",
            "4000966288",
            "4008262688",
            "4001871125",
            "18617321792",
            "0099041513080",
            "18620224285",
            "15918838038",
            "051289178091",
            "02029197747",
            "4001016192",
            "02037765485",
            "02037197303",
            "02124099108",
            "4001699873",
            "18620721927",
            "13922411729",
            "4001013526",
            "13802617749",
            "15018401814",
            "18613100228",
            "13710050970",
            "02462784901",
            "13902345657",
            "95597",
            "125909888116",
            "02131833392",
            "15999966300",
            "13926459770",
            "02089178230",
            "013527690641",
            "12345",
            "13922244076",
            "18998480702",
            "06632363192",
            "18806631050",
            "13826081167",
            "15102004500",
            "4001613093",
            "9501360011",
            "02028835200",
            "15102009500",
            "18062577179",
            "13143699898"
        ],

        total_contact_info: [
            {
                "call_in_count": 2,
                "phone": "13751727166",
                "phone_book_name": "",
                "total_count": 3,
                "call_out_time": 7,
                "last_call_time": "2016-07-05 12:30:54",
                "call_out_count": 1,
                "total_time": 17,
                "call_in_time": 10
            },
            {
                "call_in_count": 0,
                "phone": "13662465615",
                "phone_book_name": "",
                "total_count": 1,
                "call_out_time": 5,
                "last_call_time": "2016-07-11 16:11:05",
                "call_out_count": 1,
                "total_time": 5,
                "call_in_time": 0
            },
            {
                "call_in_count": 22,
                "phone": "18680503026",
                "phone_book_name": "",
                "total_count": 22,
                "call_out_time": 0,
                "last_call_time": "2016-07-05 17:39:32",
                "call_out_count": 0,
                "total_time": 234,
                "call_in_time": 234
            }
        ]
    };
    var html = template('demo', data);
    document.getElementById('container').innerHTML = html;
    //注册tabs方法
    $(document).on('click', 'a', function (e) {
        var target = $(e.currentTarget).parent();
        var $self = $(target);
        if (target.hasClass("nav-menu")) {
            $(".filter-list").hide();
            $(".sub-nav-items").hide().eq($self.index()).show();
        } else if (target.hasClass("nav-item")) {
            $(".filter-list").hide().eq($(".nav-item").index($self)).show();
        }
    })
</script>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>自动计算thead的宽度以适应下面的td</title>
    <meta charset="UTF-8"/>
    <style>
        table tbody {
            display: block;
            height: 195px;
            overflow-y: scroll;
        }

        table thead, tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        table thead {
            width: calc(100% - 1.1em)
        }

        table thead th {
            background: #ccc;
        }
    </style>

    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery/jquery.min.js"></script>
</head>
<body>
<table id="area" width="100%" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>省</th>
        <th>PID</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>


<script type="text/javascript">


    $(function () {
        $.ajax({
            url: "<%=request.getContextPath()%>/async/getData.html",
            type: 'POST',
            dataType: 'json',
            success: function (data) {
                if (data.msg == '0') {
                    var areas = data.areas;
                    $.each(areas,function (i, value) {
                        var html = "<tr><td>" + value.id + "</td>"
                                + "<td>" + value.name + "</td>"
                                + "<td>" + value.pid + "</td></tr>";
                        $("#area").find("tbody").append(html);
                    });
                }
            },
            error: function () {
                alert("异步请求失败");
            }
        });
    })
</script>

</body>
</html>

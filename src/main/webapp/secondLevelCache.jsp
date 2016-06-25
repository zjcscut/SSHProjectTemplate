<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二级缓存测试</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#button").click(function () {
                $.ajax({
                    url: "http://localhost:8080/second.html",
                    data: {
                        id: $("#id").val()
                    },
                    dataType: "json",
                    success: function (reslut) {
                        $("#info").html(reslut.i);
                        $("#data").html(reslut.s);
                    },
                    error: function (errorMsg) {
                        alert("发生错误:" + errorMsg);
                    }
                })
            });
        });

    </script>
</head>
<body>
<input id="id" type="text">
<br>
<button id="button" type="submit">获取</button>
<br>
<div id="info"></div>
<br>
<div id="data"></div>

</body>
</html>

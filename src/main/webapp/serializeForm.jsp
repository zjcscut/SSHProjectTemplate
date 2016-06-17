<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("button").click(function () {
                x = $("form").serializeArray();
                $.each(x, function (i, field) {
                    $("#results").append(field.name + ":" + field.value + " ");
                });
            });
        });
    </script>
</head>
<body>
<form action="">
    First name: <input type="text" name="FirstName" value="Bill"/><br/>
    Last name: <input type="text" name="LastName" value="Gates"/><br/>
</form>

<button>序列化表单值</button>
<div id="results"></div>
</body>
</html>
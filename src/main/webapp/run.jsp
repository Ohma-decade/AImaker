<%--
  Created by IntelliJ IDEA.
  User: 22973
  Date: 2021/12/6
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AI运行页面</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    function postbackAI(){
        $.ajax({
            url:"/runAI",
            type:"post",
            data:{
                input: $("#input").val(),
            },
            success: function(data){
                $("#output").val(data);
            }
        })
    }
</script>
<body>
    <div>
        <form action="/runAI" method="post">
            请在此输入:<input type="text" name="input" id="input"/>
            <input type="button" value="发送" onclick="postbackAI()"/>
            <br/>
            <textarea type="text" name="output" id="output" cols="80" rows="5"></textarea>
        </form>
    </div>

</body>
</html>

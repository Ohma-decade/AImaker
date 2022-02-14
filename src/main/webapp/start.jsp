<%--
  Created by IntelliJ IDEA.
  User: 22973
  Date: 2021/12/1
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>AI初始化页面</title>
</head>
<body>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
  var hash1 = {};//实例表1的临时储藏处
  var hash2 = {};//实例表2的临时储藏处
  var hash3 = {};//应答对应表的临时储藏处
</script>

<script type="text/javascript">
  function List1Add() {
    var ItemList1Left = $("#ItemList1Left").val()
    var ItemList1Right = $("#ItemList1Right").val()
    hash1[ItemList1Left] = ItemList1Right
    console.log(hash1)
    document.getElementById("ItemList1Left").value="";
    document.getElementById("ItemList1Right").value="";
  }//将实例表1的一对添加到hash1中
  function List1Reset() {
    hash1 = {}
    document.getElementById("ItemList1Left").value="";
    document.getElementById("ItemList1Right").value="";
  }//将hash1中临时储存的数据清空
  function List2Add() {
    var ItemList2Left = $("#ItemList2Left").val()
    var ItemList2Right = $("#ItemList2Right").val()
    hash2[ItemList2Left] = ItemList2Right
    console.log(hash2)
    document.getElementById("ItemList2Left").value="";
    document.getElementById("ItemList2Right").value="";
  }//将实例表2的一对添加到hash2中
  function List2Reset() {
    hash2 = {}
    document.getElementById("ItemList2Left").value="";
    document.getElementById("ItemList2Right").value="";
  }//将hash2中临时储存的数据清空
  function ReplyAdd() {
    var KeyWord = $("#KeyWord").val()
    var Reply = $("#Reply").val()
    hash3[KeyWord] = Reply
    console.log(hash3)
    document.getElementById("KeyWord").value="";
    document.getElementById("Reply").value="";
  }//将应答对应表的一对添加到hash3中
  function ReplyReset() {
    hash3 = {}
    document.getElementById("KeyWord").value="";
    document.getElementById("Reply").value="";
  }//将hash3中临时储存的数据清空
  function post() {
    var Hello = $("#Hello").val()
    var Bye = $("#Bye").val()
    var Default = $("#Default").val()
    var OrderReply1 = $("#OrderReply1").val()
    var OrderReply2 = $("#OrderReply2").val()
    var ItemList1 = hash1
    var ItemList2 = hash2
    var ReplyList = hash3

    let data = {
      Hello: Hello,
      Bye: Bye,
      Default: Default,
      OrderReply1: OrderReply1,
      OrderReply2: OrderReply2,
      ItemList1: ItemList1,
      ItemList2: ItemList2,
      ReplyList: ReplyList
    };
    fetch('http://localhost:8080/createAI',{
              method: 'post',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(data),
            }

    ).then(response => response.text()).then(data => {

    }
    ).catch(function(e){
      alert("error:" + e);
    })
    window.location.href="/run"
  }
</script>


<div>
  <label>问候语</label>
  <br />
  <textarea name="Hello" id="Hello" type="text" cols="80" rows="5" ></textarea>
</div>
<div>
  <label>结束语</label>
  <br />
  <textarea name="Bye" id="Bye" type="text" cols="80" rows="5" ></textarea>
</div>
<div>
  <label>无法识别处理语</label>
  <br />
  <textarea name="Default" id="Default" type="text" cols="80" rows="5" ></textarea>
</div>
<div>
  <label>命令处理语句1（根据实例对应表1、分别以关键字和对应值替代处请前后以%s代替之）</label>
  <br />
  <textarea name="OrderReply1" id="OrderReply1" type="text" cols="80" rows="5" ></textarea>
</div>
<div>
  <label>命令处理语句2（根据实例对应表2、分别以关键字和对应值替代处请前后以%s代替之）</label>
  <br />
  <textarea name="OrderReply2" id="OrderReply2" type="text" cols="80" rows="5" ></textarea>
</div>
<div>
  <label>实例对应表1（请分别在两个方框中添加所需的实例和对应值）</label>
  <br />
  <input name="ItemList1Left" id="ItemList1Left" type="text" ><input name="ItemList1Rigth" id="ItemList1Right" type="text" >
  <button type="submit" onclick="List1Add()">提交</button>
  <button type="submit" onclick="List1Reset()">重置</button>
</div>
<div>
  <label>实例对应表2（请分别在两个方框中添加所需的实例和对应值）</label>
  <br />
  <input name="ItemList2Left" id="ItemList2Left" type="text" ><input name="ItemList2Rigth" id="ItemList2Right" type="text" >
  <button type="submit" onclick="List2Add()">提交</button>
  <button type="submit" onclick="List2Reset()">重置</button>
</div>
<div>
  <label>应答对应表（请分别在两个框内输入关键词和对应的应答语句）</label>
  <br />
  <input name="KeyWord" id="KeyWord" type="text" >
  <br />
  <textarea name="Reply" id="Reply" type="text" cols="80" rows="5" ></textarea>
  <button type="submit" onclick="ReplyAdd()">提交</button>
  <button type="submit" onclick="ReplyReset()">重置</button>
</div>
<button type="submit" onclick="post()">提交</button>

</body>
</html>
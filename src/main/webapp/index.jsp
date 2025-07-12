<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>sixth--work</title>
  <style>

  </style>
  <link rel="stylesheet" href="sty.css">
</head>
<body>
<!-- <div class="juzhong"> -->

<div class="login_border active" id="login">

  <div class="element_border">欢迎来到Azurelite</div>
  <input type="text" class="element_border" placeholder="请输入账号" id="account">
  <input type="password" class="element_border" placeholder="请输入密码" id="password">
  <button class="element_border login" onclick="login()" type="submit">登录</button>
  <div class="element_border" >没有账号？</div>
  <button class="element_border" onclick="showregister()">点击注册</button>

</div>
<div class="register_border" id="register">

  <div class="element_border">欢迎注册Azurelite</div>
  <input type="text" class="element_border" placeholder="请输入账号">
  <input type="password" class="element_border" placeholder="请输入密码">
  <button class="element_border login">注册</button>
  <!-- <div class="element_border" style="margin: 0;">已有账号？</div> -->
  <button class="element_border" onclick="showlogin()">返回登录</button>

</div>

<!-- </div> -->

<script>
  var account='azurelite'
  var password='123456'//管理员帐号

  function showregister(){
    document.getElementById('login').classList.remove('active');
    document.getElementById('register').classList.add('active');

  }

  function showlogin(){
    document.getElementById('register').classList.remove('active');
    document.getElementById('login').classList.add('active');

  }
  function login(){
    account1=document.getElementById('account').value;
    console.log(account1)
    password1=document.getElementById('password').value
    console.log(password1)
    if(account1==this.account&&password1==this.password){
      alert("登录成功")
      window.location.href='https://baidu.com'
    }
    else{
      alert("账号或密码错误")//修改作者命名尝试
    }
  }
</script>


</body>
</html>
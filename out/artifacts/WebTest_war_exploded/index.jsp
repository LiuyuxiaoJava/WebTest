<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
    <center>
<%--      <form action="<%=basePath%>/Login" method="post">--%>
    <form action="Login" method="post">
        <p><input type="text" name="username" required="req
        uired" placeholder="请输入3-12位的字母">用户名</p><span><%=request.getAttribute("errorMsg")%></span>
        <p><input type="text" name="password" required="required" placeholder="请输入3-12位的字母">密码</p>
        <p><input type="submit" value="确定"></p>
        <p><input type="reset" value="重置"></p>
      </form>
    </center>
  </body>
</html>

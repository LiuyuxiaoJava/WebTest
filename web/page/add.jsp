<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
    <title>新增</title>
</head>
<body>
<center>
    <h1>菜品添加</h1>
    <form action="<%=path%>add" method="post">
        <table border="1px" cellspacing="0px" cellpadding="0px" width="400px" height="120">
            <tr>
                <td>菜名</td>
                <td><input type="text" name="caiName"></td>
            </tr>
            <tr>
                <td>口味</td>
                <td>
                    <input type="radio" name="kouwei" value="不辣">不辣
                    <input type="radio" name="kouwei" value="微辣">微辣
                    <input type="radio" name="kouwei" value="爆辣">爆辣
                </td>
            </tr>
            <tr>
                <td>图片</td>
                <td><input type="file" name="pic"></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>描述</td>
                <td>
                    <textarea name="desc"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加">
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
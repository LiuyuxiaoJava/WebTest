<%@ page import="com.test.entity.Caipin" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
    <link rel="stylesheet" type="text/css" href="JQ/jquery.dataTables.min.css">
    <script type="text/javascript" src="JQ/jquery.js"></script>
    <script type="text/javascript" src="JQ/jquery.dataTables.min.js"></script>
    <title>后台主页</title>
</head>
<body>
    <p>Hello,I,m Main</p>
<%=request.getSession().getAttribute("username")%>
    <center>
        <h1>菜品查询</h1>
        <table border="1px" cellspacing="0px" cellpadding="0px" width="100%" height="40" class="tablelist" id="example">
            <thead>
            <tr>
                <th>菜名ID</th>
                <th>菜名</th>
                <th>口味</th>
                <th>图片</th>
                <th>价格</th>
                <th>描述</th>
                <th>DEL</th>
                <th>UPDATE</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Caipin> caipinList = (List<Caipin>)request.getAttribute("list");
                for(Caipin cp : caipinList){
            %>
            <tr>
                <td><%=cp.getId() %></td>
                <td><%=cp.getCaiName() %></td>
                <td><%=cp.getKouwei() %></td>
                <td><%=cp.getPic() %></td>
                <td><%=cp.getPrice() %></td>
                <td><%=cp.getMiaoshu() %></td>
                <td><a href="Remove?userid=<%=cp.getId()%>">删除</a></td>
                <td><a href="Update?userid=<%=cp.getId()%>">修改</a></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <p><a href="<%=path%>page/add.jsp">新增</a></p>
    </center>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#example").dataTable({
                "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
                "aLengthMenu" : [5, 10, 15], //更改显示记录数选项
                "sPaginationType" : "full_numbers", //详细分页组，可以支持直接跳转到某页
                "bAutoWidth" : true, //是否自适应宽度
                //"bJQueryUI" : true,
                "oLanguage": { //国际化配置
                    "sProcessing" : "正在获取数据，请稍后...",
                    "sLengthMenu" : "显示 _MENU_ 条",
                    "sZeroRecords" : "没有您要搜索的内容",
                    "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                    "sInfoEmpty" : "记录数为0",
                    "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                    "sInfoPostFix" : "",
                    "sSearch" : "搜索",
                    "sUrl" : "",
                    "oPaginate": {
                        "sFirst" : "第一页",
                        "sPrevious" : "上一页",
                        "sNext" : "下一页",
                        "sLast" : "最后一页"
                    }
                },
            });
        });
    </script>
</body>
</html>

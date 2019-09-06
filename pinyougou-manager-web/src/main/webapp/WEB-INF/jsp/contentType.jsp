<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap3/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../js/bootstrap3/css/bootstrap.css">

    <script src="../js/bootstrap-table/bootstrap-table.js"></script>
    <script src="../js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-table/bootstrap-table.css">

    <script src="../js/bootstrap-bootbox/bootbox.all.min.js"></script>

    <script src="../js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script src="../js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
    <title>Title</title>
</head>
<body>
    <div id="contentTypeTable"></div>
    <div id="toolbar">
        <button type="button" onclick="addType()" class="btn btn-default">新建</button>
        <button type="button" onclick="delType()" class="btn btn-default">删除</button>
    </div>
</body>
<script>
    $(function (){
        initContent();
    })
    function initContent() {
        $("#contentTable").bootstrapTable({
            url:'../brand/findContentCategory.do',
            toolbar:'#toolbar',
            method:'post',
            contentType:'application/x-www-form-urlencoded',//post请求按照表单方式
            pagination:true, //是否展示分页
            pageList:[2, 4, 8, 10],//分页组件
            pageNumber:1,
            pageSize:2,//默认每页条数
            showRefresh:false,//是否显示刷新按钮
            detailView:false,//设置为 true 可以显示详细页面模式。
            showPaginationSwitch:false,//是否显示 数据条数选择框
            sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
            striped:true,
            queryParams:function(){
                return{
                    page:this.pageNumber,
                    rows:this.pageSize,
                }
            },
            columns:[
                {checkbox:true},
                {field:'id',title:'分类ID',align:'center',width:150},
                {field:'name',title:'分类名称',align:'center',width:150},
                {field:'cz',title:'操作',align:'center',width:150}
            ]
        })
    }
</script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/9/3
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>广告管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js">
    </script>
    <script type="text/javascript" src="js/bootstrap-table/bootstrap-table.js"></script>
    <script type="text/javascript" src="js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet"href="js/bootstrap-table/bootstrap-table.css"/>

    <script type="text/javascript" src="js/uploadify/jquery.uploadify.min.js"></script>
    <link rel="stylesheet" type="text/css" href="js/uploadify/uploadify.css" />

    <script type="text/javascript" src="js/bootstrap-bootbox/bootbox.min.js"></script>
</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->

<div class="box-header with-border">
    <h3 class="box-title">广告管理11</h3>
</div>

<div class="box-body">

    <!-- 数据表格 -->
    <div class="table-box">

        <!--工具栏-->
        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" ><i class="fa fa-file-o"></i> 新建</button>
                    <button type="button" class="btn btn-default" title="删除" onclick="delTb()"><i class="fa fa-trash-o"></i> 删除</button>
                    <button type="button" class="btn btn-default" title="开启" onclick='confirm("你确认要开启吗？")'><i class="fa fa-check"></i> 开启</button>
                    <button type="button" class="btn btn-default" title="屏蔽" onclick='confirm("你确认要屏蔽吗？")'><i class="fa fa-ban"></i> 屏蔽</button>
                    <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                </div>
            </div>
        </div>
        <div class="box-tools pull-right">
            <div class="has-feedback">
            </div>
        </div>
        <!--工具栏/-->

        <!--数据列表-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">

        </table>
        <!--数据列表/-->
    </div>
    <!-- 数据表格 /-->
</div>
<!-- /.box-body -->


<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">广告编辑</h3>
            </div>
            <div class="modal-body">
                <form id="TbcontentForm">
                <table class="table table-bordered table-striped"  width="800px">
                    <tr>
                        <td>广告分类</td>
                        <td>
                            <select class="form-control" id="CategoryId" name="CategoryId">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>标题</td>
                        <td><input  class="form-control" placeholder="标题" name="title">  </td>
                    </tr>
                    <tr>
                        <td>URL</td>
                        <td><input  class="form-control" placeholder="URL" name="url" >  </td>
                    </tr>
                    <tr>
                        <td>排序</td>
                        <td><input  class="form-control" placeholder="排序" name="sortOrder">  </td>
                    </tr>
                    <tr>
                        <td>头像</td>
                        <td>
                            <div id="show_file1"></div>
                            <img id="show_img" width="100" height="100"/>
                            <input type="file" id="uploadImg1" name="upFile"/>
                            <input type="hidden" name='pic' size="100"/>
                        </td>
                    </tr>
                    <tr>
                        <td>是否有效</td>
                        <td>
                            <input type="checkbox" class="icheckbox_square-blue" name="status" value="1">有效
                            <input type="checkbox" class="icheckbox_square-blue" name="status" value="2">无效
                        </td>
                    </tr>
                </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" onclick="insert()" data-dismiss="modal" aria-hidden="true">保存</button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function delTb() {
        var arr=$("#dataList").bootstrapTable("getSelections");
        var ids="";
        for (var i = 0; i < arr.length; i++) {
            ids+=ids==''?arr[i].tbContent.id:','+arr[i].tbContent.id;
        }
        bootbox.confirm({
            title: "删除信息?",
            message: "你确定要删除选中的信息吗.",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> 取消'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> 确认'
                }
            },
            callback: function(result) {
                $.ajax({
                    url: 'brand/removeContent.do',
                    data: {ids: ids},
                    success: function (data) {
                        alert(data.message);
                        $('#dataList').bootstrapTable('refresh');
                    }
                })
            }
        });

    }

    function insert(){
        $.ajax({
            url:"brand/addContent.do",
            data:$("#TbcontentForm").serialize(),
            success:function (data) {
                alert(data.message);
                $('#dataList').bootstrapTable('refresh');
            }
        })

    }

    $(function () {
        queryType();
        initBookTable();
    });

    function initBookTable() {
        $("#dataList").bootstrapTable({
            url:"brand/findTbContentPage.do",
            method:"post",
           // toolbar:"#toolbar",
            contentType:'application/x-www-form-urlencoded',
            pagination:true,
            pageSize:5,
            pageList:[5,10,15,20,30],
            pageNumber:1,
            clickToSelect:true,
            sidePagination:"server",
            striped:true,
            queryParams:function () {
                return{
                    page:this.pageNumber,
                    rows:this.pageSize
                }
            },
            columns:[
                {checkbox:true},
                {field:'tbContent.id',title:'主键id',width:150},
                {field:'tbContentCategory.name',title:'广告类型',width:150},
                {field:'tbContent.title',title:'标题',width:150},
                {field:'tbContent.url',title:'url',width:150},
                {field:'tbContent.pic',title:'封面',width:150,formatter:function (value,row,index) {
                        return '<img src="'+value+'" width="100px" height="100px">';
                    }},
                {field:'tbContent.status',title:'发布时间',width:150,formatter:function (value,row) {
                    if(value==1){
                        return "有效"
                    }else{
                        return "无效"
                    }
                    }},
                {field:'cz',title:'操作',width:250,formatter:function (value,row,index) {
                        return '<button  class="glyphicon glyphicon-pencil btn btn-info btn-sm btn-block" onclick="initOpenDialog('+row.id+')">修改</button>'
                    }}
            ]
        })
    }

    function queryType(){
        $.ajax({
            url:"brand/findType.do",
            success:function (data) {
                var html="";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value='" + data[i].id + "'>" + data[i].name + "</option>"
                }
                $("#CategoryId").html(html);
            }
        })
    }

    $("#uploadImg1").uploadify({
        //插件自带  不可忽略的参数flash插件
        'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
        //前台请求后台的url 不可忽略的参数 ******
        'uploader': '<%=request.getContextPath()%>brand/upFile.do',
        //给div的进度条加背景 不可忽略******
        'queueID': 'show_file1',
        //上传文件文件名 跟file标签 name值 保持一致******
        'fileObjName' : 'upFile',
        //给上传按钮设置文字
        'buttonText': '上传',
        //设置文件是否自动上传
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': true,
        //上传后队列是否消失
        'removeCompleted': true,
        //队列消失时间
        'removeTimeout' : 1,
        //上传文件的个数，项目中一共可以上传文件的个数
        'uploadLimit':  1,
        //上传文件的类型
        'fileTypeExts': '*.*',
        //成功回调函数 file：文件对象。data后台输出数据img/
        'onUploadSuccess':function(file,data,response){
            //data = eval("("+data+")");
            //alert(file.name+" 路径："+data.imagePath)
            //图片回显， 预览
            alert(data);
            $("#show_img").attr("src","<%=request.getContextPath()%>/img/"+data)
            // 文本框 回填
            $("[name='pic']").val(data);
        }
    });
</script>
</html>

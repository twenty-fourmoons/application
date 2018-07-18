<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/commons/meta.jsp"%>
    <script>
        var d1 = Math.floor((Math.random()*30)+1);
        var d2 = Math.floor((Math.random()*30)+1);
        function formatDay(date){
            var m = date.getMonth()+1;
            var d = date.getDate();
            var opts = $(this).calendar('options');
            if (opts.month == m && d == d1){
                return '<div class="icon-ok md">' + d + '</div>';
            } else if (opts.month == m && d == d2){
                return '<div class="icon-search md">' + d + '</div>';
            }
            return d;
        }
    </script>
    <style scoped="scoped">
        .md{
            height:16px;
            line-height:16px;
            background-position:2px center;
            text-align:right;
            font-weight:bold;
            padding:0 2px;
            color:red;
        }
    </style>

</head>
<body>
<div style="margin:20px 0;">
    欢迎 ${sessionScope.username} ! !
</div>
<div class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north'" style="height:50px">
        north
    </div>
    <div data-options="region:'south',split:true" style="height:50px;">
        south
    </div>
    <div data-options="region:'east',split:true" title="通知" style="width:180px;">
        <div class="easyui-calendar" style="width:250px;height:250px;" data-options="formatter:formatDay"></div>

        <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
    </div>
    <div data-options="region:'west',split:true" title="管理" style="width:100px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="Title1" style="padding:10px;">
                content1
            </div>
            <div title="Title2" data-options="selected:false" style="padding:10px;">
                content2
            </div>
            <div title="Title3" style="padding:10px">
                <a href="https://www.baidu.com">百度</a>
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'主页',iconCls:'icon-ok'">
        <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
            <div title="关于" data-options="href:'_content.html'" style="padding:10px"></div>
           <%-- <div title="DataGrid" style="padding:5px">
                <table class="easyui-datagrid"
                       data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
                    <thead>
                    <tr>
                        <th data-options="field:'itemid'" width="80">Item ID</th>
                        <th data-options="field:'productid'" width="100">Product ID</th>
                        <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                        <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                        <th data-options="field:'attr1'" width="150">Attribute</th>
                        <th data-options="field:'status',align:'center'" width="50">Status</th>
                    </tr>
                    </thead>
                </table>
            </div>--%>
        </div>
    </div>
</div>


</body>
</html>

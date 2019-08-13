<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
 <%@ include file="/mycssorjs.jsp"%>
</head>
<body>
	 <form id="pro_from" class="form-inline">
		  <div class="form-group">
		    <label>用户名字</label>
		     <br>
		    <input type="text" class="form-control" name = "name" id="name" placeholder="用户名字">
		  </div>
		  <div class="form-group">
		<label for="name">所属联赛</label>
			<select id="leagid"   name="leagid">
				<option value="0">请选择</option>
			</select>
		</div>
		  
		  
		   <div class="form-group">
		    <label>日期</label>
		     <br>
		    <input type="date" class="form-control" name = "startdate" id="startdate" placeholder="用户名字">-
		     <input type="date" class="form-control" name = "enddate" id="enddate" placeholder="用户名字">
		  </div>
		  
		  <br>
		  <button type="button" class="btn btn-success" onclick="queryData()">搜索</button>
		</form>
        <button type="button" class="btn btn-Warning btn-lg" onclick="addPlayer()">新增</button>
    <button type="button"  class="btn btn-info btn-lg" onclick="deletePlayerById()">批量删除</button>     	
   <!--  表格 -->
    <table id="dataGrid"></table>

</body>
<script type="text/javascript">
	
	$(function(){
		
		queryCustomer();
	
	})
	
	
	queryCustomer = function(){
		
	     $("#dataGrid").bootstrapTable({
	    		url:"<%=request.getContextPath()%>/customerAction!queryCustomer.action",
	         method: 'post',
	         striped: true,  	// 斑马线效果     默认false
	         //只允许选中一行
	         singleSelect: false,
	         //选中行是不选中复选框或者单选按钮
	         clickToSelect: true,
	         showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
	         cardView: false,                    //是否显示详细视图
	         uniqueId: "id",                 //每一行的唯一标识，一般为主键列
	         showColumns: true,                  //是否显示所有的列
	         showRefresh: true,                  //是否显示刷新按钮
	         minimumCountColumns: 2,     //  最少留两列
	         detailView: false,                  //是否显示父子表
	         toolbar: '#tabToolBar',   //  工具定义位置
	         sidePagination: 'server',
	         toolbar: '#toolbar',
	         pagination: true, //是否展示分页
	         pageList: [2, 4, 8, 10],//分页组件
	         pageNumber: 1,
	         pageSize: 2,//默认每页条数
	         //启动回车键做搜索功能
	         searchOnEnterKey: true,
	         //设置为false 将禁止所有列的排序。
	         sortable: true,
	         //设置默认排序为 name,直接对应数据库的字段
	         sortName: 'id',
	         //定义排序方式，'asc' 或者 'desc'。
	         sortOrder: "desc",
	         //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
	         // 设置为limit可以获取limit, offset, search, sort, order 
	         queryParamsType: 'undefined',
	         // 请求服务器数据
	         queryParams: function queryParams(params) {
	             var param = {
	                 pageNumber: params.pageNumber,
	                 pageSize: params.pageSize,
	                 sortName: params.sortName,
	                 sortOrder: params.sortOrder,
	                 //name: $("#name").val()
	               
	                 
	             };
	             return param;
	         },
	         columns: [
          {field:'cb',checkbox:true},
          {field:'id',title:'编号',width:100},
        {field:'name',title:'公司名称',width:100},
          {field:'dname',title:'所属省市',width:100},
          {field:'create_time',title:'录入时间',width:100},
          {field:'gj_time',title:'跟进时间',width:100},
          {field:'phone',title:'电话',width:100},
          {field:'department_id',title:'部门',width:100,
        	  formatter:function(value){
        		  if(value=='1'){
        			  return "财务部";
        		  }
        		  if(value=='2'){
        			  return "技术部";
        		  }
        		  if(value=='3'){
        			  return "人事部";
        		  }
        	  }
          },
          {field:'description',title:'备注',width:100},
        	  {field:'cz',title:'操作',width:100,
        		  formatter:function(value,rows,index){
        			  if(rows.gj_time==null){
        				
        				
        				 return "<a href='JavaScript:queryVarity("+rows.id+")'>跟进</a>"
        				 // return " <input type='button' value='订餐' onclick='queryVarity("+rows.t_eating_id+")'>";
        			  }else{
        				  return "<a href='JavaScript:queryVarity2("+rows.id+")'>取消跟进</a>"
        			  }
        			  
        		  }
        	  }
  
	         ]
	     });
	}
	
	
	 function queryData(){
		  $("#dataGrid").bootstrapTable("refresh", {
		         "query": {

		             "name": $("#name").val(),
		             "leagid": $("#leagid").val(),
		             "startdate": $("#startdate").val(),
		             "enddate": $("#enddate").val()
		         }
		     });
		 
	 }
	 var res;

	 function createAddContent(url) {
		 alert(url);
	     $.ajax({
	         url: url,
	         async: false,
	         success: function (data) {
	             res = data;
	         }
	     });
	     return res;
	 }
	 
	 
	 addPlayer = function(){
		    bootbox.dialog({
	            title: '新增用户',
	            message: createAddContent("<%=request.getContextPath()%>/page/toAddplayer.do"),
	            closeButton: true,//是否显示关闭按钮
	            buttons: {
	                "success": {
	                    "label": "<i class='icon-ok'></i> 保存",
	                    "className": "btn-sm btn-success",
	                    "callback": function () {
	                    	
	                        $.ajax({
	                            url: '<%=request.getContextPath()%>/player/Addplayer.do',
	                            type: 'post',
	                            cache:false,
	                            data: $("#formId").serialize(),
	                            success: function () {
	                       
	                                redata();
	                              
	                            }, error: function () {
	                                alert("新增失败");
	                            }
	                        });
	                    }
	                },
	                "cancel": {
	                    "label": "<i class='icon-info'></i> 取消",
	                    "className": "btn-sm btn-danger",
	                    "callback": function () {

	                    }
	                }
	            }

	        });
		 
	 }
	//批量删除
	 function deletePlayerById() {
	 	
	     var arr = $('#dataGrid').bootstrapTable("getSelections");//获取选中的行

	     console.log(arr);

	     if (arr.length <= 0) {
	         alert("请你选中要删除的数据！！！");
	     } else {
	         var ids = "";
	         for (var i = 0; i < arr.length; i++) {
	             ids += arr[i].id + ",";
	         }
	         ids = ids.substring(0, ids.length - 1);
	         
	         alert(ids);


	         $.ajax({
	             url: "<%=basePath%>/player/deleteplayer.do",
	             data: {ids: ids},
	             type: "post",
	             success: function () {
	                 alert("删除成功！");
	                 $("#dataGrid").bootstrapTable("refresh");

	             }, error: function () {
	                 alert("失败");
	             }


	         })
	     }


	 }

	 function  ModifyBySelect(id){

	     //打开新增弹框
	     bootbox.dialog({
	         title: '新增用户',
	         message: createAddContent("<%=basePath%>/page/toUpdateplayer.do?id="+id),
	         closeButton: true,//是否显示关闭按钮
	         buttons: {
	             "success": {
	                 "label": "<i class='icon-ok'></i> 保存",
	                 "className": "btn-sm btn-success",
	                 "callback": function () {
	                 	
	                     $.ajax({
	                         url: '<%=basePath%>/player/Updateplayer.do',
	                         type: 'post',
	                         data: $("#formId").serialize(),
	                         success: function () {
	                             alert("修改成功");
	                             //$('#dataGrid').bootstrapTable("refresh");
	                             location.href=location;
	                             //刷新表格
	                         }, error: function () {
	                             alert("修改失败");
	                         }
	                     });
	                 }
	             },
	             "cancel": {
	                 "label": "<i class='icon-info'></i> 取消",
	                 "className": "btn-sm btn-danger",
	                 "callback": function () {

	                 }
	             }
	         }

	     });

	 }
	 queryLeag=function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/player/queryLeag.do",
				type:"post",
				success:function(data){
					alert(data)
					var temp = "<option value='0'>请选择</option>";
					for (var i = 0; i < data.length; i++) {
						temp += "<option value='"+data[i].leagid+"'>"+data[i].leagname+"</option>"
					}
					
					$("#leagid").html(temp)
				
				}
				
			});
		}
			
</script>
</html>
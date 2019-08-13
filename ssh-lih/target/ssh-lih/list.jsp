<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="./jquery-1.8.0.js"></script>

<script type="text/javascript" src="./js/uploadify/jquery.uploadify.min.js"></script>
<link rel="stylesheet" type="text/css" href="./js/uploadify/uploadify.css" />



<script type="text/javascript" src="./js/easyui1.5/jquery.easyui.min.js"> </script>
<script type="text/javascript" src="./js/easyui1.5/locale/easyui-lang-zh_CN.js"> </script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/js/easyui1.5/themes/default/easyui.css"></link>
<link rel="stylesheet" href="<%=request.getContextPath() %>/js/easyui1.5/themes/icon.css"></link>


</head>
<body style="visibility:hidden;">
<!-- <div id="ToolBar">
服务器名称：<input id="serverName" name="serverName">
服务器状态：  <select id="serverStatus" name="serverStatus">
	<option value="0" selected>请选择
	<option value="1">运行中
	<option value="2">已关机
	<option value="3">已到期
  </select>
 <a href="javascript:search()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">查询</a>
</div> -->

<div id="myDialog" closed="true" button="#AddOk" class="easyui-dialog" style="width:400px;height:200px;">
			<form id="addForm" method="post">
				<input type="hidden" name="id">
				<table>
				<tr>
					<td>客户名称</td>
					<td>
						<input type="text" name="name" class="easyui-validatebox" required="true"> 
					</td>
				</tr>
				<tr>
					<td>所属地址</td>
					<td>
						<!-- <input type="text" name="location" class="easyui-validatebox" required="true">  -->
					<select name="location_id">
							<option value="0" selected>请选择
							<option value="1">天津
							<option value="3">黑龙江
							<option value="5">山西
						  </select>
					</td>
				</tr>
				<tr>
					<td>录入时间</td>
					<td>
						<input type="date" name="create_time" class="easyui-validatebox" required="true">
					
					</td>
				</tr>
				<tr>
					<td>电话</td>
					<td>
						<input name="phone" class="easyui-validatebox" required="true">
					</td>
				</tr>
				<tr>
					<td>部门</td>
					<td>

						<select name="department_id">
							<option value="0" selected>请选择
							<option value="1">财务部
							<option value="2">技术部
							<option value="3">人事部
						  </select>
					</td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td>
						<input type="text" name="description"> 
					</td>
				</tr>
				
				
					<tr>
				
					<td>
					<input type="button" value="新增" onclick="saveDialog()">
					</td>
				</tr>
				</table>
			</form>
			
			<div id="AddOk">
				<!-- <a href="javaScript:saveDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a> -->
				<a href="javaScript:cancelDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消 </a>
			
			</div>
		</div>




<div>
<a id="btn" href="javaScript:openDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
<a id="btn" href="javascript:ModifyBySelect()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
<a id="btn" href="javascript:DeleteByFruitName()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">批量同步</a> 
</div>


<table id="data" title="信息" class="easyui-datagrid"></table>

</body>
<script type="text/javascript">




  
$(function(){

$("body").css({visibility:"visible"});
	$("#data").datagrid({
		url:"<%=request.getContextPath()%>/customerAction!queryCustomer2.action",
		columns:[[
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
		          ]],
		/* pagination:true,
		pageList:[2,5,10], */
		rownumbers:true,

		fitColumns:true
		
	})

})





/* 	function search(){
		$("#data").datagrid('load',{
			serverName:$("#serverName").val(),
			serverStatus:$("#serverStatus").val()
		})
	} */
	
	
	function openDialog(){
		alert("aaaaaaaaa")
		$("#myDialog").dialog("open").dialog('setTitle','添加数据');
		
	}
	function saveDialog(){
	<%-- 	$("#myDialog").dialog("open").dialog('setTitle','添加数据');
		$("#addForm").form('submit',{
			url:"<%=request.getContextPath()%>/customerAction!addCustomer.action",
			onSubmit:function(){
				return $(this).form('validate');
			},
			success: function(data){
				if(data.error){
					$.messager.alert("提示信息",data.error);
					return ;
				}else{
					
					
					//关闭当前窗口
					$("#myDialog").dialog('close');
					
					$.messager.alert("系统提示","保存成功");
					//刷新表格数据
					$("#data").datagrid('reload');
				}
			}
			
		}) --%>
		$.ajax({
			url:"<%=request.getContextPath()%>/customerAction!addCustomer.action",
			data:$("#addForm").serialize(),
			success:function(){
			location=href=location;
			}
		})
	}
	function DeleteByFruitName(ids){
		
		//获取数据
		var rows=$("#data").datagrid('getSelections');
		//alert(rows);
		if(0 ==rows.length){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return ;
		}
		//选中数据
		//得到id值
		var arr=[];
		for(var i=0;i<rows.length;i++){
			arr.push(rows[i].id);
		}
		//对id进行拼接
		var ids=arr.join(",");
		
		$.messager.confirm("系统提示", "你确定要作废<font color=red> " + rows.length + " </font>条数据吗?",
				function(xo){
			
				if(xo){
					$("#data").datagrid('reload');
				$.post("<%=request.getContextPath()%>/customerAction!delCustomer.action",{id:id},
					function(result){
					
					//alert("result:"+result);
					
					
					if( result.success ){
						$.messager.alert("系统提示", "你已成功删除 <font color=green> " + result.DeleteCounts + " </font>条数据!~");
						$("#data").datagrid('reload');
					}
					else{
						$.messager.alert("系统提示", "<font color=red>删除失败</font>");
					}
					},"json");
					
				}
			
				});
	}

</script>

</html>
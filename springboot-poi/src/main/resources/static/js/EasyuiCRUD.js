
function openDialog(){
	alert("aaaaaaaaa")
	$("#myDialog").dialog("open").dialog('setTitle','添加数据');
	
}
function CloseDialog(){
	$("#myDialog").dialog('close');
}


//新增
function SaveDialog(){
	$("#addForm").form('submit',{
		url:"add.do",
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
		
	})
}
//修改
function  ModifyBySelect(){
	var rows=$("#data").datagrid('getSelections');
	alert("cccccccc")
	if(1 !=rows.length){
		$.messager.alert("系统提示","请选择一天数据进行修改");
		return ;
	}
	//d打开窗口
	$("#myDialog").dialog('open').dialog('setTitle','修改数据');

	var selData=$("#data").datagrid('getSelected');
	
	$("#myDialog").form('load',selData);
	
	url="add.do?c_id="+selData.c_id;
}
//cha
queryType=function(){
	$("#sel").combobox({
		url:"./queryType.do",
		valueField:"c_typeid",
		textField:"c_typename"
	})
}

function OpenTab(Text,URL){
	if( $("#MenusTabs").tabs('exists', Text) ){
		$("#MenusTabs").tabs('select', Text);
	}
	else{
		var Content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src=" + URL + "></iframe>";
		$("#MenusTabs").tabs('add',{
			title:Text,
			closable:true,
			content:Content
		});	
	}
}

//
//批删 $.messager.confirm("系统提示", "你确定要作废<font color=red> " + rows.length + " </font>条数据吗?",
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
		arr.push(rows[i].c_id);
	}
	//对id进行拼接
	var ids=arr.join(",");
	
	$.messager.confirm("系统提示", "你确定要作废<font color=red> " + rows.length + " </font>条数据吗?",
			function(xo){
		
			if(xo){
				$("#data").datagrid('reload');
			$.post("delBetch.do",{ids:ids},
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

$(function(){
	var TreeMenusDatas=[{
		text:"图书馆图书系统",
		children:[{
			text:"小说图书信息",
			attributes:{
				url:"list.jsp"
			}
		}]
	}];
	
	$("#TreeMenus").tree({
		data:TreeMenusDatas,
		lines:true,
		onClick:function(node){
			if( node.attributes ){
				OpenTab( node.text, node.attributes.url );
			}
		}
	});
});
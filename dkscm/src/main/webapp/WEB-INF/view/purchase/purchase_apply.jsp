<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="../../static/css/bootstrap.min.css">
  		<link rel="stylesheet" href="../../static/css/font-awesome.min.css">
  		<link rel="stylesheet" href="../../static/DataTables/DataTables-1.10.20/css/jquery.dataTables.min.css">
  		<script src="../../static/js/jquery-3.4.1.min.js"></script>
		<script src="../../static/js/bootstrap.min.js"></script>
		<script src="../../static/DataTables/DataTables-1.10.20/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#mytable").DataTable({
					// 关闭本地分页
					paging:false,
					// 关闭搜索框
					searching: false,
					// 关闭排序
					ordering: false,
					// 设定表格的数据通过异步形式获得
					serverSide:true,
					// 获得表格地址
					ajax: {
						// 请求地址
						url:"list",
						// 请求方式
						type:"post",
						// 设定在请求列表的时候，所需要携带的请求参数
						data: function(d) {
							// 获得对应的设置信息
							var tableSetings = $("#mytable").dataTable().fnSettings();
							// 删除多余请求参数
							for(var key in d) { 
								if(key.indexOf("columns")==0||key.indexOf("order")==0||key.indexOf("search")==0){ 
									//以columns开头的参数删除
									delete d[key]; 
								} 
							}
							// 扩展请求时候的数据，重点在于pageNum和pageSize
							var params = {
									// 获得表格对象后，
									// 系统当前页码_iDisplayStart，默认从0开始
									"pageNum": tableSetings._iDisplayStart + 1,
									// 每页显示数量
									"pageSize": tableSetings._iDisplayLength
							}
							// 将新增的查询数据扩展到请求参数上
							$.extend(d, params); //给d扩展参数
						},
						// 设定回传的数据格式为JSON
						dataType: "json",
						// 过滤数据
						dataFilter: function(data) {
							data = JSON.parse(data);
							var returnData = {};
							returnData.draw = data.draw;
							returnData.recordsTotal = data.totalSize;
							returnData.recordsFiltered = data.totalSize;
							returnData.data = data.list;
							return JSON.stringify(returnData);
						}
					},
					// 为表格的每一个字段设定具体的值
					columnDefs: [{
						targets: 0,
						data: function (row, type, val, meta) {
							// 在序号位置
							var tableSetings = $("#mytable").dataTable().fnSettings();
							var begin = tableSetings._iDisplayStart;
							var size = tableSetings._iDisplayLength;
							alert(begin * size + begin + 1);
							return begin * size + begin + 1;
						}
					}, {
						targets: 1,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.purchaseNo;
						}
					}, {
						targets: 2,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.goodsName;
						}
					}, {
						targets: 3,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.goodsBand;
						}
					}, {
						targets: 4,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.goodsType;
						}
					}, {
						targets: 5,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.applyquantity + "&nbps;" + row.goodsUnit;
						}
					}, {
						targets: 6,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.budget + "&nbps;元";
						}
					}, {
						targets: 7,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return row.applyRemark;
						}
					}, {
						targets: 8,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return "<span style='color:red;'></span>";
						}
					},  {
						targets: 9,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return "<span style='color:red;'></span>";
						}
					}, {
						targets: 10,
						data: function (row, type, val, meta) {
							// 在序号位置，row就代表JSON中list所对应的一个位置的数据对象
							return "<span style='color:red;'></span>";
						}
					}],
					// 显示语言
					language: {
				        "sProcessing": "处理中...",
				        "sLengthMenu": "显示 _MENU_ 项结果",
				        "sZeroRecords": "没有匹配结果",
				        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
				        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
				        "sInfoPostFix": "",
				        "sSearch": "搜索:",
				        "sUrl": "",
				        "sEmptyTable": "表中数据为空",
				        "sLoadingRecords": "载入中...",
				        "sInfoThousands": ",",
				        "oPaginate": {
				            "sFirst": "首页",
				            "sPrevious": "上页",
				            "sNext": "下页",
				            "sLast": "末页"
				        },
				        "oAria": {
				            "sSortAscending": ": 以升序排列此列",
				            "sSortDescending": ": 以降序排列此列"
				        }
					}
				);
			});
		</script>
	</head>
	<body>
		<div class="conrainer" style="margin: 0px">
			<div class="row" style="padding-top: 10px">
				<div class="col-md-12">
					<table id="mytable" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">申请编号</th>
								<th style="text-align: center;">物资名称</th>
								<th style="text-align: center;">品牌</th>
								<th style="text-align: center;">型号</th>
								<th style="text-align: center;">购买数量</th>
								<th style="text-align: center;">预算</th>
								<th style="text-align: center;">说明</th>
								<th style="text-align: center;">状态</th>
								<th style="text-align: center;">申请人</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
					</table>
				</div>			
			</div>
			<div class="row" style="padding-top: 10px">
				<div class="col-md-12">
					<a href="#" class="btn btn-success">
						<i class="fa fa-plus"></i>
						<span>申请采购</span>
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
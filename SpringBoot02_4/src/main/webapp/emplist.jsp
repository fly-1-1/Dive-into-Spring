<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome  ! ${sessionScope.user.realname}
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Bir
							</td>
							<td>
								Sex
							</td>
							<td>
								Operation
							</td>
						</tr>
						<c:forEach items="${requestScope.employees}" var="employee">
						<tr class="row1">
							<td >${employee.id}</td>
							<td >${employee.name}</td>
							<td >${employee.salary}</td>
							<td ><fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd"/></td>
							<td >${employee.gender?'男':'女'}</td>
							<td>
								<a href="javascript:;" onclick="deleteEmployee()">删除</a>&nbsp;
								<script>
									function deleteEmployee(){
										if (window.confirm("确定删除这条记录吗?")){
											location.href=`${pageContext.request.contextPath}/employee/deleteById?id=${employee.id}`;
										}
									}
								</script>
								<a href="${pageContext.request.contextPath}/employee/findById?id=${employee.id}">更新</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<a href="${pageContext.request.contextPath}/addEmp.jsp">添加员工信息</a>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>

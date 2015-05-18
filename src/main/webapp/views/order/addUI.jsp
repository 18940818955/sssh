<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="order_add">
		<table>
			<thead>
				<tr>
					<th>产品名</th>
					<th>价格</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="resultList" var="item">
					<tr>
						<td><s:property value="#item.name" /></td>
						<td><s:property value="#item.price" /></td>
						<td><input type="hidden" name="ids" value="<s:property value='#item.id'/>">
							<input type="text" name="params"></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
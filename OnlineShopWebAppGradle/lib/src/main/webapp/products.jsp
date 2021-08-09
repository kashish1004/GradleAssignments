<%@page import="com.phoenix.services.ProductServiceImpl"%>
<%@page import="com.phoenix.services.ProductService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.util.List ,com.phoenix.data.Product"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
</html>
<%
	HttpSession obj = request.getSession(false);
	//current session
	if(obj!= null) { %>
			<%@ include file="header.html" %>
		<%
			String user = (String)obj.getAttribute("user");
			out.println("<h3 style ='color:blue'>Hi! "+ user +" Enjoy Shopping</h3>");
			List<Product> products = (List<Product>)obj.getAttribute("product");
			String s = request.getParameter("sorted");
			ProductService ps = new ProductServiceImpl();
		%>
			<html>
				<body bgcolor = 'cyan' style ='text-align: center'>
				<form action="products.jsp">
					<label for = "sort">Sort By:</label>
					<select name = "sorted" id = "sorted">
						<option value = "notSorted" <%if(s==null){%>selected<%}%>>Not sorted</option>
						<option value = "Name" <%if(s!=null && s.equals("Name")){%>selected<%}%>>Name</option>
						<option value = "Brand" <%if(s!=null && s.equals("Brand")){%>selected<%}%>>Brand</option>
						<option value = "Price" <%if(s!=null && s.equals("Price")){%>selected<%}%>>Price</option>
						<option value = "PriceDesc" <%if(s!=null && s.equals("PriceDesc")){%>selected<%}%>>PriceDesc</option>
					</select>
					<input type="submit" value = "Apply">
				</form>
				<%
					
					if(s!= null){
						if(s.equals("Name"))
							products = ps.sortByName(products);
						else if(s.equals("Brand"))
							products = ps.sortByBrand(products);
						else if(s.equals("Price"))
							products = ps.sortByPrice(products);
						else if(s.equals("PriceDesc"))
							products = ps.sortByPriceDesc(products);
					}
				%>
					<table border = "1px" bgcolor = 'lightgreen' style ='margin:5px auto'>
						<tr>
							<th>ProductId</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
						</tr>
						
						<% for(Product pro:products) {%>
						<tr>
							<td><%= pro.getId() %></td>
							<td><%= pro.getName() %></td>
							<td><%= pro.getBrand() %></td>
							<td><%= pro.getPrice() %></td>
						</tr>
						<% } %>
						
					</table>
					<br><br>
						<a href = update.html>Update a Product</a><br><br>
						<a href = delete.html>Delete a Product</a><br><br>
						<a href = insert.html>Insert a Product</a><br><br>
				</body>
			</html>
			
			<%@ include file="footer.html" %>
	<% }
	//no session
	else {
		out.println("<p>Sorry! No Session</p>");
	} %>

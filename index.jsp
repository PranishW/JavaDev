<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession" import="DAO.StudentDAO" %>
<%@ page import="DAO.Model" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
        // Retrieve the session object

        // Check if the session is not null and the username attribute is set
        if (session != null && session.getAttribute("name") != null) {
            // Get the username from the session
            String username = (String) session.getAttribute("name");
            StudentDAO st = new StudentDAO();
            ArrayList<Model> students = st.showStudents();
    %>

      <div>
      	<h1>School</h1>
        <h1>Welcome, <%= username %>!</h1>
        <h2>All School Students</h2>
        	<table>
        		<thead>
        			<tr>
        				<th>RollNo</th>
        				<th>Name</th>
        				<th>Password</th>
        			</tr>
        		</thead>
        		<tbody>
        			<% for(Model s:students) { %>
        				<tr>
        					<td><%= s.getrollno() %></td>
        					<td><%= s.getname() %></td>
        					<td><%= s.getpass() %></td>
        					<td>
        						<form action="DeleteStudent" method="post">
        							<button type="submit" value=<%= s.getrollno() %> name="rollno">Delete</button>
        						</form>
        					</td>
        				</tr>
        			<% } %>
        		</tbody>
        	</table>
        	<form action="DeleteStudent" method="get">
        		<button>Logout</button>
        	</form>
    </div>

    <%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("Login.jsp");
        }
    %>
</body>
</html>
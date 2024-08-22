package School;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import DAO.StudentDAO;
/**
 * Servlet implementation class Student
 */
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        StudentDAO st = new StudentDAO();
        if (st.isValidUser(name, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            response.sendRedirect("index.jsp");
            //System.out.println("Hi - "+username);
        } else {
            response.sendRedirect("Login.jsp?error=1");
        	System.out.println("Error A gya");
        }
	}

}

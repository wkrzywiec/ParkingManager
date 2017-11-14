package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.UsersDAO;

@WebServlet(name = "home",
			urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userLogin = request.getParameter("inputLogin");
		String userPassword = request.getParameter("inputPassword");
		int userType = 0;
		String errorMessage = null;
		
		try {
			userType = UsersDAO.getUserType(userLogin, userPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(userType);
		RequestDispatcher dispatcher = null;
		if(userType == 1){
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/owner.jsp");
		} else if(userType == 2){
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/operator.jsp");
		} else if(userType == 3){
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/driver.jsp");
		} else {
			errorMessage = "Upsss... There is no user with this login and/or password. Try again!";
			request.setAttribute("errorMessage", errorMessage);
			dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}

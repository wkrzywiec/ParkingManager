package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Driver;
import model.User;
import utils.DriversDAO;
import utils.UsersDAO;

@WebServlet(urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userLogin = (String) request.getParameter("inputLogin");
		userLogin = userLogin.toLowerCase();
		String userPassword = (String) request.getParameter("inputPassword");
		String userConfirmPassword = (String) request.getParameter("inputConfirmPassword");
		String driverName = (String) request.getParameter("inputName");
		int driverType = Integer.valueOf((String) request.getParameter("radioDriver"));
		String vehicleBrand = (String) request.getParameter("inputBrand");
		String vehicleModel = (String) request.getParameter("inputModel");
		String vehicleReg = (String) request.getParameter("inputReg");
		
		boolean isNewUser = false;
		String errorMessage = null;
		int userId = 0;
		int userType = User.USER_TYPE_DRIVER;
		
		User newUser = new User(userLogin, userPassword, userType);
		Driver newDriver = new Driver(userId, driverName, driverType, vehicleBrand, vehicleModel, vehicleReg);
		
		if(!userPassword.equals(userConfirmPassword)){
			errorMessage = "Aye yai yai yai, password and its confirms are not matching!";
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("driver", newDriver);
			request.setAttribute("user", newUser);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
			dispatcher.forward(request, response);	
		} else {
			
			isNewUser = UsersDAO.isNewUser(userLogin);
			
			if(isNewUser){
				UsersDAO.addUser(newUser);
				
				userId = UsersDAO.findUserId(userLogin);
	
				newDriver.setUserId(userId);
				DriversDAO.addDriver(newDriver);
				
				RequestDispatcher dispatcher = null;
				
				if (errorMessage != null){
					request.setAttribute("errorMessage", errorMessage);
					dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
				} else {
					dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
				}
			
				dispatcher.forward(request, response);
				
			} else {
				errorMessage = "There is already user with login - " + userLogin + " - in the database. Try another one.";
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("driver", newDriver);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
				dispatcher.forward(request, response);
				
			}
		}
	}
}

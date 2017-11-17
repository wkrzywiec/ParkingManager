package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CarLog;
import model.Driver;
import utils.DriversDAO;
import utils.ParkingDAO;
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String userLogin = request.getParameter("inputLogin");
		String userPassword = request.getParameter("inputPassword");
		int userType = 0;
		String errorMessage = null;
		
		userType = UsersDAO.getUserType(userLogin, userPassword);
	
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if(userType == 1){
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/owner.jsp");
		} else if(userType == 2){
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/operator.jsp");
		} else if(userType == 3){
			
			Driver driver = DriversDAO.getDriver(userLogin);
			session.setAttribute("driver", driver);
			ArrayList<CarLog> carLogList = ParkingDAO.getParkingHistory(driver.getDriverId(), driver.getDriverType());
			session.setAttribute("carLogList", carLogList);
			long parkingTime = ParkingDAO.getParkingTimeSec(driver.getDriverId());
			request.setAttribute("parkingTime", parkingTime);
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/driver.jsp");
		} else {
			errorMessage = "Upsss... There is no user with this login and/or password. Try again!";
			request.setAttribute("errorMessage", errorMessage);
			dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}

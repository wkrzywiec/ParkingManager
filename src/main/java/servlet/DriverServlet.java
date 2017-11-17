package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Driver;
import utils.ParkingDAO;

@WebServlet(name = "driver",
			urlPatterns = { "/driver" })
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DriverServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String buttonValue = request.getParameter("btn");
		long parkingTime = 0;
		HttpSession session = request.getSession();
		Driver driver = (Driver) session.getAttribute("driver");
		int driverId = driver.getDriverId();
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/driver.jsp");
		switch (buttonValue){
		
			case "start":
				
				ParkingDAO.startVisit(driverId);
				parkingTime = 1;
				request.setAttribute("parkingTime", parkingTime);
				requestDispatcher.forward(request, response);	
				break;
				
			case "stop":
				
				ParkingDAO.stopVisit(driverId);
				request.setAttribute("parkingTime", parkingTime);
				requestDispatcher.forward(request, response);	
				break;
			case "logout":
				session.invalidate();
				requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				break;
			default:
				session.invalidate();
				requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				break;
		}
		
		
	}

}

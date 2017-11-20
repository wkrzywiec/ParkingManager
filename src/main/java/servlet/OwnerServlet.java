package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Driver;
import utils.ParkingDAO;
import utils.ParkingTollUtils;

@WebServlet(name = "owner",
urlPatterns = { "/owner" })
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public OwnerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buttonValue = request.getParameter("btn");
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = null;
		
		switch (buttonValue){
		
			case "submit":
				
				String dateString = request.getParameter("date");
				double sum = 0;
				
				ArrayList<Long> secondsInDayForEachRegVisit = ParkingDAO.getSecondsInDayForEachVisit(dateString, Driver.DRIVER_REGULAR);
				ArrayList<Long> secondsInDayForEachVIPVisit = ParkingDAO.getSecondsInDayForEachVisit(dateString, Driver.DRIVER_VIP);
				
				sum = ParkingTollUtils.getTotalTollInDay(secondsInDayForEachRegVisit, Driver.DRIVER_REGULAR);
				sum = sum + ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVIPVisit, Driver.DRIVER_VIP);
				
				request.setAttribute("date", dateString);
				request.setAttribute("sum", sum);
				
				requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/owner.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "logout":
				
				requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				break;
				
		}
	}
}

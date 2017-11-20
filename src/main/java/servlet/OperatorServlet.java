package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "operator",
urlPatterns = { "/operator" })
public class OperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public OperatorServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher =  getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

}

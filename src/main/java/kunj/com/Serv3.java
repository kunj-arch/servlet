package kunj.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Serv3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        request.getRequestDispatcher("link.html").include(request, response);  
	
	HttpSession session= request.getSession(false);
	if(session!=null) {
		
		String name =(String)session.getAttribute("name");
		
		out.print("Hello,"+name+"WELCOME TO PROFILE");
	}
	else {
		out.print("PLESE LOGIN FIRST");
		request.getRequestDispatcher("login.html").include(request, response);
	}
	out.close();
	}

}

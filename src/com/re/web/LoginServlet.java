package com.re.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.re.dao.RealEstateDAO;
import com.re.dto.User;
//import com.ts.dao.CustomerDAO;
//import com.ts.dto.Customer;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet { 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			String mail_id=request.getParameter("mail_id");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", mail_id);
			
			
			response.setContentType("text/html");
			
			RealEstateDAO realestatedao = new RealEstateDAO();
			User user = realestatedao.getUser(mail_id,password);
			//Customer customer=customerDao.getCustomer(userName, password);
			System.out.println("Inside servlet:"+user);
			out.println("<html>");
			if(user !=null){
	RequestDispatcher dispatcher=request.getRequestDispatcher("userhomepage.jsp");	
			dispatcher.forward(request, response);			
			}
			else{
		out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);		
			}
			out.println("</html>");
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

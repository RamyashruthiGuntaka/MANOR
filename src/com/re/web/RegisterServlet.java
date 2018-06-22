package com.re.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.re.dao.RealEstateDAO;
import com.re.dto.User;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name =request.getParameter("Name");
		//Double =Double.parseDouble(request.getParameter("balance"));
		String mail_id=request.getParameter("mail_id");
		String password=request.getParameter("password");
		String phno=request.getParameter("phno");
		HttpSession session=request.getSession();
		session.setAttribute("loggedUser", mail_id);
		 User user=new User();
		 user.setName(Name);
		user.setMail_id(mail_id);
		user.setpassword(password);
		user.setPhno(phno);
		
		System.out.println(user);
		RealEstateDAO realestatedao=new RealEstateDAO();
		if(RealEstateDAO.addUser(user)!=0){
		
		response.getWriter().println("<h1>Registration Success</h1>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("./userhomepage.jsp");
		dispatcher.include(request, response);
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

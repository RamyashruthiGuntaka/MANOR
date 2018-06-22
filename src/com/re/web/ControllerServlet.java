package com.re.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.re.dao.DetailsDAO;
import com.re.dao.RealEstateDAO;
import com.re.dto.Detail;
import com.re.dto.User;



@WebServlet("/ControllerServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50, 
location = "C:\\Users\\KAVYA\\workspace\\RealEstateExpo4\\WebContent\\images")

public class ControllerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	System.out.println("Do Get called...");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("login".equalsIgnoreCase(action)) {
			PrintWriter out=response.getWriter();
			String mail_id=request.getParameter("mail_id");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			session.setAttribute("user_id", new RealEstateDAO().getUserId(mail_id));
			response.setContentType("text/html");
			RealEstateDAO realestatedao = new RealEstateDAO();
			User user = realestatedao.getUser(mail_id,password);
			request.getSession().setAttribute("mail_id", mail_id);
			//Customer customer=customerDao.getCustomer(userName, password);
			System.out.println("Inside servlet:"+user);
			out.println("<html>");
			if(user !=null){
	RequestDispatcher dispatcher=request.getRequestDispatcher("./userHomepage.jsp");	
			dispatcher.forward(request, response);			
			}
			else{
		out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
	RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			}
			
		}
		else if("register".equalsIgnoreCase(action)){
			String Name =request.getParameter("Name");
			//Double =Double.parseDouble(request.getParameter("balance"));
			String mail_id=request.getParameter("mail_id");
			String password=request.getParameter("password");
			String phno=request.getParameter("phno");
			HttpSession session=request.getSession();
			session.setAttribute("mail_id", mail_id);
			 User user=new User();
			 user.setName(Name);
			user.setMail_id(mail_id);
			user.setpassword(password);
			user.setPhno(phno);
			
			System.out.println(user);
			RealEstateDAO realestatedao=new RealEstateDAO();
			if(RealEstateDAO.addUser(user)!=0){
			
			//response.getWriter().println("<h1>Registration Success</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			}	
		}
		else if("details".equalsIgnoreCase(action)){
			HttpSession session=request.getSession();
			int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
			String City =request.getParameter("City");
			String Location=request.getParameter("Location");
			Double budget=Double.parseDouble(request.getParameter("budget"));
			String Address=request.getParameter("Address");
			String Area=request.getParameter("Area");
			String Phasing=request.getParameter("Phasing");
			Part part = request.getPart("photo");
			String fileName = getFileName(part);
			part.write(fileName);
						
			PrintWriter out=response.getWriter();
			DetailsDAO detailsdao=new DetailsDAO();
			
			session.setAttribute("loggedUser1", City);
			session.setAttribute("loggedUser",Location );
		//	session.setAttribute("loggedUser2",user_id);
			 Detail detail=new Detail();
			 detail.setUserId(user_id);
			 detail.setCity(City);
			 detail.setLocation(Location);
			 detail.setBudget(budget);
			 detail.setAddress(Address);
			 detail.setArea(Area);
			 detail.setPhasing(Phasing);
			 detail.setPhoto(fileName);
			 
			 //detail.setUser_type(user_type);
			 //out.println("<table> <tr> <th> city </th></tr> <tr><td>"+detail.getCity()+"</td><tr></table>");
			System.out.println(detail.toString());
			
			//String dob = request.getParameter("UpdatedOn");
			
			
		
			
		
		
			
			if(DetailsDAO.addDetail(detail)!=0){
			
			response.getWriter().println("<h1>Registration Success</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("property-2.html");
			dispatcher.include(request, response);			
		}
		
			
		}
		else if("retreive".equalsIgnoreCase(action)){
			System.out.println("Ïnside retrieve..action.");
			PrintWriter out=response.getWriter();
			DetailsDAO dao1 = new DetailsDAO();
			request.setAttribute("cities", dao1.showCities());
			//request.setAttribute("menu", dao.getMenu(restaurant));
			DetailsDAO dao=new DetailsDAO();
			List<Detail> detailsList=dao.showDetails(request.getParameter("City").toString(),request.getParameter("Location").toString());
			HttpSession session = request.getSession();
			System.out.println("---------------"+detailsList.get(0).getName()+"------------");
			session.setAttribute("detailsList", detailsList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("itemdetails.jsp");
			request.setAttribute("customerList", detailsList);
			dispatcher.forward(request, response);
			
			
		}
		
		
	}
	private String getFileName(Part part) {
		String content = part.getHeader("content-disposition");
		System.out.println("content-disposition :"+content);
 String fileName = content.substring(content.indexOf("filename") + 10, content.length() - 1);
 	System.out.println("fileName"+fileName);
 return fileName;
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*String City=request.getParameter("City");
			String Location=request.getParameter("Location");
			
			//int user_id = Integer.parseInt(request.getParameter("user_id"));
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", City);
			session.setAttribute("loggedUser1",Location);
		//	session.setAttribute("loggedUser2",user_id);
			// Detail detail=new Detail();
			 
			response.setContentType("text/html");
			
			DetailsDAO detailsDao = new DetailsDAO();
			Detail detail=detailsDao.showDetails(City,Location);
			System.out.println("Inside servlet:"+detail);
			out.println("<html>");
			if(detail !=null){
				out.println("<table>) <tr> <th> city </th><th> location</th><th> Address</th><th>budget</th><th>Name</th> <tr><td>"+detail.getCity()+"</td><td>"+detail.getLocation()+"</td><td>"+detail.getAddress()+"</td><td>"+detail.getBudget()+"</td><td>"+detail.getName()+"/<td></tr></table>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("./searchPage.jsp");	
						dispatcher.forward(request, response);
				//.out.println("Details : " + customer);
						}
			else{
				//out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
				//RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
				//dispatcher.include(request, response);	
			out.println("No such Id");
	}*/
	


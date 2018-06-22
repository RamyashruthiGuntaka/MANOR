<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.re.dto.Detail" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANOR | Item Details Page</title>
		
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">  
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
</head>
 <%
List<Detail> detailsList=(List<Detail>)session.getAttribute("detailsList");
%>

<body>
<nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="assets/img/logo2.png" alt=""></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">
                	<!-- <div class="button navbar-right">
                        <button class="navbar-btn nav-button wow bounceInRight login" onclick=" window.open('submit-property.html')" data-wow-delay="0.48s">Submit</button> 
                    </div>-->
                    
                    <div class="button navbar-right">
                      	<li class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s"><a class="" href="submit-property.html">Submit</a></li>
                    </div>
                    
                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="userHomepage.jsp">Home</a>
                            
                        </li>

                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.html">Properties</a></li>
                        
                        </ul>
                </div>
            </div>
        </nav>
         <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">Item Details</h1>               
                    </div>
                </div>
            </div>
        </div>
        

  <div class="section"> 
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
                                       
                                         <div class="item-entry overflow">
                                           
                                            <div class="page-head-content">
                        <h3 class="page-title">Property Details</h3>               
                    </div>
     
      										<c:forEach var="detail" items="${detailsList}">
                                            <div class="dot-hr"></div>
                                            
                                             <span class="pull-left"><b> Owner Name :</b> ${detail.getName()} </span><br>
                                             <span class="proerty-price pull-right">Price: ${detail.getBudget()}</span>
                                            <span class="pull-left"><b> Area :</b> ${detail.getArea()}</span><br>
                                            <span class="pull-left"><b> Contact number :</b> ${detail.getPhno()} </span>
                                            <p style="display: none;">Property Description..</p>
                                            <span class="pull-left"><b> City :</b> ${detail.getCity()} </span><br>
                                            <span class="pull-left"><b> Location :</b> ${detail.getLocation()} </span><br>
                                            <span class="pull-left"><b> Address :</b> ${detail.getAddress()} </span><br>
                                            <span class="pull-left"><b> Phasing :</b> ${detail.getPhasing()} </span><br>
                                            <span class="pull-left"><b> Photo :</b><img src="./images/${detail.getPhoto()}" alt="Show image"> </span> 
                                            		</c:forEach>		
                                            
                                        </div>
                                    </div>
                                </div>                             

                                                                                        
                            </div>
     
     
     
     
                   <%--  <% while ( i < detailsList.size()) { %>
                                            <div class="dot-hr"></div>
                                            
                                             <span class="pull-left"><b> Owner Name :</b> <%=detailsList.get(i).getName() %> </span><br>
                                             <span class="proerty-price pull-right">Price: <%=detailsList.get(i).getBudget() %></span>
                                            <span class="pull-left"><b> Area :</b> <%=detailsList.get(i).getArea() %> </span><br>
                                            <span class="pull-left"><b> Contact number :</b> <%=detailsList.get(i).getPhno() %> </span>
                                            <p style="display: none;">Property Description..</p>
                                            <span class="pull-left"><b> City :</b> <%=detailsList.get(i).getCity() %> </span><br>
                                            <span class="pull-left"><b> Location :</b> <%=detailsList.get(i).getLocation() %> </span><br>
                                            <span class="pull-left"><b> Address :</b> <%=detailsList.get(i).getAddress() %> </span><br>
                                            <span class="pull-left"><b> Phasing :</b> <%=detailsList.get(i).getPhasing() %> </span>
                                            <span class="pull-right"><b> Photo :</b><img src="C:\Users\KAVYA\workspace\RealEstateExpo4\WebContent\images\download.jpg"> </span> 
                                            <% i=i+1;	} %>  
                                        </div>
                                    </div>
                                </div>                             

                                                                                        
                            </div>
 --%>                        <!--     <div class="col-sm-4 col-sm-offset-1">
                                                <div class="picture-container">
                                                    <div class="picture">
                                                        <img src="assets/img/default-property.jpg" class="picture-src" id="wizardPicturePreview" title=""/>
                                                        <input type="file" id="wizard-picture">
                                                    </div> 
                                                </div>
                                            </div>
                        </div>-->
	 	 
</body>
</html>
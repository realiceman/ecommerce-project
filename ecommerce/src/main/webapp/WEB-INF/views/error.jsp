<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  
<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />    

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Store - ${title}</title>
    <script>
      window.menu = '${title}';
      window.contextRoot = '${contextRoot}'
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
     <!-- Bootstrap theme CSS -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

  <!-- Bootstrap datatables CSS -->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <!-- Custom styles for this template -->
    <link href="${css}/my-app.css" rel="stylesheet">

  </head>

  <body>

  <div class="wrapper">
	 		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                
	                <a id="home" class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
	            </div>
	        </div>
       </nav>

		<!-- page content -->

		<div class="content">
			
			<div class="container">
			   <div class="row">
			      <div class="col-xs-12">
			         <div class="jumbotron">
			              <h1>${errorTitle}</h1>
			              <hr/>
			              <blockquote style="word-wrap:break-word">
			                 ${errorDescription}
			              </blockquote>
			         </div>
			      </div>
			   </div>
			</div>
		    
		</div>
		
	    <!-- Footer -->
	    <%@include file="./shared/footer.jsp" %>
	
	    <!-- Bootstrap core JavaScript -->
	    <script src="${js}/jquery.js"></script>
	    <script src="${js}/bootstrap.bundle.min.js"></script>
	    <script src="${js}/jquery.dataTables.js"></script>
	    <script src="${js}/dataTables.bootstrap4.js"></script>
	    <script src="${js}/myapp.js"></script>
    
    </div>
  </body>

</html>

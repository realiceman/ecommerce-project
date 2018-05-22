<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
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
    <link href="${css}/toggle.css" rel="stylesheet">
  </head>

  <body>

  <div class="wrapper">
	    <!-- Navigation -->
	    <%@include file="./shared/navbar.jsp" %>
	   
		   
		    <!-- Page Content -->
		    <div class="content">
			    <c:if test="${userClickHome == true}">
			       <%@include file="home.jsp" %>
			    </c:if>
			    
			     <c:if test="${userClickAbout == true}">
			       <%@include file="about.jsp" %>
			    </c:if>
			    
			     <c:if test="${userClickContact == true}">
			       <%@include file="contact.jsp" %>
			    </c:if>
			    
			    <c:if test="${userClicAllProducts == true || userClicCategoryProducts == true}">
			       <%@include file="listProducts.jsp" %>
			    </c:if>

				<c:if test="${userClickShowProduct == true}">
					<%@include file="singleProduct.jsp"%>
				</c:if>
				
					<c:if test="${userClickManageProducts == true}">
					<%@include file="manageProducts.jsp"%>
				</c:if>

		</div>
	    <!-- Footer -->
	    <%@include file="./shared/footer.jsp" %>
	
	    <!-- Bootstrap core JavaScript -->
	    <script src="${js}/jquery.js"></script>
	    <script src="${js}/jquery.validate.min.js"></script>
	    <script src="${js}/bootstrap.bundle.min.js"></script>
	    <script src="${js}/jquery.dataTables.js"></script>
	    <script src="${js}/dataTables.bootstrap4.js"></script>
	    <script src="${js}/bootbox.min.js"></script>
        <script src="${js}/myapp.js"></script>
    </div>
  </body>

</html>

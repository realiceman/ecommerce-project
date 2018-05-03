<div class="container">

	<!-- breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item active"><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>
	</div>
	
	<div class="row">
	 <!-- display product image -->
	   <div class="col-xs-12 col-sm-4">
	      <div class="thumbnail">
	         <img class="img-thumbnail" src="${images}/${product.code}.jpg" />
	      </div>
	   </div>
	   
	   <!-- product desc -->
	    <div class="col-xs-12 col-sm-4">
	      <h3>${product.name}</h3>
	      <hr/>
	      <p>${product.description}</p>
	      <hr/>
	      <h4>Price: <strong>&#036; ${product.unitPrice}</strong></h4>
	      <hr/>
	    
	      <c:choose>
	          <c:when test="${product.quantity < 1}">
	              <h6>Qty. Available: <span style="color:red">Out of stock !</span></h6>
	          </c:when>
	          <c:otherwise>
	              <h6>Qty. Available: ${product.quantity}</h6>
	          </c:otherwise>
	      </c:choose>
	      
	         <c:choose>
	          <c:when test="${product.quantity < 1}">
	                <a href="#" class="btn btn-success disabled"><span style="text-decoration: line-through;"><i class="fa fa-shopping-cart"></i>Add to cart</span></a>
	          </c:when>
	          <c:otherwise>
	                <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><i class="fa fa-shopping-cart"></i>Add to cart</a>
	          </c:otherwise>
	      </c:choose>
	      
	       <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
	   </div>
	</div>

</div>
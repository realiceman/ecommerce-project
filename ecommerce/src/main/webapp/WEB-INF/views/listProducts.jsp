<div class="container">
	<div class="row">
		<!-- sidebar -->
		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- products -->
		<div class="col-md-9">
			<!-- breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClicAllProducts==true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClicCategoryProducts==true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			
			<div class="row">
			    <div class="col-lg-12">
			      <table id="productListTable" class="table table-striped tabled-bordered">
			        <thead>
			           <tr>
			               <th>ID</th>
			               <th>Name</th>
			           </tr>
			        </thead>
			        
			      </table>
			    </div>
			</div>
			
		</div>
	</div>
</div>
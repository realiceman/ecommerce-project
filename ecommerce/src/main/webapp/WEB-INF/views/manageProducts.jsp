<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">

 <div class="row">
  <c:if test="${not empty message}">
     <div class="col-xs-12">
       <div class="alert alert-success alert-dismissible">
           <button type="button" class="close" data-dismiss="alert">&times;</button>
           ${message}
       </div>
     </div>
   </c:if>  
     <br/>
    <div class="col-md-offset-2 col-md-8">
         <div class="card">
             <div class="card-header">
                 <h4>Product Management</h4>
             </div>
             <div class="card-body">
                <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
                   <div class="form-group row">  
                       <label class="control-label col-md-4" for="name">Enter product name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="name" id="name" placeholder="Product name" class="form-control" />
                            <sf:errors path="name" cssClass="help-block" element="em" />
                        </div>
                   </div>
                   
                   <div class="form-group row">
                       <label class="control-label col-md-4" for="brand">Enter brand name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" path="brand" id="brand" placeholder="Brand name" class="form-control" />
                            <sf:errors path="brand" cssClass="help-block" element="em" />
                        </div>
                   </div>
                   
                   <div class="form-group row">
                       <label class="control-label col-md-4" for="description">Product description:</label>
                        <div class="col-md-8">
                           <sf:textarea path="description" id="description" rows="4" cols="40" placeholder="Write a description" />
                           <sf:errors path="description" cssClass="help-block" element="em" />
                        </div>
                   </div>
                   
                     <div class="form-group row">
                       <label class="control-label col-md-4" for="quantity">Quantity available:</label>
                        <div class="col-md-8">
                            <sf:input type="number" path="quantity" id="quantity" placeholder="Quantity available" class="form-control" />
                            <sf:errors path="quantity" cssClass="help-block" element="em" />
                        </div>
                   </div> 
                   
                   <div class="form-group row">
                       <label class="control-label col-md-4" for="file">Select an image:</label>
                        <div class="col-md-8">
                            <sf:input type="file" path="file" id="file"  class="form-control" />
                            <sf:errors path="file" cssClass="help-block" element="em" />
                        </div>
                   </div>
                   
                    <div class="form-group row">
                       <label class="control-label col-md-4" for="unitPrice">Enter unit price:</label>
                        <div class="col-md-8">
                             <sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit price in CAD" class="form-control" />
                             <sf:errors path="unitPrice" cssClass="help-block" element="em" />
                        </div>
                   </div>
                   
                    <div class="form-group row">
                       <label class="control-label col-md-4" for="categoryId">Select category:</label>
                        <div class="col-md-8">
                           <sf:select class="form-control" id="categoryId" path="categoryId" 
                                      items="${categories}" 
                                      itemLabel="name"
                                      itemValue="id" />
                           <c:if test="${product.id == 0}">
                              <br/>
                              <div class="text-right">
                              <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn  btn-warning btn-sm">Add Category</button>
                              </div>
                           </c:if>
                        </div>
                   </div>
                   
                     <div class="form-group row">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
                            
                            <sf:hidden path="id"/>
                            <sf:hidden path="code"/>
                            <sf:hidden path="supplierId"/>
                            <sf:hidden path="purchases"/>
                            <sf:hidden path="views"/>
                            <sf:hidden path="active"/>
                        </div>
                   </div>
                   
                </sf:form>
             </div>
         </div>
    </div>
 
 </div>

	<div class="row">
		<div class="col-lg-12">
			<h3>Available Products</h3>
			<hr />
		</div>

		<div class="col-lg-12">
			<div class="container-fluid">
				<div class="table-responsive">
					<table id="adminProductsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Code</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>Code</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>

	</div>
	
	
	
	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Add new category</h4>
          <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <!-- cat form -->
          <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" >
            <div class="form-group row"> 
                <label class="control-label col-md-4" for="category_name">Enter category name:</label>
                <div class="col-md-8">
                    <sf:input type="text" path="name" id="category_name" placeholder="Category name" class="form-control" />
                </div>
            </div> 
             <div class="form-group row">
                 <label class="control-label col-md-4" for="category_description">Category description:</label>
                  <div class="col-md-8">
                     <sf:textarea path="description" id="category_description" rows="4"  placeholder="Write a description" />
                  </div>
             </div> 
             <div class="form-group">
               <div class="col-md-offset-4 col-md-8">
		          <button type="submit"  class="btn btn-primary">Add Category</button>
		        </div>
             </div>
          </sf:form>
        </div>
        
        
      </div>
    </div>
  </div>
	
</div>
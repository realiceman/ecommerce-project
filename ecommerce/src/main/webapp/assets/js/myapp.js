$(function(){
	switch(menu){
	case "About Us":
		$('#about').addClass("active");
		break;
	case "Contact":
		$('#contact').addClass("active");
		break;
	case "All products":
		$('#listProducts').addClass("active");
		break;
	case "Manage products":
		$('#manageProducts').addClass("active");
		break;
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass("active");
	    $('#a_'+menu).addClass("active");
	    break;
	}
	
	
	
	//code for testing jquery datatable
	//dataset
	var products = [
		['1','abc'],
		['2','def'],
		['3','ghi'],
		['1','abcddd'],
		['2','defddd'],
		['3','ghiddd']
	];
	
	var $table = $("#productListTable");
	//execute the code if table is available
	if($table.length){
	//	console.log("inside the table");
		var jsonUrl = "";
		if(window.categoryId == ""){
			jsonUrl = window.contextRoot +"/json/data/all/products";
		}else{
			jsonUrl = window.contextRoot +"/json/data/category/"+window.categoryId+"/products";
		}
		$table.DataTable({
			lengthMenu : [[3,5,10,-1], ['3', '5', '10', 'All']],
			pageLength : 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img style="height:100px;width:100px;" src="'+window.contextRoot+'/resources/images/'+data+'.jpg" />';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return "&#036; "+data;
					}
				},
				{
				     data: 'quantity',
				     mRender: function(data, type, row){
				    	 if(data < 1){
				    		 return '<span style="color:red">Out of stock!</span>';
				    	 }
				    	 return data;
				     }
				 },
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row){
						var str = '';
						str += '<a class="btn btn-outline-primary" href="'+window.contextRoot+'/show/'+data+'/product"><i  class="fa fa-eye align-middle"></i></a> ';
					
						if(row.quantity < 1){
							str += '<a class="btn btn-outline-primary disabled" href="#"><i class="fa fa-shopping-cart"></i></a>';
						}else{
							str += '<a class="btn btn-outline-primary" href="'+window.contextRoot+'/cart/add/'+data+'/product"><i class="fa fa-shopping-cart"></i></a>';
						}
						return str;
					}
				}
			]
		});
	}
	
	//dimiss the alert after 3s
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	//----------------------------------------------------------------------------
	

	
	
	//------datatable for admin----------\\
	
	var $adminProductsTable = $("#adminProductsTable");
	//execute the code if table is available
	if($adminProductsTable.length){
		var jsonUrl = window.contextRoot+"/json/data/admin/all/products";
		
		$adminProductsTable.DataTable({
			lengthMenu : [[10,30,50,-1], ['10','30', '50', 'All']],
			pageLength : 30,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id'
				},
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img style="height:100px;width:100px;" src="'+window.contextRoot+'/resources/images/'+data+'.jpg" />';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return "&#036; "+data;
					}
				},
				{
				     data: 'quantity',
				     mRender: function(data, type, row){
				    	 if(data < 1){
				    		 return '<span style="color:red">Out of stock!</span>';
				    	 }
				    	 return data;
				     }
				 },
				{
					data: 'active',
					bSortable: false,
					mRender: function(data, type, row){
						var str="";
						str +=  ' <label class="switch">';
						if(data){
							str +=  ' <input type="checkbox" checked="checked"  value="'+row.id+'"/>';
						}else{
							str +=  ' <input type="checkbox"  value="'+row.id+'"/>';
						}
						str +=  ' <div class="slider"></div>';
						str +=  ' </label>';
						
						return str;
					}
				},
				{
					data: 'id',
					bSortable:  false,
					mRender: function(data, type, row){
						var str="";
						    str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"/>';
                            str+='<i class="fa fa-pencil"></i>';
                            
                            return str;
					}
				}
			],
			initComplete: function(){
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function(){
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'Do you want to activate the product ?': 'Do you want to deactivate the product ?';
					var value = checkbox.prop('value');
					
					bootbox.confirm({
					  size: 'medium',
					  title: 'Product activation/deactivation',
					  message: dMsg,
					  callback: function(confirmed){
						  if(confirmed){
							  console.log(value);
							  var activationUrl = window.contextRoot+'/manage/product/'+value+'/activation';
							  $.post(activationUrl, function(data){
								  bootbox.alert({
									  size: 'medium',
									  title: 'information',
									  message: data
								  });
								  
							  });
							  
							
						  }else{
							  checkbox.prop('checked', !checked);
						  }
					  }
					});
					
				});
			}
		});
	}
	
});


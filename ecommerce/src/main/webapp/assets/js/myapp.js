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
					data: 'quantity'
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row){
						var str = '';
						str += '<a class="btn btn-outline-primary" href="'+window.contextRoot+'/show/'+data+'/product"><i  class="fa fa-eye align-middle"></i></a> &#160;';
						str += '<a class="btn btn-outline-primary" href="'+window.contextRoot+'/cart/add/'+data+'/product"><i class="fa fa-shopping-cart"></i></a>';
						return str;
					}
				}
			]
		});
	}
	
});


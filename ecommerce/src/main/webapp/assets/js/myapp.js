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
	
	
	
	//code for jquery datatable
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
		$table.DataTable({
			lengthMenu : [[3,5,10,-1], ['3', '5', '10', 'All']],
			pageLength : 5,
			data : products
		});
	}
	
});


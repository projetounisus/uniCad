function headerFunctions(){
	var logoutOpition = $("#logoutOption");
	var editarOpition = $("#editarOption");
	var idDiv = $("#userId");
	
	logoutOpition.bind("click", function(){
		$.ajax({
		  url:utils.buildURL("/logout"),
	      success:function(data){
	        location.reload();
	      }
	    });
	});
	
	editarOpition.bind("click", function(){
//		$.ajax({
//		  url:utils.buildURL("/usuario/editar/" + idDiv.val()),
//		      success:function(data){
//		        location.reload();
//		      }
//	    });
		
		location.href = utils.buildURL("/usuario/editar/" + idDiv.val());
	});
}

$(document).ready(headerFunctions);
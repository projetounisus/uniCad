var Form = function(){
	var nomeObjeto = $("#nomeObjeto").val();
	var idObjeto = $("#idObjeto").val();
	var $confirmFormButton = $("#confirmForm");
	
	var obterInputs = function($formDiv){
		var $inputs = $formDiv.children(".inputContainer").find("input");
		var $selects = $formDiv.children(".inputContainer").find("select");
		
		$.each($selects, function(index, current){
			$inputs.push(current);
		});
		
		var dto = {};
		
		$.each($inputs, function(index, current){
			var fieldName = current.attributes.name.value;
			var $current = $(current);
			dto[fieldName] = $current.val();
		});
		
		var $childrenFormDivs = $formDiv.children(".formDiv");
		
		$.each($childrenFormDivs, function(index, current){
			var fieldName = current.attributes.name.value;
			dto[fieldName] = obterInputs($(current));
		});
		
		return dto;
	}
	
	var construirDto = function(){
		var $forms = $("#form");
		var $formDivs = $forms.children(".formDiv");
		
		var dto = obterInputs($formDivs);
		
		return dto;
	}
	
	$confirmFormButton.bind("click", function(){
		var dto = construirDto();
		var dtoStr = JSON.stringify(dto);
		
		$.ajax({
			url: utils.buildURL("/" + nomeObjeto + "/" + idObjeto), 
			method: "POST",
			contentType: 'application/json',
			data: dtoStr
		});
	});
};

$(document).ready(Form);
function listRegisters(registers){
  var $registerList = $("#registersList");
  var registerListTemplateContent = $registerList.html();
  var registerListTemplate = Handlebars.compile(registerListTemplateContent);

  var registerListContent = registerListTemplate({register:registers});

  var $registerListContainer = $("#registerListContainer");
  $registerListContainer.html(registerListContent);
  var $registersContainers = $(".register-container");

  $.each($registersContainers, function(index, currentContainer){
    $(currentContainer).accordion({
      active: false,
      collapsible: true
    });
  });
}

function constructPage(){
  var $userId = $("#userId");
  var userId = $userId.val();

  var urlMethod = "/usuario/" + userId + "/Register";
  var urlRequest = utils.buildURL(urlMethod);

  $.ajax({url: urlRequest,
    success: function(data){
      listRegisters(data);
    }
  });
}

$(document).ready(constructPage);

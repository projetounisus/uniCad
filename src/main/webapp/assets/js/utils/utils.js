var Utils = function(){
  function _buildURL(urlMethod){
    return "/uniSusWeb" + urlMethod;
  }

  var scope = {
    buildURL: _buildURL
  }

  return scope;
}

var utils = new Utils();

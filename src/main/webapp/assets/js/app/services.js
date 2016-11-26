angular.module('app')
.service('sessionService', ['$http', function($http){
	return {
		getLoggedUser: function () {
			return $http.get('loggedUser');
		}
	};
}])
.service('usersService', ['$http', function($http){
	
	var _getUsers = function(){
		return $http.get('user/list/');
	}

	var _delete = function(id){
		return $http.post('user/delete/?id=' + id);
	}

	var _create = function(bean){
		return $http({
			url: 'user/create/', 
			method: 'POST',
			data: bean,
			headers: {
   				'Content-Type': 'application/json'
 				}
			});
	}

	return {
		getUsers: _getUsers,
		delete: _delete,
		create: _create
	};
}])
.service('medicService', ['$http', function($http){
	
	var _getMedics = function(){
		return $http.get('medic/list/');
	}

	var _delete = function(id){
		return $http.post('medic/delete/?id=' + id);
	}

	var _create = function(bean){
		return $http({
			url: 'medic/create/', 
			method: 'POST',
			data: bean,
			headers: {
   				'Content-Type': 'application/json'
 				}
			});
	}

	return {
		getMedics: _getMedics,
		delete: _delete,
		create: _create
	};
}])
.service('pacientRegisterService', ['$http', function($http){
	var _getPacientRegisters = function(paramValue, paraCode){
		return $http.get("medicRegisters/historic/?paramValue=" + paramValue + "&paramType=" + paraCode);
	};

	return {
		getPacientRegisters : _getPacientRegisters
	};
}]);
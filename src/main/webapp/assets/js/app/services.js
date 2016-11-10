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
}]);
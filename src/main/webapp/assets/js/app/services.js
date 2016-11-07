angular.module('app')
.service('sessionService', ['$http', function($http){
	return {
		getLoggedUser: function () {
			return $http.get('loggedUser');
		}
	};
}])
.service('usersService', ['$http', function($http){
	return {
		getUsers: function(){
			return $http.get('user');
		}
	};
}]);
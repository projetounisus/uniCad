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

	var _update = function(bean){
		return $http({
			url:'medic/update/?id=' + bean.id,
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
		create: _create,
		update: _update
	};
}])
.service('pacientRegisterService', ['$http', function($http){
	var _getPacientRegisters = function(paramValue, paraCode){
		return $http.get("medicRegisters/historic/?paramValue=" + paramValue + "&paramType=" + paraCode);
	};

	var _create = function(bean){
		return $http({
			url:'medicRegister/create/',
			method:	'POST',
			data: bean,
			headers: {
				'Content-Type': 'application/json'
			}
		});
	}

	return {
		getPacientRegisters : _getPacientRegisters,
		create: _create 
	};
}])
.service('atendimentUnityService', ['$http', function($http){
	var _getAtendimentUnities = function(){
		return $http.get('unity/list/');
	};

	return {
		getAtendimentUnities: _getAtendimentUnities
	}; 
}])
.service('specialityService', ['$http', function($http){
	var _getSpecialities = function(){
		return $http.get('speciality/list/');
	};

	return {
		getSpecialities: _getSpecialities,
	};
}])
.service('pacientService', ['$http', function($http){
	var _getPacients = function(){
		return $http.get('pacient/list/');
	};

	var _delete = function(id){
		return $http.post('pacient/delete/?id=' + id);
	};

	var _create = function(bean){
		return $http({
			url: 'pacient/create/',
			method: 'POST',
			data: bean,
			headers: {
				'Content-Type': 'application/json'				
			}
		});
	};

	return {
		getPacients: _getPacients,
		delete: _delete,
		create: _create
	}; 
}])
.service('unityService', ['$http', function($http){
	var _getUnities = function(){
		return $http.get('unity/list/');
	};

	return {
		getUnities: _getUnities
	};
}]);
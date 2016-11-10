angular.module('app')
.controller('templateHeaderCtrl', ['$scope', 'sessionService', function($scope, sessionService){
	var request = sessionService.getLoggedUser();

	request.success(function(user){
		$scope.user = user;
	});
}])
.controller('mainPageCtrl', ['$scope', '$location', '$window', function($scope, $location, $window){
	$scope.listUsers = function(){
		$location.path("/user-list");
	};

	$scope.listMedics = function(){
		$location.path("/medic-list");
	};	
}])
.controller('usersCtrl', ['$scope', 'usersService', function($scope, usersService){
	var request = usersService.getUsers();

	request.success(function(users){
		$scope.users = users;
	});

	$scope.delete = function(bean){
		var indexToRemove = $scope.users.indexOf(bean);
		$scope.users.splice(indexToRemove, 1);

		var request = usersService.delete(bean.id);

		request.success(function(response){
			console.log("bean: " + bean.id + " has deleted");
		});
	};

	$scope.createOrAdd = function(currentUser){
		if(currentUser.id === undefined || currentUser.id === null || currentUser.id === 0)
		{
			usersService.create(currentUser)
			.success(function(data, status){
				$scope.users.push(data);
			});
		}
	};
}])
.controller('medicCtrl', ['$scope', 'medicService', function($scope, medicService){
	var request = medicService.getMedics();

	request.success(function(medics){
		$scope.users = medics;
	});

	$scope.delete = function(bean){
		var indexToRemove = $scope.users.indexOf(bean);
		$scope.users.splice(indexToRemove, 1);

		var request = medicService.delete(bean.id);

		request.success(function(response){
			console.log("bean: " + bean.id + " has deleted");
		});
	};

	$scope.createOrAdd = function(currentUser){
		if(currentUser.id === undefined || currentUser.id === null || currentUser.id === 0)
		{
			medicService.create(currentUser)
			.success(function(data, status){
				$scope.users.push(data);
			});
		}
	};
}]);
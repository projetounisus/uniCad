angular.module('app')
.controller('templateHeaderCtrl', ['$scope', 'sessionService', function($scope, sessionService){
	var request = sessionService.getLoggedUser();

	request.success(function(user){
		$scope.user = user;
	});
}])
.controller('mainPageCtrl', ['$scope', '$location', '$window', function($scope, $location, $window){
	$scope.selectionParams = [
		{paramName:"CNS", paramCode: 0},
		{paramName:"CPF", paramCode: 1},
		{paramName: "RG", paramCode: 2}
	];

	$scope.selectionMode = {
		currentMode: 0
	};

	$scope.listUsers = function(){
		$location.path("/user-list");
	};

	$scope.listMedics = function(){
		$location.path("/medic-list");
	};

	$scope.listSpecilaities = function(){
		$location.path("/specialities");	
	}	

	$scope.listMedicRegisters = function(){
		$location.path("/medic-registers");
	}

	$scope.insertSelectionParamInput = function(selectionModeCode){
		$scope.selectionMode.currentMode = selectionMode;
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
}])
.controller('medicRegisterCtrl', ['$scope', 'pacientRegisterService', function($scope, $pacientRegisterService){
	$scope.selectionParams = [
		{name: 'CPF', id: 1},
		{name: 'RG', id: 2},
		{name: 'CNS', id: 3}
	];

	$scope.registers = [];

	$scope.currentSelectionParam = 1;

	$scope.searchPanelVisible = true;

	$scope.setSelectionParam = function(selectionParam){
		$scope.currentSelectionParam = selectionParam.id;
	};

	$scope.getPacientRegisters = function(){
		var paramValue = $scope.paramSearchValue;
		var request = $pacientRegisterService.getPacientRegisters(paramValue, $scope.currentSelectionParam);

		request.success(function(data){
			$scope.pacient = data.pacient;
			$scope.registers = data.registers;
			$scope.searchPanelVisible = false;
		});
	}
}]);
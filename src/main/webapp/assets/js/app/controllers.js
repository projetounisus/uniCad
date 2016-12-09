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

	$scope.lisPacient = function(){
		$location.path("/pacients");
	}

	$scope.specialities = function(){
		$location.path("/specialities");
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
.controller('medicCtrl', ['$scope', 'medicService','atendimentUnityService','specialityService', function($scope, medicService, atendimentUnityService, specialityService){
	
	var request = medicService.getMedics();

	var _buildModal = function(){
		var requestGetUnities = atendimentUnityService.getAtendimentUnities();

		requestGetUnities.success(function (unities){
			$scope.atendimentUnities = unities;
		});

		var requestGetSpeciatlities = specialityService.getSpecialities();

		requestGetSpeciatlities.success(function(specialities){
			$scope.specialities = specialities;
		});
	};
	
	var _intantiateCurrentUser = function(){
		$scope.currentUser = {
			specialities:[]
		};
	} 

	_buildModal();
	_intantiateCurrentUser();

	$scope.specialitiesBuffer = [];

	request.success(function(medics){
		$scope.users = medics;
	});

	$scope.addUserSpecialityBuffer = function(speciality){
		$scope.specialitiesBuffer.push(speciality);
		//$scope.currentUser.specialities.push(speciality);
	};

	$scope.confirmUserSpecialities = function(specialities){
		$scope.currentUser.specialities = specialities;
	}

	$scope.cancelUserSpecialities = function(){
		$scope.specialitiesBuffer = $scope.currentUser.specialities;
	}

	$scope.delete = function(bean){
		var indexToRemove = $scope.users.indexOf(bean);
		
		var request = medicService.delete(bean.id);

		request.success(function(response){
			console.log("bean: " + bean.id + " has deleted");
			$scope.users.splice(indexToRemove, 1);
		});
	};

	$scope.createOrAdd = function(currentUser){
		if(currentUser.id === undefined || currentUser.id === null || currentUser.id === 0)
		{
			medicService.create(currentUser)
			.success(function(data, status){
				$scope.users.push(data);
			});
		}else{
			medicService.update(currentUser)
			.success(function(userUpdated, status){
				for(var currentUserIndex = 0; currentUserIndex <  $scope.users.length; currentUserIndex++)
				{
					var currrentUser = $scope.users[currentUserIndex];
					
					if(currentUser.id == userUpdated.id){
						$scope.users[currentUserIndex] = userUpdated;
					}
				}
			});
		}
	};
	
	//FIX-ME: speciality deve ser no plural
	$scope.setCurrentUser = function(currentUser){
		var adjustedUser = {
			id: currentUser.id,
			completeName: currentUser.completeName,
			cpf: currentUser.cpf,
			genre: currentUser.genre,
			address: currentUser.address,
			login: currentUser.login,
			crm: currentUser.crm,
			speciality: currentUser.speciality,
			atendimentUnity: currentUser.atendimentUnity,
			birthDate: new Date(currentUser.birthDate)
		}; 
		
		$scope.currentUser = adjustedUser;
		$scope.specialitiesBuffer = adjustedUser.speciality;
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

	// Específico... estranho, ajustar isso, torná-lo genérico
	var _getPacientAgeFromBirthDateString = function(dateString){
		var pacientBirthDate = new Date(dateString);
		var currentDate = new Date();

		var pacientYear = pacientBirthDate.getFullYear();
		var currentYear = currentDate.getFullYear();

		return currentYear - pacientYear;
	};

	$scope.createOrAdd = function(bean){
		var request = $pacientRegisterService.create(bean);

		request.sucess(function(data){
			$scope.registers.push(data);
		});
	};

	$scope.getPacientRegisters = function(){
		var paramValue = $scope.paramSearchValue;
		var request = $pacientRegisterService.getPacientRegisters(paramValue, $scope.currentSelectionParam);

		request.success(function(data){
			$scope.searchPanelVisible = false;
			$scope.registers = data.registers;

			$scope.pacient = data.pacient;
			$scope.pacient.age = _getPacientAgeFromBirthDateString(data.pacient.birthDate);
		});
	};
}]);
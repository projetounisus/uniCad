angular.module('app',['ngRoute'])
.config(function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: '/uniCad/appPages/homePage',
		controller: 'mainPageCtrl'
	})
	.when('/user-list', {
		templateUrl: '/uniCad/appPages/usersPage',
		controller: 'usersCtrl'
	})
	.when('/medic-list', 
	{
		templateUrl: '/uniCad/appPages/medicPage',
		controller: 'medicCtrl'
	})
	.when('/medic-registers',
	{
		templateUrl: '/uniCad/appPages/medicRegisters',
		controller: 'medicRegisterCtrl'
	})
	.otherwise('/');
});
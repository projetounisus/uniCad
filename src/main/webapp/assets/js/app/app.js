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
	.otherwise('/');
});
angular.module('appModule',['ngRoute', 'ngCookies', 'authModule', 'chart.js', 'ngAnimate', 'ui.bootstrap'])
.config(function($routeProvider){
	
	$routeProvider
		.when('/', {
			template : `
				<home></home>
			`
		})
		.when('/about', {
			template : `
				<about></about>
				`
		})
		.when('/contact', {
			template : `
				<contact></contact>
				`
		})
		.when('/register', {
			template : `
				<register></register>
				`
		})
		.when('/login', {
			template : `
				<login></login>
				`
		})
		.when('/logout', {
			template : `
				<logout></logout>
				`
		})
		.when('/todos', {
			template : `
				<todo-list></todo-list>
			`
		})
		.when('/todos/:id', {
			template : `
				<todo-list></todo-list>
				`
		})
		.when('/search/:mySearchTerm', {
			template : `
				<search></search>
				`
		})
		.when('/_404', {
			template : `
				<not-found></not-found>
			`
		})
		.when('/error', {
			template : `
				<h1>Something has gone awry</h1>
			`
		})
		.otherwise({
			template : `
				<not-found></not-found>
			`
		})
	
});
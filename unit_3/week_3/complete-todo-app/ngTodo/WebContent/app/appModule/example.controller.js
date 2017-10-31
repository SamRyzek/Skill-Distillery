angular.module('appModule')
.controller('example', function($scope, todoService, $filter) {
	$scope.labels = ["Complete Todos", "Incomplete Todos"];
	$scope.data = [100, 100];
	var updateChart = function() {
		todoService.index()
		.then(function(res) {
			var incomplete = $filter('incomplete')(res.data).length
			var complete = res.data.length - incomplete;
			$scope.data = [incomplete, complete];
		})
	}
	
	$scope.$on('todoCount', updateChart)
	
	
	updateChart();

		    
})
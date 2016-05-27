angular.module('ourbudget.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout, $http) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

})


.controller('BudgetsCtrl', function($scope, $ionicModal, $http){

	$scope.budget = {}

	$ionicModal.fromTemplateUrl('new-budget.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modal = modal;
	});

  	$http.get('http://192.168.0.3:8080/ourbudget/all')
  		.success(function(result){
  			$scope.budgets = result;
	 })

	 $scope.newBudget = function(budget) {
		 $http.post('http://192.168.0.3:8080/ourbudget/new', budget)
			.success(function(result) {
				$scope.budgets.push(result)
				$scope.modal.hide()
				$scope.budget = {}
		})
	 }
})



.controller('BudgetCtrl', function($scope, $stateParams) {
	$scope.id = $stateParams.id
});


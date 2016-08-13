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
		 $http.post('http://192.168.0.3:8080/ourbudget/', budget)
			.success(function(result){
				$scope.budgets.push(result)
				$scope.modal.hide()
				$scope.budget = {}
		})
	 }
})




.controller('BudgetCtrl', function($scope, $ionicModal, $stateParams, $http) {


	$ionicModal.fromTemplateUrl('new-revenue.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modalRevenue = modal;
	});


	$ionicModal.fromTemplateUrl('new-expenditure.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modalExpenditure = modal;
	});



	$http.get('http://192.168.0.3:8080/ourbudget/'+$stateParams.id)
		.success(function(result){
		 $scope.budget = result
	})



	$scope.newRevenue = function(revenue) {
		 $http.put('http://192.168.0.3:8080/ourbudget/revenue/'+$stateParams.id, revenue)
			.success(function(result) {
			   $scope.budget = result
			   $scope.modalRevenue.hide()
		})
	}


	$scope.newExpenditure = function(expenditure) {
		 $http.put('http://192.168.0.3:8080/ourbudget/expenditure/'+$stateParams.id, expenditure)
			.success(function(result) {
			   $scope.budget = result
			   $scope.modalExpenditure.hide()
		})
	}

});


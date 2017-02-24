angular.module('ourbudget.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout, $http) {})


.controller('BudgetsCtrl', function($scope, $ionicModal, $ionicLoading, $http){

	$scope.budget = {
			name: '',
			users: ['581b5368e4700fab384fc1c3']
		}

	$ionicModal.fromTemplateUrl('new-budget.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modal = modal;
	});

	$ionicLoading.show()


  	$http.get('http://localhost:8080/ourbudget/budgets/user/581b5368e4700fab384fc1c3')
  		.success(function(result){
  			$scope.budgets = result;
  			$ionicLoading.hide()
	 })

	 $scope.newBudget = function(budget) {
		 $http.post('http://localhost:8080/ourbudget/', budget)
			.success(function(result){
				$scope.budgets.push(result)
				$scope.modal.hide()
					$scope.budget = {
						name: '',
						users: ['581b5368e4700fab384fc1c3']
					}
		})
	 }
})




.controller('BudgetCtrl', function($scope, $ionicModal, $ionicLoading, $stateParams, $http) {




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


	$ionicLoading.show()

	$http.get('http://localhost:8080/ourbudget/'+$stateParams.id)
		.success(function(result){
		 $scope.budget = result
		 $ionicLoading.hide()
	})



	$scope.saveRevenue = function(revenue) {
		 $ionicLoading.show()
		 $http.put('http://localhost:8080/ourbudget/revenue/'+$stateParams.id, revenue)
			.success(function(result) {
			   $scope.budget = result
			   $ionicLoading.hide()
			   $scope.modalRevenue.hide()
		})
	}


	$scope.saveExpenditure = function(expenditure) {

		   expenditure.tags =  expenditure.tags.match(/#\w+/g)

			$ionicLoading.show()
			 $http.put('http://localhost:8080/ourbudget/expenditure/'+$stateParams.id, expenditure)
				.success(function(result) {
				   $scope.budget = result
				   $ionicLoading.hide()
				   $scope.modalExpenditure.hide()
			})
	}

});


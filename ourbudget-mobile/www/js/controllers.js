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


  	$http.get('http://127.0.0.1:8080/ourbudget/api/v1/budgets')
  		.success(function(result){
  			$scope.budgets = result;
  			$ionicLoading.hide()
	 })

	 $scope.newBudget = function(budget) {
		
		var valid = $('#form-budget').parsley().validate()
				
		if(valid){
			$http.post('http://127.0.0.1:8080/ourbudget/api/v1/budgets', budget)
			.success(function(result){
				$scope.budgets.push(result)
				$scope.modal.hide()
					$scope.budget = {
						name: '',
						users: ['581b5368e4700fab384fc1c3']
					}
			})
		}		
		 
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

	
	$scope.$on('$destroy', function() {
	    $scope.modalExpenditure.remove();
	    $scope.modalRevenue.remove();
	});

	
	$ionicLoading.show()

	$http.get('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id)
		.success(function(result){
		 $scope.budget = result
		 $ionicLoading.hide()
	})



	$scope.saveRevenue = function(revenue) {
				
		var valid = $('#form-revenue').parsley().validate()
		
		if(valid){
			$ionicLoading.show()
			$http.post('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/revenues', revenue)
			.success(function(result) {
				$scope.budget = result
				$ionicLoading.hide()
				$scope.modalRevenue.hide()
			})			
		}
	}

	$scope.saveExpenditure = function(expenditure) {
		
			var valid = $('#form-expenditure').parsley().validate()
			
			if(valid){				
				$ionicLoading.show()
				$http.post('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+ '/expenditures', expenditure)
				.success(function(result) {
					$scope.budget = result
					$ionicLoading.hide()
					$scope.modalExpenditure.hide()
				})
			}
	}
	
	
	
});


var app = angular.module('ourbudget.controllers', [])

app.controller('AppCtrl', function($scope, $ionicModal, $timeout, $http) {})


app.controller('BudgetsCtrl', function($scope, $ionicModal, $ionicLoading, $http){

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


app.controller('BudgetCtrl', function($scope, $ionicModal, $ionicLoading, $stateParams, $http) {

	$ionicModal.fromTemplateUrl('revenue.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modalRevenue = modal;
	});


	$ionicModal.fromTemplateUrl('expenditure.html', {
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
	
	
	$scope.getBudget = function getBudget(){		
		$http.get('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id)
		.success(function(result){
			$scope.budget = result
			$ionicLoading.hide()
			$scope.modalRevenue.hide()
			$scope.modalExpenditure.hide()
		})
	}
	
	$scope.getBudget()
	

	
  // REVENUES	

	$scope.saveRevenue = function(revenue) {
				
		var valid = $('#form-revenue').parsley().validate()
		
		if(valid){
			$ionicLoading.show()			
			if(revenue.index === undefined){				
				$http.post('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/revenues', revenue)
				.success(function(result) {
					successRevenue(result)
				})
			}else{				
				$http.put('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/revenues', revenue)
				.success(function(result) {
					successRevenue(result)
				})
			}
		}
	}
	
	$scope.removeRevenue = function(revenue) {
		$http.delete('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/revenues/'+revenue.index)
		.success(function(result) {
			$scope.budget = result
			$ionicLoading.hide()
			$scope.modalRevenue.hide()
		})	
	}
	
	$scope.newRevenue = function() {
		$scope.revenue = {}
		$scope.modalRevenue.show()
	}
	
	$scope.editRevenue = function(revenue) {
		$scope.revenue = revenue
		$scope.modalRevenue.show()
	}
	
	function successRevenue(result){
		$scope.budget = result
		$ionicLoading.hide()
		$scope.modalRevenue.hide()
		$scope.revenue = {}
	}
	
	
	// EXPENDITURES	
	$scope.saveExpenditure = function(expenditure) {
		
			var valid = $('#form-expenditure').parsley().validate()
			
			if(valid){
				$ionicLoading.show()
				if(expenditure.index === undefined){
					$http.post('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+ '/expenditures', expenditure)
					.success(function(result) {
						successExpenditure(result)
					})
					
				}else{
					$http.put('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/expenditures', expenditure)
					.success(function(result) {
						successExpenditure(result)
					})
				}	
			}
	}
	
	
	$scope.removeExpenditure = function(revenue) {
		$http.delete('http://127.0.0.1:8080/ourbudget/api/v1/budgets/'+$stateParams.id+'/expenditures/'+revenue.index)
		.success(function(result) {
			$scope.budget = result
			$ionicLoading.hide()
			$scope.modalExpenditure.hide()
		})
	}
	
	$scope.newExpenditure = function() {
		$scope.expenditure = {}
		$scope.modalExpenditure.show()
	}
	
	$scope.editExpenditure = function(expenditure) {
		$scope.expenditure = expenditure
		$scope.modalExpenditure.show()
	}
	
	function successExpenditure(result){
		$scope.budget = result
		$ionicLoading.hide()
		$scope.modalExpenditure.hide()
		$scope.expenditure = {}
	}
	
});


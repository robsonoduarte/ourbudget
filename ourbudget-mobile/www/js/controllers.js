angular.module('ourbudget.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout, $http, $state) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  // Form data for the login modal
  $scope.budget = {};

  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/new.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeNew = function() {
	  $scope.modal.hide();
//	  $state.go('app.budgets', {}, {reload: true})
  };

  // Open the login modal
  $scope.openNew = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doNew = function() {
    $http.post('http://192.168.0.3:8080/ourbudget/new', $scope.budget)
	.success(function(result) {
		$scope.budget = {};
		$scope.closeNew();
	})
	.error(function(data, status) {
		console.log(status);
	})
  };
})


.controller('BudgetsCtrl', function($scope,$http) {

	$scope.budgets = []

  	$http.get('http://192.168.0.3:8080/ourbudget/all')
	 .success(function(result) {
		 $scope.budgets = result;
	 })
	 .error(function(data, status) {
	 	console.log(data)
	 })
})



.controller('PlaylistCtrl', function($scope, $stateParams) {
	console.log($stateParams.id)
});

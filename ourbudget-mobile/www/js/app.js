// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('ourbudget', ['ionic', 'ourbudget.controllers'])
.run(function($ionicPlatform,$ionicPopup) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }

     var notificationOpenedCallback = function(data) {
    	  var x = data
    	  var y = data.additionalData
    	  $ionicPopup.show({
 	         title: x.message,
 	         subTitle: y.name,
 	        buttons: [{ text: 'OK', type: 'button-positive' }]
 	     });
     };



      window.plugins.OneSignal.init("",
                                     {googleProjectNumber: ""},
                                     notificationOpenedCallback);

      // Show an alert box if a notification comes in when the user is in your app.
      window.plugins.OneSignal.enableInAppAlertNotification(false);

  });
})

.config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {

  $stateProvider
    .state('app', {
    	url: '/app',
    	abstract: true,
    	templateUrl: 'templates/menu.html',
    	controller: 'AppCtrl'
  })

  .state('app.budgets', {
      url: '/budgets',
      views: {
        'menuContent': {
          templateUrl: 'templates/budgets.html',
          controller: 'BudgetsCtrl'
        }
      }
    })

  .state('app.budget', {
    url: '/budget/:id',
    views: {
      'menuContent': {
        templateUrl: 'templates/budget.html',
        controller: 'BudgetCtrl'
      }
    }
  });

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/app/budgets');
});

var app = angular.module('crudApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: 'http://localhost:8080/sysempresa-web',
    USER_SERVICE_API : 'http://localhost:8080/sysempresa-web/api/usuario/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/lista',
                controller:'UsuarioController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UsuarioService) {
                        console.log('Carregador todos usuários');
                        var deferred = $q.defer();
                        UsuarioService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);
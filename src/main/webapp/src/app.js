var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") return Reflect.decorate(decorators, target, key, desc);
    switch (arguments.length) {
        case 2: return decorators.reduceRight(function(o, d) { return (d && d(o)) || o; }, target);
        case 3: return decorators.reduceRight(function(o, d) { return (d && d(target, key)), void 0; }, void 0);
        case 4: return decorators.reduceRight(function(o, d) { return (d && d(target, key, o)) || o; }, desc);
    }
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
var angular2_1 = require('angular2/angular2');
var router_1 = require('angular2/router');
var home_1 = require('./components/home');
var login_1 = require('./components/login');
var signup_1 = require('./components/signup');
var questionset_1 = require('./components/questionset');
var AppComponent = (function () {
    function AppComponent(router) {
        this.router = router;
        this.myName = "Alice";
        this.names = ["Aarav", "Martin", "Shannon", "Ariana", "Kai"];
    }
    AppComponent = __decorate([
        angular2_1.Component({
            selector: 'my-app'
        }),
        angular2_1.View({
            directives: [angular2_1.NgIf, router_1.ROUTER_DIRECTIVES],
            template: "\n\t    <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n\t\t    <div class=\"container\">\n\t\t\t    <div class=\"navbar-header\">\n\t\t\t      \t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n\t\t\t        \t<span class=\"sr-only\">Toggle Navigation</span>\n\t\t\t\t        <span class=\"icon-bar\"></span>\n\t\t\t\t        <span class=\"icon-bar\"></span>\n\t\t\t\t        <span class=\"icon-bar\"></span>\n\t\t\t      \t</button>\n\t\t\t      \t<a class=\"navbar-brand\" [router-link]=\"['./Home']\" onclick=\"javascript:$('.collapse').collapse('hide')\">\n\t\t\t\t\t\t<i class=\"fa fa-home\"></i>\n\t\t\t        \t<span>Advisory Panel</span>\n\t\t\t\t\t</a>\n\t\t\t    </div>\n\t\t\t\n\t\t\t    <div class=\"collapse navbar-collapse\" style=\"overflow:hidden\" id=\"bs-example-navbar-collapse-1\">\n\t\t\t      \t<ul class=\"nav navbar-nav\">\n\t\t\t\t        <li>\n\t\t\t              \t<a class=\"navbar-brand\" [router-link]=\"['./QuestionSet']\" onclick=\"javascript:$('.collapse').collapse('hide')\">Portfolio</a>\n\t\t\t\t        </li>\n\t\t\t      \t</ul>\n\t\t\t      \t<ul class=\"nav navbar-nav navbar-right\">\n\t\t\t      \t\t<li>\n\t\t\t      \t\t\t<a class=\"navbar-brand\" [router-link]=\"['./Signup']\" onclick=\"javascript:$('.collapse').collapse('hide')\">Signup</a>\n\t\t\t      \t\t</li>\n\t\t\t      \t</ul>\n\t\t\t      \t<ul class=\"nav navbar-nav navbar-right\">\n\t\t\t      \t\t<li>\n\t\t\t      \t\t\t<a class=\"navbar-brand\" [router-link]=\"['./Login']\" onclick=\"javascript:$('.collapse').collapse('hide')\">Login</a>\n\t\t\t      \t\t</li>\n\t\t\t      \t</ul>\n\t\t\t      \t<ul class=\"nav navbar-nav navbar-right\">\n        \t\t\t\t<li class=\"loader\" *ng-if=\"router.navigating\">\n          \t\t\t\t\t<i class=\"fa fa-spinner fa-spin fa-2x\"></i>\n        \t\t\t\t</li>\n      \t\t\t\t</ul>\n\t\t\t    </div>\n\t\t\t</div>\n\t\t</nav>\n\t\t\n\t\t<div class=\"contianer\">\n\t      \t<router-outlet></router-outlet>\n\t\t</div>\n  \t"
        }),
        router_1.RouteConfig([
            { path: '/', component: home_1.HomeComponent, as: 'Home' },
            { path: '/login', component: login_1.LoginComponent, as: 'Login' },
            { path: '/signup', component: signup_1.SignupComponent, as: 'Signup' },
            { path: '/questionset', component: questionset_1.QuestionSetComponent, as: 'QuestionSet' }
        ]),
        __param(0, angular2_1.Inject(router_1.Router)), 
        __metadata('design:paramtypes', [(typeof (_a = typeof router_1.Router !== 'undefined' && router_1.Router) === 'function' && _a) || Object])
    ], AppComponent);
    return AppComponent;
    var _a;
})();
angular2_1.bootstrap(AppComponent, [
    router_1.routerBindings(AppComponent),
    router_1.ROUTER_BINDINGS,
    angular2_1.bind(router_1.LocationStrategy).toClass(router_1.HashLocationStrategy) /*,
    bind(APP_BASE_HREF).toValue(location.pathname)*/
]);
//# sourceMappingURL=app.js.map
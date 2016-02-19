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
var angular2_1 = require('angular2/angular2');
var LoginComponent = (function () {
    function LoginComponent() {
    }
    LoginComponent = __decorate([
        angular2_1.Component({
            selector: 'login'
        }),
        angular2_1.View({
            template: "\n\t\t<div class=\"container text-center\">\n\t\t\t<h2>Login to Your Account</h2>\n\t\t\t<br>\n\t\t\t<div class=\"row\"> \n\t\t\t\t<div class=\"col-md-4 col-xs-12\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-md-4 col-xs-12\">\n\t\t\t\t\t<form>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"Email or Username\" />\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" placeholder=\"Password\" />\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<a class=\"btn btn-primary\" style=\"width:100%\" data-toggle=\"modal\" data-target=\"#myModal\">\n\t\t\t\t\t\t\t\tLogin\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<a class=\"btn btn-block btn-social btn-google\" style=\"width:100%\" data-toggle=\"modal\" data-target=\"#myModal\">\n\t\t\t\t\t\t\t\t<i class=\"fa fa-google\"></i> Sign in with Google\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<a class=\"btn btn-block btn-social btn-facebook\" style=\"width:100%\" data-toggle=\"modal\" data-target=\"#myModal\">\n\t\t\t\t\t\t\t\t<i class=\"fa fa-facebook\"></i> Sign in with Facebook\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"form-group\">\n\t\t\t\t\t\t\t<a class=\"btn btn-block btn-social btn-linkedin\" style=\"width:100%\" data-toggle=\"modal\" data-target=\"#myModal\">\n\t\t\t\t\t\t\t\t<i class=\"fa fa-linkedin\"></i> Sign in with Linkedin\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</form>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-md-4 col-xs-12\">\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t<!-- Modal -->\n\t\t\t<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n  \t\t\t\t<div class=\"modal-dialog modal-sm\">\n\n\t    \t\t\t<!-- Modal content-->\n\t    \t\t\t<div class=\"modal-content\">\n\t\t\t\t\t\t<div class=\"modal-body text-center\">\n\t        \t\t\t\t<p>\n\t        \t\t\t\t\tWe are working on this feature. <br/>\n\t        \t\t\t\t\tThanks for your support.\n\t        \t\t\t\t</p>\n\t      \t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"modal-footer\">\n\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Close</button>\n\t      \t\t\t\t</div>\n\t    \t\t\t</div>\n\n  \t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t"
        }), 
        __metadata('design:paramtypes', [])
    ], LoginComponent);
    return LoginComponent;
})();
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.js.map
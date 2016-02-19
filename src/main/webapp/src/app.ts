import {Component, View, Inject, bootstrap, bind, NgIf} from 'angular2/angular2';
import {Router, RouteConfig, routerBindings, APP_BASE_HREF, ROUTER_DIRECTIVES, ROUTER_BINDINGS, ROUTER_PRIMARY_COMPONENT, LocationStrategy, HashLocationStrategy} from 'angular2/router';
import {HomeComponent} from './components/home';
import {LoginComponent} from './components/login';
import {SignupComponent} from './components/signup';
import {QuestionSetComponent} from './components/questionset';


@Component({
  	selector: 'my-app'
})
@View({
	directives: [NgIf, ROUTER_DIRECTIVES],
  	template: `
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		    <div class="container">
			    <div class="navbar-header">
			      	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        	<span class="sr-only">Toggle Navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
			      	</button>
			      	<a class="navbar-brand" [router-link]="['./Home']" onclick="javascript:$('.collapse').collapse('hide')">
						<i class="fa fa-home"></i>
			        	<span>Advisory Panel</span>
					</a>
			    </div>
			
			    <div class="collapse navbar-collapse" style="overflow:hidden" id="bs-example-navbar-collapse-1">
			      	<ul class="nav navbar-nav">
				        <li>
			              	<a class="navbar-brand" [router-link]="['./QuestionSet']" onclick="javascript:$('.collapse').collapse('hide')">Portfolio</a>
				        </li>
			      	</ul>
			      	<ul class="nav navbar-nav navbar-right">
			      		<li>
			      			<a class="navbar-brand" [router-link]="['./Signup']" onclick="javascript:$('.collapse').collapse('hide')">Signup</a>
			      		</li>
			      	</ul>
			      	<ul class="nav navbar-nav navbar-right">
			      		<li>
			      			<a class="navbar-brand" [router-link]="['./Login']" onclick="javascript:$('.collapse').collapse('hide')">Login</a>
			      		</li>
			      	</ul>
			      	<ul class="nav navbar-nav navbar-right">
        				<li class="loader" *ng-if="router.navigating">
          					<i class="fa fa-spinner fa-spin fa-2x"></i>
        				</li>
      				</ul>
			    </div>
			</div>
		</nav>
		
		<div class="contianer">
	      	<router-outlet></router-outlet>
		</div>
  	`
})
@RouteConfig([
	{ path: '/', component: HomeComponent, as: 'Home'},
	{ path: '/login', component: LoginComponent, as: 'Login'},
	{ path: '/signup', component: SignupComponent, as: 'Signup'},
	{ path: '/questionset', component: QuestionSetComponent, as: 'QuestionSet'}
])
class AppComponent {
	myName: string;
	names: Array<string>;
	router: Router;
	
  	constructor(@Inject(Router) router:Router) {
  		this.router = router;
    	this.myName = "Alice";
    	this.names = ["Aarav", "Martin", "Shannon", "Ariana", "Kai"];
  	}
}

bootstrap(AppComponent, [
	routerBindings(AppComponent),
	ROUTER_BINDINGS,
	bind(LocationStrategy).toClass(HashLocationStrategy)/*,
	bind(APP_BASE_HREF).toValue(location.pathname)*/
]);
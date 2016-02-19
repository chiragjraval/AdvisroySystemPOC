import {Component, View} from 'angular2/angular2';

@Component({
  	selector: 'login'
})
@View({
	template: `
		<div class="container text-center">
			<h2>Login to Your Account</h2>
			<br>
			<div class="row"> 
				<div class="col-md-4 col-xs-12">
				</div>
				<div class="col-md-4 col-xs-12">
					<form>
						<div class="form-group">
							<input class="form-control" placeholder="Email or Username" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password" />
						</div>
						<div class="form-group">
							<a class="btn btn-primary" style="width:100%" data-toggle="modal" data-target="#myModal">
								Login
							</a>
						</div>
						<div class="form-group">
							<a class="btn btn-block btn-social btn-google" style="width:100%" data-toggle="modal" data-target="#myModal">
								<i class="fa fa-google"></i> Sign in with Google
							</a>
						</div>
						<div class="form-group">
							<a class="btn btn-block btn-social btn-facebook" style="width:100%" data-toggle="modal" data-target="#myModal">
								<i class="fa fa-facebook"></i> Sign in with Facebook
							</a>
						</div>
						<div class="form-group">
							<a class="btn btn-block btn-social btn-linkedin" style="width:100%" data-toggle="modal" data-target="#myModal">
								<i class="fa fa-linkedin"></i> Sign in with Linkedin
							</a>
						</div>
					</form>
				</div>
				<div class="col-md-4 col-xs-12">
				</div>
			</div>
			
			<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
  				<div class="modal-dialog modal-sm">

	    			<!-- Modal content-->
	    			<div class="modal-content">
						<div class="modal-body text-center">
	        				<p>
	        					We are working on this feature. <br/>
	        					Thanks for your support.
	        				</p>
	      				</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	      				</div>
	    			</div>

  				</div>
			</div>
		</div>
	`
})
export class LoginComponent {
	
	constructor() {

  	}
}
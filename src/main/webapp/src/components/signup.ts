import {Component, View} from 'angular2/angular2';

@Component({
  	selector: 'signup'
})
@View({
	template: `
		<div class="container text-center">
			<h2>Create a New Account</h2>
			<br>
			<div class="row"> 
				<div class="col-md-4 col-xs-12">
				</div>
				<div class="col-md-4 col-xs-12">
					<form>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email" />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Firstname" />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Lastname" />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Username" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Confirm Password" />
						</div>
					</form>
					<button type="submit" class="btn btn-primary" style="width:100%" data-toggle="modal" data-target="#myModal">
						Signup
					</button>
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
							<button type="button"  class="btn btn-primary" data-dismiss="modal">Close</button>
	      				</div>
	    			</div>

  				</div>
			</div>
		</div>
	`
})
export class SignupComponent {
	
	constructor() {

  	}
}
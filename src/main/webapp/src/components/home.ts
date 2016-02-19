import {Component, View} from 'angular2/angular2';

@Component({
  selector: 'home'
})
@View({
	template: `
		<header class="business-header">
		    <div class="container">
		        <div class="row">
		            <div class="col-lg-12">
		                <h1 class="tagline">Advisory Panel - Systematic Investment Plans</h1>
		            </div>
		        </div>
		    </div>
		</header>
		
		<div class="container">
		
		    <hr>
		
		    <div class="row">
		        <div class="col-sm-8">
		            <h2>What We Do</h2>
		            <p>We go through your Risk taking abilities and based on your Risk Ratig score, we come up with a personalised System Investment Plan with Low Risk and High Returns.</p>
		            <p>We also provide detailed information on your Risk rating so that you can focus on areas where you can systematically improve Risk taking ability and get better Returns.</p>
		            <p>
		                <a class="btn btn-default btn-lg" href="#">Call to Action &raquo;</a>
		            </p>
		        </div>
		        <div class="col-sm-4">
		            <h2>Contact Us</h2>
		            <address>
		                <strong>Advisory Sytem POC</strong>
		                <br>Sarajapur Main Road
		                <br>Bangalore - 560035
		                <br>
		            </address>
		            
		            <address>
		            	<abbr title="Phone">P:</abbr> (+91) 9619171692 <br/>
		            	<abbr title="Phone">P:</abbr> (+91) 9004576959 <br/>
		                <abbr title="Email">E:</abbr> <a href="mailto:sumeet9t9@gmail.com">sumeet9t9@gmail.com</a> <br/>
		                <abbr title="Email">E:</abbr> <a href="mailto:raval.chirag26@gmail.com">raval.chirag26@gmail.com</a> <br/>
		            </address>
		        </div>
		    </div>
		    
		    <hr>
		
		    <div class="row">
		        <div class="col-sm-4">
		            <img class="img-rounded img-responsive img-center" style="height:250px" src="http://t0.gstatic.com/images?q=tbn:ANd9GcS3dVtdOogO9dhbXtHr-KbBUzlfZrf_wNDstvQuouK4rdc_8QJX2Q" alt="">
		            <h2>Helping create SIP</h2>
		            <p>We help you analyse your Risk taking ability and generate a Systematic Investment Plans</p>
		        </div>
		        <div class="col-sm-4">
		            <img class="img-rounded img-responsive img-center" style="height:250px" src="http://t2.gstatic.com/images?q=tbn:ANd9GcRqfh2JusREHRSRGIyX9Pkc2ajrtWFHNoQiudThYTmOdJUvDiFT" alt="">
		            <h2>Active Market Analysis</h2>
		            <p>We provide you with active market analysis to help you generate SIPs with Low Risk and High Returns</p>
		        </div>
		        <div class="col-sm-4">
		            <img class="img-rounded img-responsive img-center" style="height:250px" src="http://www.investmentu.com/assets/images/content/2008/10/AssetAllocation.gif" alt="">
		            <h2>Managing Portfolio</h2>
		            <p>We help you in investing your money as per your SIP with minimal charges</p>
		        </div>
		    </div>
		    
		    <hr>
		
		    <footer>
		        <div class="row">
		            <div class="col-lg-12">
		                <p>Copyright &copy; Your Website 2015</p>
		            </div>
		        </div>
		    </footer>
		
		</div>
	`
})
export class HomeComponent {
	constructor() {
    	
  	}
}
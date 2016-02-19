import {Component, View, NgIf, NgFor} from 'angular2/angular2';
import {Http, HTTP_BINDINGS} from 'angular2/http';
import {APP_BASE_HREF, Router} from 'angular2/router';
import {QuestionChartComponent} from './questionchart';

@Component({
  	selector: 'questionset',
  	viewBindings: [HTTP_BINDINGS]
})
@View({
	directives: [QuestionChartComponent, NgIf, NgFor],
  	template: `
  	
		<div class="modal fade" style="margin-top:50%" role="dialog">
 			<div class="modal-dialog">
    			<div class="modal-content">
					<div class="modal-body text-center">
	        			<p>
	        					Please answers questions to generate Portflio. <br/>
	        					Thanks for your support.
	        			</p>
	      			</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	      			</div>
    			</div>
 			</div>
		</div>
  		
		<section *ng-if="currentQuestion != undefined && currentQuestion != null && !answerSubmitted">
			
			<div id="wrapper">
			
				<!-- Sidebar -->
		        <div id="sidebar-wrapper">
		            <ul class="sidebar-nav" >
		                <li *ng-for="#question of questions" class="{{question.questionSequence-1==currentQuestionIndex ? ' active' : ''}}">
		                    <a (click)="moveToQuestion(question.questionSequence)">Question {{question.questionSequence}}</a>
		                </li>
		            </ul>
		        </div>
		        <!-- /#sidebar-wrapper -->
				
				<div id="page-content-wrapper">
					<div class='container-fluid'>
						<div class='row'>
							<div class='col-xs-12 text-center'>
				    			<button id='submitBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex+1<questions.length ? "disabled" : ""}}' (click)='submitAnswer()'>Submit</button>
				    		</div>
						</div>
						<div class='row'>
		            	<div class='col-xs-6 text-center'>
		            		<button id='prevBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex==0 ? "disabled" : ""}}' (click)='prevQuestion()'>Prev</button>
		            	</div>
		            	<div class='col-xs-6 text-center'>
		            		<button id='nextBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex+1==questions.length ? "disabled" : ""}}' (click)='nextQuestion()'>Next</button>
		            	</div>
		            </div>
					<div class='container-fluid'>
						<div class='row'>
							<div class='col-lg-12 text-left'>
								<h2>Question {{currentQuestion.questionSequence}} </h2>
							</div>
							<div class='col-lg-12 text-left'>
								<h2><small>{{currentQuestion.questionTemplate}}</small></h2>
							</div>
							<div class='col-lg-12 text-left' *ng-for="#chart of currentQuestion.questionCharts">
								<question-chart [chart-id]='chart.chartId' [chart-config]='chart.chartConfig' />
							</div>
							<div class='col-lg-12 text-left'>
								<ul class='list-unstyled' *ng-for="#option of currentQuestion.questionOptions">
									<li><input name='{{option.questionId}}' type='radio' />&nbsp;&nbsp; {{option.optionText}} </li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<section class="container {{!answerSubmitted ? ' hidden' : ''}}">
			<br/>
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-12 text-center">
					    <span style="height:60px; vertical-align:middle; display:inline-block">
				    		<h2 style="margin-top:0px">Your Rating is : {{riskRatingScore}}</h2>
				    	</span>
				    	<span style="width:30px; height:60px; display: inline-block;">
			    			<button class="btn btn-primary" style="width:30px; height:30px" (click)="incrRiskRating()"
			    				disabled='{{riskRatingScore==100 ? "disabled" : ""}}'>
			    				+
			    			</button>
			    			<button class="btn btn-primary" style="width:30px; height:30px" (click)="decrRiskRating()"
			    				disabled='{{riskRatingScore==1 ? "disabled" : ""}}'>
			    				-
			    			</button>
				    	</span>
					</div>
					<br/>
					<div class="col-xs-12">
						<question-chart chart-id="portfolioPieChart" [chart-config]="portfolioChartConfig" />
					</div>
				</div>
			</div>
		</section>
  	`
})
export class QuestionSetComponent {
	router: Router;
	currentQuestionIndex: number;
	currentQuestion: Object;
	questions: Array<Object> = [];
	answerSubmitted: boolean = false;
	riskRatingScore: number;
	portfolioChartConfig: string = "";
	
	constructor(http:Http, router:Router) {
		var compContext = this;
		this.currentQuestionIndex = 0;
		this.router = router;
		
    	http.get('/AdvisorySystemPOC/rest/service/questionsets')
      		.map(res => res.json())
      		.subscribe(data => {
      			compContext.questions = data.questionSets[0].questions;
      			compContext.currentQuestion = compContext.questions[compContext.currentQuestionIndex]; 
      		});
  	}
  	
  	prevQuestion() {
  		this.currentQuestionIndex--;
  		this.currentQuestion = this.questions[this.currentQuestionIndex];
  	}
  	
  	nextQuestion() {
  		this.currentQuestionIndex++;
  		this.currentQuestion = this.questions[this.currentQuestionIndex];
  	}
  	
  	moveToQuestion(questionSequence) {
  		this.currentQuestionIndex = parseInt(questionSequence) - 1;
  		this.currentQuestion = this.questions[this.currentQuestionIndex]; 
  	}
  	
  	genrateRandomNumberBetween(min: number, max: number) {
		return Math.floor((Math.random() * max) + min);
	}
  	
  	generateRandomPortfolioData() {
		var data = [];
		var total = 0;
		var obj = null;
		
		obj =  { name: "Banking", y:  this.genrateRandomNumberBetween(1,100) };
		total += obj.y; data.push(obj);
		
		obj =  { name: "Pharma", y:  this.genrateRandomNumberBetween(1,100-total) };
		total += obj.y; data.push(obj);
		
		obj =  { name: "FMCG", y:  this.genrateRandomNumberBetween(1,100-total) };
		total += obj.y; data.push(obj);
		
		obj =  { name: "Infra", y: this.genrateRandomNumberBetween(1,100-total) };
		total += obj.y; data.push(obj);
		
		obj =  { name: "Forex", y: 100-total };
		total += obj.y; data.push(obj);
		
		return data;
	}
	
	renderRandomPortfolio() {
		var chartData = this.generateRandomPortfolioData();
		this.portfolioChartConfig = JSON.stringify({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            type: 'pie'
	        },
	        title: {
	            text: 'Portfolio Distribution'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: false
	                },
	                showInLegend: true
	            }
	        },
	        series: [{
	            name: "Sectors",
	            colorByPoint: true,
	            data: chartData
	        }]
		});
	}
	
	submitAnswer() {
  		this.answerSubmitted = true;
  		this.riskRatingScore = this.genrateRandomNumberBetween(1, 100);
  		this.renderRandomPortfolio();
  	}
	
	incrRiskRating() {
		this.riskRatingScore++;
		this.renderRandomPortfolio();
	}
	
	decrRiskRating() {
		this.riskRatingScore--;
		this.renderRandomPortfolio();
	}
}
var questionSets = null;
var questions = null;
var currentQuestionIndex = 0;


function genrateRandomNumberBetween(min, max) {
	return Math.floor((Math.random() * max) + min);
}


function generateRandomPortfolioData() {
	var data = [];
	var total = 0;
	var obj = null;
	
	obj =  { name: "Banking", y: genrateRandomNumberBetween(1,100) };
	total += obj.y; data.push(obj);
	
	obj =  { name: "Pharma", y: genrateRandomNumberBetween(1,100-total) };
	total += obj.y; data.push(obj);
	
	obj =  { name: "FMCG", y: genrateRandomNumberBetween(1,100-total) };
	total += obj.y; data.push(obj);
	
	obj =  { name: "Infra", y: genrateRandomNumberBetween(1,100-total) };
	total += obj.y; data.push(obj);
	
	obj =  { name: "Forex", y: 100-total };
	total += obj.y; data.push(obj);
	
	return data;
}

function renderQuestionAtIndex(questions, index) {
	var innerHtml = '';
	var question = questions[index];
	var charts = [];
	
	innerHtml += "<section>"
		+ "<div class='container'>"
			+ "<div class='row'>"
		    	+ "<div class='col-xs-12 text-center'>"
		    		+ "<button id='submitBtn' type='button' class='btn btn-primary' onclick='javascript:return submitAnswer(this)'>Submit</button>"
		    	+ "</div>"
		    + "</div>"
			+ "<div class='row'>"
            	+ "<div class='col-xs-6 text-center'>"
            		+ "<button id='prevBtn' type='button' class='btn btn-primary' onclick='javascript:return prevQuestion(this)'>Prev</button>"
            	+ "</div>"
            	+ "<div class='col-xs-6 text-center'>"
            		+ "<button id='nextBtn' type='button' class='btn btn-primary' onclick='javascript:return nextQuestion(this)'>Next</button>"
            	+ "</div>"
            + "</div>"
        + "</div>"
        + "<div class='container'>"
			+ "<div class='row'>"
				+ "<div class='col-lg-12 text-left'>"
					+ "<h2>Question " + question.questionSequence + "</h2>"
				+ "</div>"
				+ "<div class='col-lg-12 text-left'>"
					+ "<h2><small>" + question.questionTemplate + "</small></h2>"
				+ "</div>"
				+ "<div class='col-lg-12 text-left'>";

	question.questionCharts.forEach(function(chart) {
		innerHtml += "<div id='" + chart.chartElementId + "' />"
		charts.push(chart);
	});

	innerHtml = innerHtml	+ "</div>"						
				+ "<div class='col-lg-12 text-left'>"
					+ "<ul class='list-unstyled'>";

	question.questionOptions.forEach(function(option) {
		innerHtml += "<li><input name='"+ question.questionId +"' type='radio' />&nbsp;&nbsp;" + option.optionText + "</li>"
	});
	
	innerHtml = innerHtml 		+ "</ul>"
				+ "</div>"
			+ "</div>"
		+ "</div>"
	+ "</section>";
	
	$('#questionSectionContainer').html(innerHtml);
	
	charts.forEach(function(chart) {
		$('#'+chart.chartElementId).highcharts(JSON.parse(chart.chartConfig));
	});
	
	if(index == 0) {
		$('#prevBtn').attr('disabled', 'disabled');
		$('#submitBtn').attr('disabled', 'disabled');
	}
	else if(index == questions.length - 1) {
		$('#nextBtn').attr('disabled', 'disabled');
		$('#submitBtn').removeAttr('disabled');
	}
	else {
		$('#prevBtn').removeAttr('disabled');
		$('#nextBtn').removeAttr('disabled');
		$('#submitBtn').attr('disabled', 'disabled');
	}
}

function renderRiskRatingSpinner(riskRatingVal) {
	$('#riskRatingLable').html(riskRatingVal);
	
	if(riskRatingVal==1)
		$('#decrRatingBtn').attr('disabled', 'disabled');
	else if(riskRatingVal==100)
		$('#incrRatingBtn').attr('disabled', 'disabled');
	else {
		$('#decrRatingBtn').removeAttr('disabled');
		$('#incrRatingBtn').removeAttr('disabled');
	}
}

function renderRandomPortfolio() {
	var chartData = generateRandomPortfolioData();
	$('#portfolioPieChartContainer').highcharts({
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


function prevQuestion(btn) {
	currentQuestionIndex--;
	renderQuestionAtIndex(questions, currentQuestionIndex);
}

function nextQuestion(btn) {
	currentQuestionIndex++;
	renderQuestionAtIndex(questions, currentQuestionIndex);
}

function submitAnswer(btn) {
	$('#questionSectionContainer').html('');
	$('#portfolioContainer').removeClass('hidden');
	renderRiskRatingSpinner(genrateRandomNumberBetween(1, 100));
	renderRandomPortfolio();
}

function decrRating(btn) {
	var riskRating = parseInt($('#riskRatingLable').html());
	renderRiskRatingSpinner(--riskRating);
	renderRandomPortfolio();
}

function incrRating(btn) {
	var riskRating = parseInt($('#riskRatingLable').html());
	renderRiskRatingSpinner(++riskRating);
	renderRandomPortfolio();
}

function goToHome() {
	currentQuestionIndex = 0;
	questions = questionSets[0].questions;
	renderQuestionAtIndex(questions, currentQuestionIndex);
	$('#portfolioContainer').addClass('hidden');
}

$.ajax({
	method: "GET",
	url: "rest/service/questionsets"
})
.done(function( msg ) {
	questionSets = msg.questionSets;
	/*questionSets.forEach(function(questionSet) {
		innerHtml += "<div class='col-sm-6 portfolio-item text-center'>"
                     	+	"<button type='button' class='btn btn-primary' questionSetId='" + questionSet.questionSetId + "' onclick='javascript:return questionSetClickHandler(this)'>" + questionSet.questionSetDescription + "</button>"
                     +	"</div>"
	});*/
	
	currentQuestionIndex = 0;
	questions = questionSets[0].questions;
	renderQuestionAtIndex(questions, currentQuestionIndex);
});
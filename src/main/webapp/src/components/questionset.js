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
var http_1 = require('angular2/http');
var router_1 = require('angular2/router');
var questionchart_1 = require('./questionchart');
var QuestionSetComponent = (function () {
    function QuestionSetComponent(http, router) {
        this.questions = [];
        this.answerSubmitted = false;
        this.portfolioChartConfig = "";
        var compContext = this;
        this.currentQuestionIndex = 0;
        this.router = router;
        http.get('/AdvisorySystemPOC/rest/service/questionsets')
            .map(function (res) { return res.json(); })
            .subscribe(function (data) {
            compContext.questions = data.questionSets[0].questions;
            compContext.currentQuestion = compContext.questions[compContext.currentQuestionIndex];
        });
    }
    QuestionSetComponent.prototype.prevQuestion = function () {
        this.currentQuestionIndex--;
        this.currentQuestion = this.questions[this.currentQuestionIndex];
    };
    QuestionSetComponent.prototype.nextQuestion = function () {
        this.currentQuestionIndex++;
        this.currentQuestion = this.questions[this.currentQuestionIndex];
    };
    QuestionSetComponent.prototype.moveToQuestion = function (questionSequence) {
        this.currentQuestionIndex = parseInt(questionSequence) - 1;
        this.currentQuestion = this.questions[this.currentQuestionIndex];
    };
    QuestionSetComponent.prototype.genrateRandomNumberBetween = function (min, max) {
        return Math.floor((Math.random() * max) + min);
    };
    QuestionSetComponent.prototype.generateRandomPortfolioData = function () {
        var data = [];
        var total = 0;
        var obj = null;
        obj = { name: "Banking", y: this.genrateRandomNumberBetween(1, 100) };
        total += obj.y;
        data.push(obj);
        obj = { name: "Pharma", y: this.genrateRandomNumberBetween(1, 100 - total) };
        total += obj.y;
        data.push(obj);
        obj = { name: "FMCG", y: this.genrateRandomNumberBetween(1, 100 - total) };
        total += obj.y;
        data.push(obj);
        obj = { name: "Infra", y: this.genrateRandomNumberBetween(1, 100 - total) };
        total += obj.y;
        data.push(obj);
        obj = { name: "Forex", y: 100 - total };
        total += obj.y;
        data.push(obj);
        return data;
    };
    QuestionSetComponent.prototype.renderRandomPortfolio = function () {
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
    };
    QuestionSetComponent.prototype.submitAnswer = function () {
        this.answerSubmitted = true;
        this.riskRatingScore = this.genrateRandomNumberBetween(1, 100);
        this.renderRandomPortfolio();
    };
    QuestionSetComponent.prototype.incrRiskRating = function () {
        this.riskRatingScore++;
        this.renderRandomPortfolio();
    };
    QuestionSetComponent.prototype.decrRiskRating = function () {
        this.riskRatingScore--;
        this.renderRandomPortfolio();
    };
    QuestionSetComponent = __decorate([
        angular2_1.Component({
            selector: 'questionset',
            viewBindings: [http_1.HTTP_BINDINGS]
        }),
        angular2_1.View({
            directives: [questionchart_1.QuestionChartComponent, angular2_1.NgIf, angular2_1.NgFor],
            template: "\n  \t\n\t\t<div class=\"modal fade\" style=\"margin-top:50%\" role=\"dialog\">\n \t\t\t<div class=\"modal-dialog\">\n    \t\t\t<div class=\"modal-content\">\n\t\t\t\t\t<div class=\"modal-body text-center\">\n\t        \t\t\t<p>\n\t        \t\t\t\t\tPlease answers questions to generate Portflio. <br/>\n\t        \t\t\t\t\tThanks for your support.\n\t        \t\t\t</p>\n\t      \t\t\t</div>\n\t\t\t\t\t<div class=\"modal-footer\">\n\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Close</button>\n\t      \t\t\t</div>\n    \t\t\t</div>\n \t\t\t</div>\n\t\t</div>\n  \t\t\n\t\t<section *ng-if=\"currentQuestion != undefined && currentQuestion != null && !answerSubmitted\">\n\t\t\t\n\t\t\t<div id=\"wrapper\">\n\t\t\t\n\t\t\t\t<!-- Sidebar -->\n\t\t        <div id=\"sidebar-wrapper\">\n\t\t            <ul class=\"sidebar-nav\" >\n\t\t                <li *ng-for=\"#question of questions\" class=\"{{question.questionSequence-1==currentQuestionIndex ? ' active' : ''}}\">\n\t\t                    <a (click)=\"moveToQuestion(question.questionSequence)\">Question {{question.questionSequence}}</a>\n\t\t                </li>\n\t\t            </ul>\n\t\t        </div>\n\t\t        <!-- /#sidebar-wrapper -->\n\t\t\t\t\n\t\t\t\t<div id=\"page-content-wrapper\">\n\t\t\t\t\t<div class='container-fluid'>\n\t\t\t\t\t\t<div class='row'>\n\t\t\t\t\t\t\t<div class='col-xs-12 text-center'>\n\t\t\t\t    \t\t\t<button id='submitBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex+1<questions.length ? \"disabled\" : \"\"}}' (click)='submitAnswer()'>Submit</button>\n\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class='row'>\n\t\t            \t<div class='col-xs-6 text-center'>\n\t\t            \t\t<button id='prevBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex==0 ? \"disabled\" : \"\"}}' (click)='prevQuestion()'>Prev</button>\n\t\t            \t</div>\n\t\t            \t<div class='col-xs-6 text-center'>\n\t\t            \t\t<button id='nextBtn' type='button' class='btn btn-primary' disabled='{{currentQuestionIndex+1==questions.length ? \"disabled\" : \"\"}}' (click)='nextQuestion()'>Next</button>\n\t\t            \t</div>\n\t\t            </div>\n\t\t\t\t\t<div class='container-fluid'>\n\t\t\t\t\t\t<div class='row'>\n\t\t\t\t\t\t\t<div class='col-lg-12 text-left'>\n\t\t\t\t\t\t\t\t<h2>Question {{currentQuestion.questionSequence}} </h2>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class='col-lg-12 text-left'>\n\t\t\t\t\t\t\t\t<h2><small>{{currentQuestion.questionTemplate}}</small></h2>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class='col-lg-12 text-left' *ng-for=\"#chart of currentQuestion.questionCharts\">\n\t\t\t\t\t\t\t\t<question-chart [chart-id]='chart.chartId' [chart-config]='chart.chartConfig' />\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class='col-lg-12 text-left'>\n\t\t\t\t\t\t\t\t<ul class='list-unstyled' *ng-for=\"#option of currentQuestion.questionOptions\">\n\t\t\t\t\t\t\t\t\t<li><input name='{{option.questionId}}' type='radio' />&nbsp;&nbsp; {{option.optionText}} </li>\n\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</section>\n\t\t\n\t\t<section class=\"container {{!answerSubmitted ? ' hidden' : ''}}\">\n\t\t\t<br/>\n\t\t\t<div class=\"container-fluid\">\n\t\t\t\t<div class=\"row\">\n\t\t\t\t\t<div class=\"col-xs-12 text-center\">\n\t\t\t\t\t    <span style=\"height:60px; vertical-align:middle; display:inline-block\">\n\t\t\t\t    \t\t<h2 style=\"margin-top:0px\">Your Rating is : {{riskRatingScore}}</h2>\n\t\t\t\t    \t</span>\n\t\t\t\t    \t<span style=\"width:30px; height:60px; display: inline-block;\">\n\t\t\t    \t\t\t<button class=\"btn btn-primary\" style=\"width:30px; height:30px\" (click)=\"incrRiskRating()\"\n\t\t\t    \t\t\t\tdisabled='{{riskRatingScore==100 ? \"disabled\" : \"\"}}'>\n\t\t\t    \t\t\t\t+\n\t\t\t    \t\t\t</button>\n\t\t\t    \t\t\t<button class=\"btn btn-primary\" style=\"width:30px; height:30px\" (click)=\"decrRiskRating()\"\n\t\t\t    \t\t\t\tdisabled='{{riskRatingScore==1 ? \"disabled\" : \"\"}}'>\n\t\t\t    \t\t\t\t-\n\t\t\t    \t\t\t</button>\n\t\t\t\t    \t</span>\n\t\t\t\t\t</div>\n\t\t\t\t\t<br/>\n\t\t\t\t\t<div class=\"col-xs-12\">\n\t\t\t\t\t\t<question-chart chart-id=\"portfolioPieChart\" [chart-config]=\"portfolioChartConfig\" />\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</section>\n  \t"
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof http_1.Http !== 'undefined' && http_1.Http) === 'function' && _a) || Object, (typeof (_b = typeof router_1.Router !== 'undefined' && router_1.Router) === 'function' && _b) || Object])
    ], QuestionSetComponent);
    return QuestionSetComponent;
    var _a, _b;
})();
exports.QuestionSetComponent = QuestionSetComponent;
//# sourceMappingURL=questionset.js.map
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
var QuestionChartComponent = (function () {
    function QuestionChartComponent() {
    }
    QuestionChartComponent.prototype.afterViewInit = function () {
        if (this.chartConfig != undefined && this.chartConfig != null && this.chartConfig != '')
            $('#' + this.chartId).highcharts(JSON.parse(this.chartConfig));
    };
    QuestionChartComponent.prototype.onChanges = function (changes) {
        if (changes['chartConfig']) {
            if (this.chartConfig != undefined && this.chartConfig != null && this.chartConfig != '')
                $('#' + this.chartId).highcharts(JSON.parse(this.chartConfig));
        }
    };
    QuestionChartComponent = __decorate([
        angular2_1.Component({
            selector: 'question-chart',
            properties: ['chartId: chart-id', 'chartConfig: chart-config']
        }),
        angular2_1.View({
            template: "\n\t\t<div id=\"{{chartId}}\">\n\t\t\t{{chartId}}\n\t\t</div>\n\t"
        }), 
        __metadata('design:paramtypes', [])
    ], QuestionChartComponent);
    return QuestionChartComponent;
})();
exports.QuestionChartComponent = QuestionChartComponent;
//# sourceMappingURL=questionchart.js.map
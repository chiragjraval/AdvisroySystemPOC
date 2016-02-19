import {Component, View} from 'angular2/angular2';

@Component({
  	selector: 'question-chart',
  	properties: ['chartId: chart-id', 'chartConfig: chart-config']
})
@View({
	template: `
		<div id="{{chartId}}">
			{{chartId}}
		</div>
	`
})
export class QuestionChartComponent implements AfterViewInit,OnChanges {
	chartId: string;
	chartConfig: string;
	
	constructor() {

  	}
  	
  	afterViewInit(): void {
		if(this.chartConfig != undefined && this.chartConfig != null && this.chartConfig != '')
			$('#'+this.chartId).highcharts(JSON.parse(this.chartConfig));
  	}
  	
  	onChanges(changes: {[idx: string, PropertyUpdate]}): void {
	    if (changes['chartConfig']) {
	      if(this.chartConfig != undefined && this.chartConfig != null && this.chartConfig != '')
				$('#'+this.chartId).highcharts(JSON.parse(this.chartConfig));
	    }
  	}
}
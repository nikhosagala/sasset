import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuReportService} from '../../../@core/data/menu-report.service';

@Component({
  selector: 'app-report-anggaran',
  templateUrl: './report-anggaran.component.html',
  styleUrls: ['./report-anggaran.component.scss'],
})
export class ReportAnggaranComponent implements OnInit {

  public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true,
    legend: {
      labels: {
        fontColor: '#FFFFFF',
      },
    },
    label: {
      fontColor: '#FFFFFF',
    },

  };
  public barChartLabels: string[] = ['1', '2', '3', '4'];
  public barChartType: string = 'bar';
  public barChartLegend: boolean = true;

  public barChartColor: any[] = [
    {backgroundColor: ['#FFFFFF', '#FFFFFF', '#FFFFFF', '#FFFFFFF']},
  ];

  public barChartData: any[] = [
    {data: [9, 10, 10, 7, 12, 0], label: 'Series A'},
  ];

  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }

  constructor(private menuReportService: MenuReportService) {
  }

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  ngOnInit() {
    this.settings = this.menuReportService.getSettings();
    const data = this.menuReportService.getData();
    this.source.load(data);
  }
}

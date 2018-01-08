import {RouterModule, Routes} from '@angular/router';
import {ReportComponent} from './report.component';
import {ReportAnggaranComponent} from './report-anggaran/report-anggaran.component';
import {ReportAssetComponent} from './report-asset/report-asset.component';
import {ReportPekerjaanComponent} from './report-pekerjaan/report-pekerjaan.component';
import {NgModule} from '@angular/core';

const routes: Routes = [{
  path: '',
  component: ReportComponent,
  children: [{
    path: 'anggaran',
    component: ReportAnggaranComponent,
  }, {
    path: 'asset',
    component: ReportAssetComponent,
  }, {
    path: 'progress',
    component: ReportPekerjaanComponent,
  }, {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class ReportRoutingModule {
}

export const routedComponents = [
  ReportComponent,
  ReportAnggaranComponent,
  ReportAssetComponent,
  ReportPekerjaanComponent,
]

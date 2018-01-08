import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {UnfinishedComponent} from './unfinished/unfinished.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [{
    path: 'dashboard',
    component: UnfinishedComponent,
  }, {
    path: 'maintenance',
    loadChildren: './maintenance/maintenance.module#MaintenanceModule',
  }, {
    path: 'assets',
    loadChildren: './asset/asset.module#AssetModule',
  }, {
    path: 'rab',
    loadChildren: './rab/rab.module#RabModule',
  }, {
    path: 'akun',
    loadChildren: './akun/akun.module#AkunModule',
  }, {
    path: 'vendor',
    loadChildren: './vendor/vendor.module#VendorModule',
  }, {
    path: 'prspk',
    loadChildren: './prspk/prspk.module#PrspkModule',
  }, {
    path: 'spb',
    loadChildren: './spb/spb.module#SpbModule',
  }, {
    path: 'elecpam',
    loadChildren: './elecpam/elecpam.module#ElecpamModule',
  }, {
    path: 'report',
    loadChildren: './report/report.module#ReportModule',
  }, {
    path: 'deleted',
    loadChildren: './deleted-asset/deleted-asset.module#DeletedAssetModule',
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
export class PagesRoutingModule {
}

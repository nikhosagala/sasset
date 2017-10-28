import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AssetComponent } from './asset.component';
import { AssetTableComponent } from './asset-table/asset-table.component';
import { AssetDetailComponent } from './asset-detail/asset-detail.component';

const routes: Routes = [{
  path: '',
  component: AssetComponent,
  children: [{
    path: ':asset',
    component: AssetTableComponent,
  }, {
    path: ':asset/:id',
    component: AssetDetailComponent,
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
export class AssetRoutingModule {
}

export const routedComponents = [
  AssetComponent,
  AssetTableComponent,
  AssetDetailComponent,
];

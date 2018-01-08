import {RouterModule, Routes} from '@angular/router';
import {SpbComponent} from './spb.component';
import {ListSpbComponent} from './list-spb/list-spb.component';
import {CreateSpbComponent} from './create-spb/create-spb.component';
import {NgModule} from '@angular/core';

const routes: Routes = [{
  path: '',
  component: SpbComponent,
  children: [{
    path: 'list',
    component: ListSpbComponent,
  }, {
    path: 'create',
    component: CreateSpbComponent,
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

export class SpbRoutingModule {
}

export const routedComponents = [
  SpbComponent,
  ListSpbComponent,
  CreateSpbComponent,
]

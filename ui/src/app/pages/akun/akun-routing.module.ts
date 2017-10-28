import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AkunComponent } from './akun.component';
import { CreateAkunComponent } from './create-akun/create-akun.component';
import { ListAkunComponent } from './list-akun/list-akun.component';
import { PrintAkunComponent } from './print-akun/print-akun.component';

const routes: Routes = [{
  path: '',
  component: AkunComponent,
  children: [{
    path: 'list',
    component: ListAkunComponent,
  }, {
    path: 'create',
    component: CreateAkunComponent,
  }, {
    path: 'print',
    component: PrintAkunComponent,
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
export class AkunRoutingModule {
}

export const routedComponents = [
  AkunComponent,
  CreateAkunComponent,
  ListAkunComponent,
  PrintAkunComponent,
];

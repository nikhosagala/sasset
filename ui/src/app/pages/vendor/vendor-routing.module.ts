import { VendorComponent } from './vendor.component';
import { CreateVendorComponent } from './create-vendor/create-vendor.component';
import { ListVendorComponent } from './list-vendor/list-vendor.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
  path: '',
  component: VendorComponent,
  children: [{
    path: 'list',
    component: ListVendorComponent,
  }, {
    path: 'create',
    component: CreateVendorComponent,
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

export class VendorRoutingModule {
}

export const routedComponents = [
  VendorComponent,
  CreateVendorComponent,
  ListVendorComponent,
];

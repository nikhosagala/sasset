import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { PrspkComponent } from './prspk.component';
import { PrintPrspkComponent } from './print-prspk/print-prspk.component';
import { CreatePrspkComponent } from './create-prspk/create-prspk.component';
import { ListPrspkComponent } from './list-prspk/list-prspk.component';

const routes: Routes = [{
  path: '',
  component: PrspkComponent,
  children: [{
    path: 'list',
    component: ListPrspkComponent,
  }, {
    path: 'create',
    component: CreatePrspkComponent,
  }, {
    path: 'print',
    component: PrintPrspkComponent,
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

export class PrspkRoutingModule {
}

export const routedComponents = [
  PrspkComponent,
  CreatePrspkComponent,
  ListPrspkComponent,
  PrintPrspkComponent,
]

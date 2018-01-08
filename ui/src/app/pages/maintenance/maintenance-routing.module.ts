import { RouterModule, Routes } from '@angular/router';
import { MaintenanceComponent } from './maintenance.component';
import { ListMaintenanceComponent } from './list-maintenance/list-maintenance.component';
import { CreateMaintenanceComponent } from './create-maintenance/create-maintenance.component';
import { NgModule } from '@angular/core';

const routes: Routes = [{
  path: '',
  component: MaintenanceComponent,
  children: [{
    path: 'list',
    component: ListMaintenanceComponent,
  }, {
    path: 'create',
    component: CreateMaintenanceComponent,
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

export class MaintenanceRoutingModule {
}

export const routedComponents = [
  MaintenanceComponent,
  ListMaintenanceComponent,
  CreateMaintenanceComponent,
]

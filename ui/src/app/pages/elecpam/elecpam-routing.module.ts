import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { ListElecpamComponent } from './list-elecpam/list-elecpam.component';
import { AnomaliElecpamComponent } from './anomali-elecpam/anomali-elecpam.component';
import { FlatElecpamComponent } from './flat-elecpam/flat-elecpam.component';
import { NormalElecpamComponent } from './normal-elecpam/normal-elecpam.component';
import { PrintElecpamComponent } from './print-elecpam/print-elecpam.component';
import { ElecpamComponent } from './elecpam.component';
import { CreateElecpamComponent } from './create-elecpam/create-elecpam.component';

const routes: Routes = [{
  path: '',
  component: ElecpamComponent,
  children: [{
    path: 'list',
    component: ListElecpamComponent,
  }, {
    path: 'create',
    component: CreateElecpamComponent,
  }, {
    path: 'anomali',
    component: AnomaliElecpamComponent,
  }, {
    path: 'flat',
    component: FlatElecpamComponent,
  }, {
    path: 'normal',
    component: NormalElecpamComponent,
  }, {
    path: 'print',
    component: PrintElecpamComponent,
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

export class ElecpamRoutingModule {
}

export const routedComponents = [
  ElecpamComponent,
  ListElecpamComponent,
  CreateElecpamComponent,
  AnomaliElecpamComponent,
  FlatElecpamComponent,
  NormalElecpamComponent,
  PrintElecpamComponent,
]

import { RouterModule, Routes } from '@angular/router';
import { RabComponent } from './rab.component';
import { CreateRabComponent } from './create-rab/create-rab.component';
import { NgModule } from '@angular/core';
import { ListRabComponent } from './list-rab/list-rab.component';
import { DraftRabComponent } from './draft-rab/draft-rab.component';
import { AssetAcComponent } from './create-rab/asset-ac/asset-ac.component';

const routes: Routes = [{
  path: '',
  component: RabComponent,
  children: [{
    path: 'list',
    component: ListRabComponent,
  }, {
    path: 'create',
    component: CreateRabComponent,
  }, {
    path: 'draft',
    component: DraftRabComponent,
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

export class RabRoutingModule {
}

export const routedComponents = [
  RabComponent,
  ListRabComponent,
  CreateRabComponent,
  AssetAcComponent,
  DraftRabComponent,
]

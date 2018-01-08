import { DeletedAssetComponent } from './deleted-asset.component';
import { ListDeletedAssetComponent } from './list-deleted-asset/list-deleted-asset.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

const routes: Routes = [{
  path: '',
  component: DeletedAssetComponent,
  children: [{
    path: 'list',
    component: ListDeletedAssetComponent,
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

export class DeletedAssetRoutingModule {
}

export const routedComponents = [
  DeletedAssetComponent,
  ListDeletedAssetComponent,
]

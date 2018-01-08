import {NgModule} from '@angular/core';
import {DeletedAssetRoutingModule, routedComponents} from './deleted-asset.routing.module';
import {NbCardModule} from '@nebular/theme';

@NgModule({
  imports: [
    DeletedAssetRoutingModule,
    NbCardModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})
export class DeletedAssetModule {
}

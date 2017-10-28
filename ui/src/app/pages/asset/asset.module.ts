import {NgModule} from '@angular/core';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {ThemeModule} from '../../@theme/theme.module';
import {NbCardModule} from '@nebular/theme';
import {AssetRoutingModule, routedComponents} from './asset-routing.module';

@NgModule({
  imports: [
    AssetRoutingModule,
    ThemeModule,
    NbCardModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})
export class AssetModule {
}

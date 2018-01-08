import {NgModule} from '@angular/core';
import {routedComponents, SpbRoutingModule} from './spb-routing.module';
import {NbCardModule} from '@nebular/theme';
import {Ng2SmartTableModule} from 'ng2-smart-table';

@NgModule({
  imports: [
    SpbRoutingModule,
    NbCardModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})

export class SpbModule {
}

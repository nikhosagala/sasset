import {NgModule} from '@angular/core';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {NbCardModule} from '@nebular/theme';
import {AkunRoutingModule, routedComponents} from './akun-routing.module';

@NgModule({
  imports: [
    AkunRoutingModule,
    NbCardModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
  providers: [],
})
export class AkunModule {
}

import {NgModule} from '@angular/core';
import {NbCardModule} from '@nebular/theme';
import {PrspkRoutingModule, routedComponents} from './prspk-routing.module';
import {MenuRabService} from '../../@core/data/menu-rab.service';
import {Ng2SmartTableModule} from 'ng2-smart-table';

@NgModule({
  imports: [
    PrspkRoutingModule,
    NbCardModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
  providers: [MenuRabService],
})

export class PrspkModule {
}

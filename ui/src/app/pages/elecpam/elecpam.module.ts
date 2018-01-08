import {NgModule} from '@angular/core';
import {NbCardModule} from '@nebular/theme';
import {ElecpamRoutingModule, routedComponents} from './elecpam-routing.module';
import {MenuRabService} from '../../@core/data/menu-rab.service';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    ElecpamRoutingModule,
    NbCardModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
  providers: [MenuRabService],
})

export class ElecpamModule {
}

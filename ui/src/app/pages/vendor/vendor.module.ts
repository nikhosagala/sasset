import {NgModule} from '@angular/core';
import {routedComponents, VendorRoutingModule} from './vendor-routing.module';
import {NbCardModule} from '@nebular/theme';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    ReactiveFormsModule,
    FormsModule,
    VendorRoutingModule,
    NbCardModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})

export class VendorModule {
}

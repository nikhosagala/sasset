import {NgModule} from '@angular/core';
import {MaintenanceRoutingModule, routedComponents} from './maintenance-routing.module';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {NbCardModule} from '@nebular/theme';
import {
  MatAutocompleteModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatNativeDateModule,
  MatOptionModule,
} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@NgModule({
  imports: [
    MaintenanceRoutingModule,
    Ng2SmartTableModule,
    NbCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatOptionModule,
    MatFormFieldModule,
    CommonModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})

export class MaintenanceModule {
}

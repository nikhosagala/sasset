import {NgModule} from '@angular/core';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {NbCardModule, NbCheckboxModule} from '@nebular/theme';
import {RabRoutingModule, routedComponents} from './rab-routing.module';
import {MenuRabService} from '../../@core/data/menu-rab.service';
import {NgbRatingModule} from '@ng-bootstrap/ng-bootstrap';
import {ThemeModule} from '../../@theme/theme.module';
import {MatAutocompleteModule, MatInputModule} from '@angular/material';

@NgModule({
  imports: [
    ThemeModule,
    RabRoutingModule,
    MatAutocompleteModule,
    MatInputModule,
    Ng2SmartTableModule,
    NgbRatingModule,
    NbCheckboxModule,
    NbCardModule,
  ],
  declarations: [
    ...routedComponents,
  ],
  providers: [MenuRabService],
})

export class RabModule {
}

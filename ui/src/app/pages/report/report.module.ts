import {NgModule} from '@angular/core';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import {ReportRoutingModule, routedComponents} from './report-routing.module';
import {NbCardModule, NbCheckboxModule} from '@nebular/theme';
import {NgbRatingModule} from '@ng-bootstrap/ng-bootstrap';
import {ThemeModule} from '../../@theme/theme.module';
import {MenuReportService} from '../../@core/data/menu-report.service';
import {ChartsModule} from 'ng2-charts';

@NgModule({
  imports: [
    ThemeModule,
    ReportRoutingModule,
    NgbRatingModule,
    Ng2SmartTableModule,
    NbCardModule,
    NbCheckboxModule,
    ChartsModule,
  ],
  declarations: [
    ...routedComponents,
  ],
  providers: [MenuReportService],
})

export class ReportModule {

}

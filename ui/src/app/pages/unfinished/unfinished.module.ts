import {NgModule} from '@angular/core';
import {ThemeModule} from '../../@theme/theme.module';
import {UnfinishedComponent} from './unfinished.component';
import {NbCardModule, NbMediaBreakpointsService} from '@nebular/theme';

@NgModule({
  imports: [
    ThemeModule,
    NbCardModule,
  ],
  declarations: [
    UnfinishedComponent,
  ],
})

export class UnfinishedModule {
  breakpoints: any;

  constructor(private breakpointService: NbMediaBreakpointsService) {
    this.breakpoints = breakpointService.getBreakpointsMap();
  }
}

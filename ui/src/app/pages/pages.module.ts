import {NgModule} from '@angular/core';

import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {ThemeModule} from '../@theme/theme.module';
import {UnfinishedModule} from './unfinished/unfinished.module';
import {AssetModule} from './asset/asset.module';
import {RabModule} from './rab/rab.module';
import {UtilsModule} from './utils/utils.module';
import {PrspkModule} from './prspk/prspk.module';
import {ElecpamModule} from './elecpam/elecpam.module';
import {MaintenanceModule} from './maintenance/maintenance.module';
import {DeletedAssetModule} from './deleted-asset/deleted-asset.module';
import {SpbModule} from './spb/spb.module';
import {ReportModule} from './report/report.module';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    AssetModule,
    UnfinishedModule,
    RabModule,
    UtilsModule,
    PrspkModule,
    ElecpamModule,
    MaintenanceModule,
    DeletedAssetModule,
    SpbModule,
    ReportModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],
})
export class PagesModule {
}

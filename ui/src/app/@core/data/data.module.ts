import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserService} from './users.service';
import {MenuAssetService} from './menu-asset.service';
import {MenuRabService} from './menu-rab.service';
import {FormService} from './location.service';
import {StateService} from './state.service';
import {MenuMaintenanceService} from './menu-maintenance.service';
import {MenuAkunService} from './menu-akun.service';
import {MenuVendorService} from './menu-vendor.service';
import {MenuPrspkService} from './menu-prspk.service';
import {MenuElecpamService} from './menu-elecpam.service';
import {MenuSpbService} from './menu-spb.service';

const SERVICES = [
  UserService,
  MenuAssetService,
  MenuRabService,
  FormService,
  StateService,
  MenuMaintenanceService,
  MenuAkunService,
  MenuVendorService,
  MenuPrspkService,
  MenuElecpamService,
  MenuSpbService,
];

@NgModule({
  imports: [
    CommonModule,
  ],
  providers: [
    ...SERVICES,
  ],
})
export class DataModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: DataModule,
      providers: [
        ...SERVICES,
      ],
    };
  }
}

import {MenuService} from './menu.service';
import {CommonModule} from '@angular/common';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {AssetService} from './asset.service';
import {DummyService} from './dummy.service';

const SERVICES = [
  MenuService,
  AssetService,
  DummyService,
];

@NgModule({
  imports: [
    CommonModule,
  ],
  providers: [
    ...SERVICES,
  ],
})

export class BackendModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: BackendModule,
      providers: [
        ...SERVICES,
      ],
    };
  }
}

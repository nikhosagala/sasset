import {NgModule} from '@angular/core';
import {CurrencyRendererComponent} from './currency-renderer/currency-renderer.component';
import {UppercaseRendererComponent} from './uppercase-renderer/uppercase-renderer.component';
import {CommonModule} from '@angular/common';
import {LocationRendererComponent} from './location-renderer/location-renderer.component';
import {VendorRendererComponent} from './vendor-renderer/vendor-renderer.component';
import {AssetStatusRendererComponent} from './asset-status-renderer/asset-status-renderer.component';

@NgModule({
  imports: [CommonModule],
  declarations: [
    CurrencyRendererComponent,
    UppercaseRendererComponent,
    LocationRendererComponent,
    VendorRendererComponent,
    AssetStatusRendererComponent,
  ],
  entryComponents: [
    CurrencyRendererComponent,
    UppercaseRendererComponent,
    LocationRendererComponent,
    VendorRendererComponent,
    AssetStatusRendererComponent,
  ],
})

export class UtilsModule {
}

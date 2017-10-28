import {Injectable} from '@angular/core';
import {LocationRendererComponent} from '../../pages/utils/location-renderer/location-renderer.component';
import {VendorRendererComponent} from '../../pages/utils/vendor-renderer/vendor-renderer.component';
import {AssetStatusRendererComponent} from '../../pages/utils/asset-status-renderer/asset-status-renderer.component';

@Injectable()
export class MenuAssetService {

  private settings = {
    hideSubHeader: true,
    actions: {
      position: 'right',
    },
    columns: {
      id: {
        title: 'ID',
        type: 'number',
      },
      treg: {
        title: 'TREG',
        type: 'string',
      },
      witel: {
        title: 'WITEL',
        type: 'string',
      },
      office: {
        title: 'Gedung',
        type: 'string',
      },
      quantity: {
        title: 'Jumlah',
        type: 'number',
      },
    }, add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    pager: {
      perPage: 7,
    },
  };

  private settingsDetails = {
    hideSubHeader: true,
    actions: false,
    columns: {
      id: {
        title: 'ID',
        type: 'number',
      },
      location: {
        title: 'Lokasi',
        type: 'custom',
        renderComponent: LocationRendererComponent,
      },
      function: {
        title: 'Function',
        type: 'string',
      },
      capacity: {
        title: 'Kapasitas (PK)',
        type: 'string',
      },
      type: {
        title: 'Tipe',
        type: 'number',
      },
      performance: {
        title: 'Performance (%)',
        type: 'text',
      },
      installationDate: {
        title: 'Tahun Install',
        type: 'text',
      },
      vendor: {
        title: 'Vendor',
        type: 'custom',
        renderComponent: VendorRendererComponent,
      },
      statusAsset: {
        title: 'Status',
        type: 'custom',
        renderComponent: AssetStatusRendererComponent,
      },
    },
    pager: {
      perPage: 10,
    },
  };

  getSettings() {
    return this.settings;
  }

  getSettingsDetail() {
    return this.settingsDetails;
  }
}

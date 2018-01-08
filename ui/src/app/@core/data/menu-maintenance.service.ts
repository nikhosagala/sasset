import {Injectable} from '@angular/core';

@Injectable()
export class MenuMaintenanceService {
  private settings = {
    hideSubHeader: true,
    actions: false,
    columns: {
      idAsset: {
        title: 'ID Asset',
        type: 'number',
      },
      maintenanceDate: {
        title: 'Maintenance Date',
        type: 'string',
      },
      maintenanceDocument: {
        title: 'Maintenance Document',
        type: 'string',
      },
      lastMaintenanceDate: {
        title: 'Last Maintenance',
        type: 'string',
      },
      maintenanceReport: {
        title: 'Maintenance Report',
        type: 'number',
      },
      status: {
        title: 'Status Asset',
        type: 'text',
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

  private data = [{
    id: 1231031,
    maintenanceDate: '14/10/2017',
    maintenanceDocument: 'Maintenance Asset 1231031.docx',
    lastMaintenanceDate: '12/08/2017',
    maintenanceReport: 'Asset dalam keadaan baik',
    status: 'Running Normal',
  }, {
    id: 3120312,
    maintenanceDate: '10/10/2017',
    maintenanceDocument: 'Maintenance Asset 3120312.docx',
    lastMaintenanceDate: '05/06/2017',
    maintenanceReport: 'Asset perlu perbaikan',
    status: 'Need Repair',
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }
}

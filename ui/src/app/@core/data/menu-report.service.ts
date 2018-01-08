import { Injectable } from '@angular/core';

@Injectable()
export class MenuReportService {
  private settings = {
    hideSubHeader: true,
    actions: false,
    columns: {
      function: {
        title: 'Function',
        type: 'text',
      },
      jumlah: {
        title: 'Jumlah',
        type: 'number',
      },
      runningnormal: {
        title: 'Running Normal',
        type: 'number',
      },
      undermaintenance: {
        title: 'Under Maintenance',
        type: 'number',
      },
      off: {
        title: 'Off',
        type: 'number',
      },
      belummaintenance: {
        title: 'Belum Maintenance',
        type: 'number',
      },
    },
  };

  private data = [{
    function: 'Split',
    jumlah: 54,
    runningnormal: '40',
    undermaintenance: '7',
    off: '4',
    belummaintenance: '3',
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }
}

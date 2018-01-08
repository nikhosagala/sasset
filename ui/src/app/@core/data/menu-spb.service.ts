import {Injectable} from '@angular/core';

@Injectable()
export class MenuSpbService {

  private settings = {
    hideSubHeader: true,
    actions: false,
    columns: {
      id: {
        title: 'ID',
        type: 'text',
      },
      treg: {
        title: 'TREG',
        type: 'text',
      },
      witel: {
        title: 'WITEL',
        type: 'text',
      },
      workType: {
        title: 'Pekerjaan',
        type: 'text',
      },
      nilai: {
        title: 'Nilai',
        type: 'text',
      },
      status: {
        title: 'Status',
        type: 'text',
      },
    },
  };

  private data = [{
    id: 1,
    treg: 'III',
    witel: 'Bandung',
    workType: 'Perbaikan AC Daikin',
    nilai: 1200000,
    status: 'Tagihan lengkap, sudah masuk ke finance',
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }

}

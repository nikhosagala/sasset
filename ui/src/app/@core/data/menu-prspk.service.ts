import {Injectable} from '@angular/core';

@Injectable()
export class MenuPrspkService {
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
      office: {
        title: 'Kantor',
        type: 'text',
      },
      workType: {
        title: 'Pekerjaan',
        type: 'text',
      },
      dateApprove: {
        title: 'Tanggal Disetujui',
        type: 'text',
      },
      prspk: {
        title: 'PR/SPK',
        type: 'text',
      },
      createdAt: {
        title: 'Tanggal Dibuat',
        type: 'text',
      },
      vendor: {
        title: 'Vendor',
        type: 'text',
      },
      noSpkpr: {
        title: 'No SPK/PR',
        type: 'text',
      },
      akun: {
        title: 'Akun',
        type: 'text',
      },
      anggaran: {
        title: 'Anggaran',
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

  data = [{
    id: 1,
    treg: 'III',
    witel: 'Bandung',
    office: 'Telkom Lembong',
    workType: 'Perbaikan AC Daikin',
    dateApprove: '1/10/2017',
    prspk: 'SPK',
    createdAt: '20/09/2017',
    vendor: 'Fimar',
    noSpkpr: 'LEM/42/1412',
    akun: 'Catu Daya',
    anggaran: 'OPEX',
    nilai: 12000000,
    status: 'Sudah dikirim ke principle',
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }
}

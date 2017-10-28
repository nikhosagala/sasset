import {Injectable} from '@angular/core';

@Injectable()
export class MenuElecpamService {

  private settings = {
    hideSubHeader: true,
    actions: false,
    columns: {
      id: {
        title: 'NO',
        type: 'text',
      },
      idPel: {
        title: 'ID Pelanggan',
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
        title: 'Gedung',
        type: 'text',
      },
      name: {
        title: 'Nama ID',
        type: 'text',
      },
      address: {
        title: 'Alamat',
        type: 'text',
      },
      tariff: {
        title: 'Tarif',
        type: 'text',
      },
      power: {
        title: 'Daya',
        type: 'text',
      },
      pengelola: {
        title: 'Pengelola',
        type: 'text',
      },
      lastBill: {
        title: 'Tagihan Terakhir',
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
    idPel: 110000032865,
    treg: 'I',
    witel: 'ACEH',
    office: 'Kantor ACEH',
    name: 'KTR OP PERUMTEL MBO',
    address: 'JL. MERDEKA',
    tariff: 'B2',
    power: 147000,
    pengelola: 'PT. GSD',
    lastBill: 27444136,
    status: 'ON',
  }, {
    id: 2,
    idPel: 110100000288,
    treg: 'I',
    witel: 'ACEH',
    office: 'Kantor ACEH 2',
    name: 'KANTOR TELEKOM',
    address: 'JL. CALANG',
    tariff: 'B2',
    power: 41500,
    pengelola: 'PT. GSD',
    lastBill: 6691690,
    status: 'ON',
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }
}

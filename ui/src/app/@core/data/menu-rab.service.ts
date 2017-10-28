import {Injectable} from '@angular/core';
import {CurrencyRendererComponent} from '../../pages/utils/currency-renderer/currency-renderer.component';
import {UppercaseRendererComponent} from '../../pages/utils/uppercase-renderer/uppercase-renderer.component';

@Injectable()
export class MenuRabService {
  private data = [{
    id: 1,
    treg: 'I',
    witel: 'ACEH',
    gedung: 'Gedung WITEL ACEH',
    tanggal: '30/01/2017',
    pekerjaan: 'Perbaikan AC Daikin',
    nodin: 'c.tel 5124',
    akun: 54710,
    nilaiAwal: 4500000,
    nilaiEvaluasi: 4815000,
    status: 'DONE',
  }, {
    id: 2,
    treg: 'I',
    witel: 'ACEH',
    gedung: 'GEDUNG WITEL ACEH',
    tanggal: '02/02/2017',
    pekerjaan: 'Pengadaan BBM Solar',
    nodin: 'c. tel 5238',
    akun: 53210,
    nilaiAwal: 5000000,
    nilaiEvaluasi: 5350000,
    status: 'DONE',
  }, {
    id: 3,
    treg: 'I',
    witel: 'ACEH',
    gedung: 'GEDUNG WITEL ACEH',
    tanggal: '25/02/2017',
    pekerjaan: 'Pembayaran Perbaikan Genset',
    nodin: 'c. tel 5674',
    akun: 54710,
    nilaiAwal: 56000000,
    nilaiEvaluasi: 59920000,
    status: 'DONE',
  }, {
    id: 4,
    treg: 'I',
    witel: 'ACEH',
    gedung: 'GEDUNG WITEL ACEH',
    tanggal: '04/03/2017',
    pekerjaan: 'Perbaikan AC Samsung',
    nodin: 'c. tel 6389',
    akun: 54710,
    nilaiAwal: 3300000,
    nilaiEvaluasi: 3531000,
    status: 'DONE',
  }, {
    id: 5,
    treg: 'I',
    witel: 'ACEH',
    gedung: 'GEDUNG WITEL ACEH',
    tanggal: '04/03/2017',
    pekerjaan: 'Pengadaan BBM Solar',
    nodin: 'c. tel 8892',
    akun: 53210,
    nilaiAwal: 900000,
    nilaiEvaluasi: 963000,
    status: 'DONE',
  }, {
    id: 6,
    treg: 'I',
    witel: 'BANGKA BELITUNG',
    gedung: 'GEDUNG WITEL BANGKA BELITUNG',
    tanggal: '08/03/2017',
    pekerjaan: 'Pembayaran UJL ID PLN',
    nodin: 'c.tel 7329',
    akun: 55541,
    nilaiAwal: 650000,
    nilaiEvaluasi: 695500,
    status: 'DONE',
  }, {
    id: 7,
    treg: 'I',
    witel: 'LAMPUNG',
    gedung: 'GEDUNG WITEL LAMPUNG',
    tanggal: '29/05/2017',
    pekerjaan: 'Pengadaan Tiang Listrik',
    nodin: 'c. tel 2783',
    akun: 54710,
    nilaiAwal: 6700000,
    nilaiEvaluasi: 7169000,
    status: 'DONE',
  }];

  private settings = {
    hideSubHeader: true,
    actions: {
      position: 'right',
    },
    columns: {
      id: {
        title: 'ID',
        type: 'text',
        editable: false,
      },
      treg: {
        title: 'TREG',
        type: 'text',
      },
      witel: {
        title: 'WITEL',
        type: 'text',
      },
      gedung: {
        title: 'Gedung',
        type: 'custom',
        renderComponent: UppercaseRendererComponent,
      },
      tanggal: {
        title: 'Tanggal',
        type: 'date',
      },
      nodin: {
        title: 'Nota Dinas',
        type: 'custom',
        renderComponent: UppercaseRendererComponent,
      },
      akun: {
        title: 'Akun',
        type: 'text',
        editable: false,
      },
      nilaiAwal: {
        title: 'Nilai Awal',
        type: 'custom',
        renderComponent: CurrencyRendererComponent,
      },
      nilaiEvaluasi: {
        title: 'Nilai Evaluasi',
        type: 'custom',
        renderComponent: CurrencyRendererComponent,
      },
      status: {
        title: 'Status',
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

  private draft = [];

  getData() {
    return this.data;
  }

  getSettings() {
    return this.settings;
  }

  getDraft() {
    return this.draft;
  }
}

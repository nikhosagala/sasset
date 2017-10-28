import {Injectable} from '@angular/core';

@Injectable()
export class MenuAkunService {

  private settings = {
    hideSubHeader: true,
    actions: {
      position: 'right',
    },
    columns: {
      id: {
        title: 'ID',
        type: 'text',
      },
      periode: {
        title: 'Periode',
        type: 'text',
      },
      akun: {
        title: 'Akun',
        type: 'text',
      },
      saldoAwal: {
        title: 'Saldo Awal',
        type: 'text',
      },
      saldoTerpakai: {
        title: 'Terpakai',
        type: 'text',
      },
      saldoSisa: {
        title: 'Sisa',
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
    id: 1,
    periode: '2016/2017',
    akun: 'Listrik',
    saldoAwal: 30000000,
    saldoTerpakai: 10000000,
    saldoSisa: 20000000,
  }, {
    id: 2,
    periode: '2016/2017',
    akun: 'Catu Daya',
    saldoAwal: 25000000,
    saldoTerpakai: 20000000,
    saldoSisa: 5000000,
  }];

  getSettings() {
    return this.settings;
  }

  getData() {
    return this.data;
  }

}

import {Injectable} from '@angular/core';

@Injectable()
export class MenuVendorService {
  private settings = {
    hideSubHeader: true,
    actions: false,
    columns: {
      id: {
        title: 'ID',
        type: 'text',
      },
      vendorName: {
        title: 'Name',
        type: 'text',
      },
      assetType: {
        title: 'Jenis Asset',
        type: 'text',
      },
      location: {
        title: 'Lokasi',
        type: 'text',
      },
      address: {
        title: 'Alamat',
        type: 'text',
      },
      bankAccount: {
        title: 'Nomor Rekening',
        type: 'text',
      },
      bank: {
        title: 'Bank',
        type: 'text',
      },
      bankAddress: {
        title: 'Alamat Bank',
        type: 'text',
      },
      pic: {
        title: 'PIC',
        type: 'text',
      },
    },
    pager: {
      perPage: 10,
    },
  };

  private data = [{
    id: 1,
    vendorName: 'Fimar',
    assetType: 'AC',
    location: 'Kantor Pusat Telkom',
    address: 'Jl. Sumatra Barat',
    bankAccount: 30112412123,
    bank: 'BCA',
    bankAddress: 'KCP Buah Batu',
    pic: 'Asep Jumaedi (08132412947)',
  }, {
    id: 2,
    vendorName: 'Teknik Pendingin',
    assetType: 'AC',
    location: 'Kantor Telkom Jakarta',
    address: 'Jl. Sudirman',
    bankAccount: 141212412123,
    bank: 'Mandiri',
    bankAddress: 'KCP Sudirman',
    pic: 'Kusnandar (08522412947)',
  }];

  getData() {
    return this.data;
  }

  getSettings() {
    return this.settings;
  }
}

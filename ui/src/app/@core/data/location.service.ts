import {Injectable} from '@angular/core';

@Injectable()
export class FormService {
  private treg = [{
    id: 1,
    name: 'I',
  }, {
    id: 2,
    name: 'II',
  }, {
    id: 3,
    name: 'III',
  }, {
    id: 4,
    name: 'IV',
  }, {
    id: 5,
    name: 'V',
  }, {
    id: 6,
    name: 'VI',
  }, {
    id: 7,
    name: 'VII',
  }]

  private assetType = [{
    id: 1,
    name: 'AC',
  }, {
    id: 2,
    name: 'Genset',
  }]

  getTreg() {
    return this.treg;
  }

  getAssetType() {
    return this.assetType;
  }
}

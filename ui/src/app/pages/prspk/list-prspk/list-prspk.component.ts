import {Component, OnInit} from '@angular/core';
import {MenuPrspkService} from '../../../@core/data/menu-prspk.service';
import {LocalDataSource} from 'ng2-smart-table';

@Component({
  selector: 'ngx-list-prspk',
  templateUrl: './list-prspk.component.html',
  styleUrls: ['./list-prspk.component.scss'],
})
export class ListPrspkComponent implements OnInit {
  source: LocalDataSource = new LocalDataSource();
  assetType: string;
  settings: any;

  constructor(private menuPrspkService: MenuPrspkService) {
  }

  ngOnInit() {
    this.settings = this.menuPrspkService.getSettings();
    const data = this.menuPrspkService.getData();
    this.source.load(data);
  }

}

import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuAkunService} from '../../../@core/data/menu-akun.service';

@Component({
  selector: 'ngx-list-akun',
  templateUrl: './list-akun.component.html',
  styleUrls: ['./list-akun.component.scss'],
})
export class ListAkunComponent implements OnInit {

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  constructor(private menuAkunService: MenuAkunService) {
  }

  ngOnInit() {
    this.settings = this.menuAkunService.getSettings();
    const data = this.menuAkunService.getData();
    this.source.load(data);
  }

}

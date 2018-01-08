import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';

import {default as swal} from 'sweetalert2'
import {MenuRabService} from '../../../@core/data/menu-rab.service';

@Component({
  selector: 'ngx-list-rab',
  templateUrl: './list-rab.component.html',
  styleUrls: ['./list-rab.component.scss'],
})
export class ListRabComponent implements OnInit {

  constructor(private menuRabService: MenuRabService) {
  }

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  onClickAdd() {
    swal(
      'Oops',
      'Yur bout to add somthin',
      'error',
    )
  }

  ngOnInit() {
    this.settings = this.menuRabService.getSettings();
    const data = this.menuRabService.getData();
    this.source.load(data);
  }

}

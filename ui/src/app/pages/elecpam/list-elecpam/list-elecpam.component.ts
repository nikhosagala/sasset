import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuElecpamService} from '../../../@core/data/menu-elecpam.service';

@Component({
  selector: 'ngx-list-elecpam',
  templateUrl: './list-elecpam.component.html',
  styleUrls: ['./list-elecpam.component.scss'],
})
export class ListElecpamComponent implements OnInit {

  source: LocalDataSource = new LocalDataSource();
  data: any;
  settings: any;

  constructor(private menuElecpamService: MenuElecpamService) {
  }

  ngOnInit() {
    this.settings = this.menuElecpamService.getSettings();
    const data = this.menuElecpamService.getData();
    this.source.load(data);
  }

}

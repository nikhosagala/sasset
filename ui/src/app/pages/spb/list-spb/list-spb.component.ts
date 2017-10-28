import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuSpbService} from '../../../@core/data/menu-spb.service';

@Component({
  selector: 'app-list-spb',
  templateUrl: './list-spb.component.html',
  styleUrls: ['./list-spb.component.scss'],
})
export class ListSpbComponent implements OnInit {

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  constructor(private menuSpbService: MenuSpbService) {
  }

  ngOnInit() {
    this.settings = this.menuSpbService.getSettings();
    const data = this.menuSpbService.getData();
    this.source.load(data);
  }

}

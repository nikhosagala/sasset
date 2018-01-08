import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuVendorService} from '../../../@core/data/menu-vendor.service';

@Component({
  selector: 'app-list-vendor',
  templateUrl: './list-vendor.component.html',
  styleUrls: ['./list-vendor.component.scss'],
})
export class ListVendorComponent implements OnInit {

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  constructor(private menuVendorService: MenuVendorService) {
  }

  ngOnInit() {
    this.settings = this.menuVendorService.getSettings();
    const data = this.menuVendorService.getData();
    this.source.load(data);
  }

}

import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuMaintenanceService} from '../../../@core/data/menu-maintenance.service';
import {DummyService} from '../../../@core/backend/dummy.service';

@Component({
  selector: 'app-list-maintenance',
  templateUrl: './list-maintenance.component.html',
  styleUrls: ['./list-maintenance.component.scss'],
})
export class ListMaintenanceComponent implements OnInit {

  constructor(private maintenanceService: MenuMaintenanceService, private dummyService: DummyService) {
  }

  source: LocalDataSource = new LocalDataSource();
  data: any;
  settings: any;

  ngOnInit() {
    this.settings = this.maintenanceService.getSettings();
    this.dummyService.getMaintenance().subscribe(response => {
      const data = response.data;
      this.source.load(data);
    });
  }

}

import {Component, OnInit} from '@angular/core';
import {MenuRabService} from '../../../@core/data/menu-rab.service';
import {LocalDataSource} from 'ng2-smart-table';

@Component({
  selector: 'ngx-draft-rab',
  templateUrl: './draft-rab.component.html',
  styleUrls: ['./draft-rab.component.scss'],
})
export class DraftRabComponent implements OnInit {

  constructor(private rabService: MenuRabService) {
  }

  source: LocalDataSource = new LocalDataSource();
  settings: any;

  ngOnInit() {
    this.settings = this.rabService.getSettings();
    const data = this.rabService.getDraft();
    this.source.load(data);
  }

}

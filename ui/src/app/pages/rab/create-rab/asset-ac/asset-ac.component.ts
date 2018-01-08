import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'ngx-asset-ac',
  templateUrl: './asset-ac.component.html',
  styleUrls: ['./asset-ac.component.scss'],
})
export class AssetAcComponent implements OnInit {

  @Input()
  jenisPekerjaan: string;

  constructor() {
  }

  ngOnInit() {
  }

}

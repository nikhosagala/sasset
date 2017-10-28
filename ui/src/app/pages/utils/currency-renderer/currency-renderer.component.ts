import {Component, Input, OnInit} from '@angular/core';
import {ViewCell} from 'ng2-smart-table';

@Component({
  selector: 'ngx-fam-currency-renderer',
  templateUrl: './currency-renderer.component.html',
})
export class CurrencyRendererComponent implements ViewCell, OnInit {

  renderValue: number = 0;

  @Input() value: number;
  @Input() rowData: any;

  constructor() {
  }

  ngOnInit() {
    this.renderValue = this.value;
    if (!this.renderValue) {
      this.renderValue = 0;
    }
  }

}

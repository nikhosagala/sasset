import {Component, Input, OnInit} from '@angular/core';
import {ViewCell} from 'ng2-smart-table';

@Component({
  selector: 'ngx-fam-uppercase-renderer',
  templateUrl: './uppercase-renderer.component.html',
})
export class UppercaseRendererComponent implements ViewCell, OnInit {
  renderValue: string;

  @Input() value: string | number;
  @Input() rowData: any;

  constructor() {
  }

  ngOnInit() {
    this.renderValue = this.value.toString().toUpperCase();
  }
}

import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-vendor-renderer',
  templateUrl: './vendor-renderer.component.html',
})
export class VendorRendererComponent implements OnInit {
  renderValue: string;

  @Input() value: any;
  @Input() rowData: any;

  constructor() {
  }

  ngOnInit() {
    this.renderValue = this.value['name'];
  }

}

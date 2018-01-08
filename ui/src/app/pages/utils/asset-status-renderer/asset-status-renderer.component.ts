import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-asset-status-renderer',
  templateUrl: './asset-status-renderer.component.html',
})
export class AssetStatusRendererComponent implements OnInit {
  renderValue: string;

  @Input() value: any;
  @Input() rowData: any;

  constructor() {
  }

  ngOnInit() {
    if (this.value === 1) {
      this.renderValue = 'Running Normal';
    } else if (this.value === 2) {
      this.renderValue = 'Need Repairing';
    } else if (this.value === 3) {
      this.renderValue = 'Under Maintenance';
    }
  }

}

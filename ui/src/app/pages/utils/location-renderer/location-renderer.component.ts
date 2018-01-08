import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-location-renderer',
  templateUrl: './location-renderer.component.html',
})
export class LocationRendererComponent implements OnInit {
  renderValue: string;

  @Input() value: any;
  @Input() rowData: any;

  constructor() {
  }

  ngOnInit() {
    this.renderValue = this.value['roomName'];
  }

}

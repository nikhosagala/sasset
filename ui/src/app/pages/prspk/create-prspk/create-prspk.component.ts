import {Component, OnInit} from '@angular/core';
import {MenuPrspkService} from '../../../@core/data/menu-prspk.service';

@Component({
  selector: 'ngx-create-prspk',
  templateUrl: './create-prspk.component.html',
  styleUrls: ['./create-prspk.component.scss'],
})
export class CreatePrspkComponent implements OnInit {

  constructor(private menuPrspkService: MenuPrspkService) {
  }

  ngOnInit() {
  }

}

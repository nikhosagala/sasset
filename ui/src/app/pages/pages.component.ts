import {Component, OnInit} from '@angular/core';
import {MenuService} from '../@core/backend/menu.service';
import {NbMenuItem} from '@nebular/theme';
import {MENU_ITEMS} from './pages-menu';

@Component({
  selector: 'ngx-pages',
  templateUrl: './pages.component.html',
})
export class PagesComponent implements OnInit {

  constructor(private menuService: MenuService) {

  }

  menu: NbMenuItem[] = MENU_ITEMS;

  ngOnInit(): void {
    this.menuService.getMenu().subscribe(response => {
      this.menu = response.data;
    })
  }

}

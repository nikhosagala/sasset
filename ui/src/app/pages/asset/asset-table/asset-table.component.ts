import {Component, OnInit} from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';

import {default as swal} from 'sweetalert2';
import {ActivatedRoute, Router} from '@angular/router';
import {MenuAssetService} from '../../../@core/data/menu-asset.service';
import {AssetService} from '../../../@core/backend/asset.service';

@Component({
  selector: 'ngx-fam-asset-table',
  templateUrl: './asset-table.component.html',
  styleUrls: ['./asset-table.component.scss'],
})
export class AssetTableComponent implements OnInit {

  source: LocalDataSource = new LocalDataSource();
  assetType: string;
  settings: any;
  private sub: any;

  constructor(private menuAssetService: MenuAssetService,
              private assetService: AssetService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  onDeleteConfirm(): void {
    swal(
      'Oops',
      'Yur bout to del this',
      'error',
    )
  }

  onClickRow(event): void {
    this.router.navigate(['/pages/assets/' + this.assetType, event.data.id]).then();
  }

  ngOnInit(): void {
    this.settings = this.menuAssetService.getSettings();
    this.sub = this.route.params.subscribe(params => {
      this.assetType = params['asset'];
      this.source.reset(false);
      this.assetService.getSummary(this.assetType).subscribe(response => {
        const data = response.data;
        this.source.load(data);
      });
    });
  }
}

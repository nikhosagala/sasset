import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {LocalDataSource} from 'ng2-smart-table';
import {MenuAssetService} from '../../../@core/data/menu-asset.service';
import {AssetService} from '../../../@core/backend/asset.service';

@Component({
  selector: 'app-asset-detail',
  templateUrl: './asset-detail.component.html',
  styleUrls: ['./asset-detail.component.scss'],
})
export class AssetDetailComponent implements OnInit {

  constructor(private assetService: AssetService,
              private menuAssetService: MenuAssetService,
              private route: ActivatedRoute) {
  }

  source: LocalDataSource = new LocalDataSource();
  data: any;
  settings: any;
  office: string;
  private sub: any;

  ngOnInit() {
    this.settings = this.menuAssetService.getSettingsDetail();
    this.sub = this.route.params.subscribe(params => {
      this.assetService.getSummaryDetail(params['id']).subscribe(response => {
        this.data = response.data[0];
        this.office = this.data.office;
        this.source.load(this.data.details);
      });
    })
  }
}

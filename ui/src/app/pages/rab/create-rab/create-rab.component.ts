import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {FormControl} from '@angular/forms';
import {FormService} from '../../../@core/data/location.service';

@Component({
  selector: 'ngx-create-rab',
  templateUrl: './create-rab.component.html',
  styleUrls: ['./create-rab.component.scss'],
})
export class CreateRabComponent implements OnInit {
  assetType: FormControl = new FormControl();
  jenisPekerjaan: string;
  options: any;
  filteredOptions: Observable<string[]>;

  constructor(private formService: FormService) {

  }

  chooseJenisPekerjaan(from): void {
    if (from === 0) {
      this.jenisPekerjaan = 'pengadaan';
    } else {
      this.jenisPekerjaan = 'maintenance';
    }

  }

  onClickAssetType() {
    console.log(this.assetType.value);
  }

  ngOnInit() {
    this.options = this.formService.getAssetType();
    this.filteredOptions = this.assetType.valueChanges
      .startWith(null)
      .map(val => val ? this.filter(val) : this.options.slice());
  }


  filter(val: string): string[] {
    return this.options.filter(option =>
      option.name.toLowerCase().indexOf(val.toLowerCase()) === 0);
  }

  assetTypeSelected() {
    console.log(this.assetType.value);
  }

}

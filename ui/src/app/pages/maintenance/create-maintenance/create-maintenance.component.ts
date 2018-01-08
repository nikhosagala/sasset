import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DummyService} from '../../../@core/backend/dummy.service';
import {Router} from '@angular/router';

import {default as swal} from 'sweetalert2'
import {AssetService} from '../../../@core/backend/asset.service';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-create-maintenance',
  templateUrl: './create-maintenance.component.html',
  styleUrls: ['./create-maintenance.component.scss'],
})
export class CreateMaintenanceComponent implements OnInit {

  maintenance = {
    idAsset: null,
    maintenanceDate: null,
    maintenanceDocument: null,
    lastMaintenanceDate: null,
    maintenanceReport: null,
    status: null,
  };

  assets: any;
  filteredOptions: Observable<string[]>;
  assetSearch: FormControl = new FormControl();

  sanity: any;

  maintenanceForm: FormGroup;
  submitted = false;

  statusses = [
    'Running Normal',
    'Under Maintenance',
    'Need Repair',
    'Off',
  ];

  constructor(private formBuilder: FormBuilder,
              private dummyService: DummyService,
              private router: Router,
              private assetService: AssetService) {
  }

  ngOnInit() {
    this.buildForm();
    this.assetService.get().subscribe(response => {
      this.assets = response.data;
      this.filteredOptions = this.assetSearch.valueChanges.startWith(null)
        .map(val => val ? this.filter(val) : this.assets.slice());
    });
  }

  filter(val: string): string[] {
    return this.assets.filter(option => option.id.toString().indexOf(val) === 0);
  }

  buildForm() {
    this.maintenanceForm = this.formBuilder.group({
      idAsset: [this.maintenance.idAsset, Validators.required],
      maintenanceDate: [this.maintenance.maintenanceDate, Validators.required],
      maintenanceDocument: [this.maintenance.maintenanceDocument, Validators.required],
      lastMaintenanceDate: [this.maintenance.lastMaintenanceDate],
      maintenanceReport: [this.maintenance.maintenanceReport],
      status: [this.maintenance.status],
    })
  }

  onSubmit() {
    this.submitted = true;
    this.maintenance = Object.assign({}, this.maintenanceForm.value);
    this.sanityCheck();
  }

  sanityCheck() {
    this.maintenance.maintenanceDate = this.maintenance.maintenanceDate.toLocaleDateString('ca-ES');
    this.maintenance.lastMaintenanceDate = this.maintenance.lastMaintenanceDate.toLocaleDateString('ca-ES');
    this.sanity = Object.assign({}, this.maintenance);
    this.dummyService.saveMaintenance(this.sanity).subscribe();
    swal
    (
      'success',
      'Berhasil Input Maintenance',
    );
    this.router.navigateByUrl('pages/maintenance/list');
  }

}

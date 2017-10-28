import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DummyService} from '../../../@core/backend/dummy.service';
import {Router} from '@angular/router';
import {default as swal} from 'sweetalert2'


@Component({
  selector: 'app-create-vendor',
  templateUrl: './create-vendor.component.html',
  styleUrls: ['./create-vendor.component.scss'],
})
export class CreateVendorComponent implements OnInit {

  errorMessageResources = {
    vendorName: {
      required: 'Data Ini Harus Diisikan.',
    },
    assetType: {
      required: 'Data Ini Harus Diisikan.',
    },
    location: {
      required: 'Data Ini Harus Diisikan.',
    },
    address: {
      required: 'Data Ini Harus Diisikan.',
    },
    bankAccountNumber: {
      required: 'Data Ini Harus Diisikan.',
    },
    bank: {
      required: 'Data Ini Harus Diisikan.',
    },
    bankAddress: {
      required: 'Data Ini Harus Diisikan.',
    },
    pic: {
      required: 'Data Ini Harus Diisikan.',
    },
  };

  vendor = {
    vendorName: '',
    assetType: '',
    location: '',
    address: '',
    bankAccountNumber: '',
    bank: '',
    bankAddress: '',
    pic: '',
  };

  submitted = false;
  vendorForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private dummyService: DummyService,
              private router: Router) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.vendorForm = this.formBuilder.group({
      vendorName: [this.vendor.vendorName, Validators.required],
      assetType: [this.vendor.assetType, Validators.required],
      location: [this.vendor.location, Validators.required],
      address: [this.vendor.address, Validators.required],
      bankAccountNumber: [this.vendor.bankAccountNumber, Validators.required],
      bank: [this.vendor.bank, Validators.required],
      bankAddress: [this.vendor.bankAddress, Validators.required],
      pic: [this.vendor.pic, Validators.required],
  })
}

  onSubmit() {
    this.submitted = true;
    this.vendor = Object.assign({}, this.vendorForm.value);
    this.dummyService.saveMaintenance(this.vendor).subscribe();
    this.router.navigateByUrl('pages/vendor/list');
    console.log(this.vendorForm.value);
  }

  clear() {
    this.vendorForm.reset();
  }
}

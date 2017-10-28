import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DummyService} from '../../../@core/backend/dummy.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-elecpam',
  templateUrl: './create-elecpam.component.html',
  styleUrls: ['./create-elecpam.component.scss'],
})
export class CreateElecpamComponent implements OnInit {

  errorMessageResources = {
    treg: {
      required: 'Data Ini Harus Diisikan.',
    },
    witel: {
      required: 'Data Ini Harus Diisikan.',
    },
    customerID: {
      required: 'Data Ini Harus Diisikan.',
    },
    nameID: {
      required: 'Data Ini Harus Diisikan.',
    },
    address: {
      required: 'Data Ini Harus Diisikan.',
    },
    outcome: {
      required: 'Data Ini Harus Diisikan.',
    },
    power: {
      required: 'Data Ini Harus Diisikan.',
    },
    administrator: {
      required: 'Data Ini Harus Diisikan.',
    },
  };

  electric = {
    treg: '',
    witel: '',
    customerID: '',
    nameID: '',
    address: '',
    outcome: '',
    power: '',
    administrator: '',
  };

  sumbitted = false;
  electricForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private dummyService: DummyService,
              private router: Router) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.electricForm = this.formBuilder.group({
      treg: [this.electric.treg, Validators.required],
      witel: [this.electric.witel, Validators.required],
      customerID: [this.electric.customerID, Validators.required],
      nameID: [this.electric.nameID, Validators.required],
      address: [this.electric.address, Validators.required],
      outcome: [this.electric.outcome, Validators.required],
      power: [this.electric.power, Validators.required],
      administrator: [this.electric.administrator, Validators.required],
    })
  }

  onSubmit() {
    this.sumbitted = true;
    this.electric = Object.assign({}, this.electricForm.value);
    this.dummyService.saveMaintenance(this.electric).subscribe();
    this.router.navigateByUrl('page/elecpam/list');
    console.log(this.electricForm.value);
  }

  clear() {
    this.electricForm.reset();
  }

}

import {Inject, Injectable} from '@angular/core';
import {CrudService} from './crud.service';
import {API_ROUTES} from '../utils/routes';
import {GlobalErrorHandler} from '../utils/error.handler';
import {Http, RequestMethod} from '@angular/http';

@Injectable()
export class DummyService extends CrudService {

  constructor(@Inject(Http) http?: Http, @Inject(GlobalErrorHandler) handleError?: GlobalErrorHandler) {
    super(http, handleError);
    this.urlAPI = API_ROUTES.DUMMY;
  }

  getMaintenance() {
    return this.http.get(this.urlAPI.GET_MAINTENANCE, {
      headers: this.getHeaders(RequestMethod.Get),
    }).map(response => response.json())
      .catch(super.handleError.bind(this));
  }

  saveMaintenance(object: any) {
    return this.http.post(this.urlAPI.SAVE_MAINTENANCE, JSON.stringify(object), {
      headers: this.getHeaders(RequestMethod.Post),
    }).map(response => response.json())
      .catch(super.handleError.bind(this));
  }

}

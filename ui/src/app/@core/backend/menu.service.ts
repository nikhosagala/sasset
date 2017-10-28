import {GlobalErrorHandler} from '../utils/error.handler';
import {Inject} from '@angular/core';
import {Http, RequestMethod} from '@angular/http';
import {CrudService} from './crud.service';
import {API_ROUTES} from '../utils/routes';
import {Observable} from 'rxjs/Observable';

export class MenuService extends CrudService {
  constructor(@Inject(Http) http?: Http, @Inject(GlobalErrorHandler) handleError?: GlobalErrorHandler) {
    super(http, handleError);
    this.urlAPI = API_ROUTES.APPLICATION;
  }

  public getMenu(): Observable<any> {
    return this.http.get(this.urlAPI.MENU, {
      headers: this.getHeaders(RequestMethod.Get),
    }).map(response => response.json())
      .catch(super.handleError.bind(this));
  }
}

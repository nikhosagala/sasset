import {Inject, Injectable} from '@angular/core';
import {CrudService} from './crud.service';
import {API_ROUTES} from '../utils/routes';
import {Http, RequestMethod, URLSearchParams} from '@angular/http';
import {GlobalErrorHandler} from '../utils/error.handler';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AssetService extends CrudService {

  constructor(@Inject(Http) http?: Http, @Inject(GlobalErrorHandler) handleError?: GlobalErrorHandler) {
    super(http, handleError);
    this.urlAPI = API_ROUTES.ASSET;
  }

  public getSummary(assetType: string): Observable<any> {
    const params: URLSearchParams = new URLSearchParams();
    params.set('assetType', assetType);
    return this.http.get(this.urlAPI.SUMMARY, {
      headers: this.getHeaders(RequestMethod.Get),
      search: params,
    }).map(response => response.json())
      .catch(super.handleError.bind(this));
  }

  public getSummaryDetail(id): Observable<any> {
    return this.http.get(this.urlAPI.SUMMARY_ID + id, {
      headers: this.getHeaders(RequestMethod.Get),
    }).map(response => response.json())
      .catch(super.handleError.bind(this));
  }
}

import {Inject, Injectable} from '@angular/core';
import {Headers, Http, RequestMethod, RequestOptions, URLSearchParams} from '@angular/http';
import {GlobalErrorHandler} from '../utils/error.handler';
import {Observable} from 'rxjs/Observable';

@Injectable()
export abstract class CrudService {

  protected urlAPI: any;

  constructor(@Inject(Http) protected http?: Http,
              @Inject(GlobalErrorHandler) protected handlingError?: GlobalErrorHandler) {
  }

  public save(object): Observable<any> {
    return this.http.post(this.urlAPI.SAVE, JSON.stringify(object), {
      headers: this.getHeaders(RequestMethod.Post),
    }).map(response => response.json())
      .catch(this.handleError.bind(this));
  }

  public update(object): Observable<any> {
    return this.http.put(this.urlAPI.UPDATE, JSON.stringify(object), {
      headers: this.getHeaders(RequestMethod.Put),
    }).map(response => response.json())
      .catch(this.handleError.bind(this));
  }

  public get(filter?, sort?, limit?, offset?): Observable<any> {
    const params: URLSearchParams = new URLSearchParams();

    if (filter) {
      filter = JSON.stringify(filter);
      params.set('filter', filter);
    }

    if (limit && offset) {
      params.set('limit', limit);
      params.set('offset', offset);
    }

    if (sort) {
      params.set('sort', JSON.stringify(sort));
    }

    const options: RequestOptions = new RequestOptions({
      search: params,
      headers: this.getHeaders(RequestMethod.Get),
    });

    return this.http.get(this.urlAPI.GET, options)
      .map(response => response.json())
      .catch(this.handleError.bind(this));
  }

  public find(id: number): Observable<any> {
    return this.http.get(this.urlAPI.GET_ID + id, {
      headers: this.getHeaders(RequestMethod.Get),
    }).map(response => response.json())
      .catch(this.handleError.bind(this));
  }

  public remove(id: number): Observable<any> {
    return this.http.delete(this.urlAPI.DELETE + id, {
      headers: this.getHeaders(RequestMethod.Delete),
    }).map(response => response.json())
      .catch(this.handleError.bind(this));
  }

  public handleError(error: any): Observable<any> {
    this.handlingError.checkAndHandling(error);
    return Observable.throw(error.message || error);
  }

  protected getHeaders(method): Headers {
    const headers = new Headers();
    if (method === RequestMethod.Post || method === RequestMethod.Put) {
      headers.append('Content-Type', 'application/json');
    }
    return headers;
  }
}

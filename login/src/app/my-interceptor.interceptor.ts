import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from "@angular/router";

@Injectable()
export class MyInterceptorInterceptor implements HttpInterceptor {

  constructor(private router : Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const authnReq = request.clone({
      setHeaders: {
        Authorization: 'accessToken'
      }
    });
    return next.handle(authnReq)
  }
}

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginsComponent } from './logins/logins.component';
import { InfoComponent } from './info/info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { zh_CN, en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NzFormModule,  } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { ListComponent } from './list/list.component';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import {MyInterceptorInterceptor} from "./my-interceptor.interceptor";


registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent,
    LoginsComponent,
    ListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzFormModule,
    NzInputModule,
    NzButtonModule,
    ReactiveFormsModule,
    NzTableModule,
    NzDividerModule,
    NzDescriptionsModule
  ],
  providers: [{ provide: NZ_I18N, useValue: zh_CN },{ provide: HTTP_INTERCEPTORS, useClass: MyInterceptorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }

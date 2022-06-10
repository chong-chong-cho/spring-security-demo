import { NgModule } from '@angular/core';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import { InfoComponent } from '../info/info.component';
import { ListRoutingModule } from './list-routing.module';
import { NzRadioModule } from 'ng-zorro-antd/radio';

import { CommonModule } from '@angular/common';


@NgModule({
  declarations: [
    InfoComponent
  ],
  imports: [
    CommonModule,
    ListRoutingModule,
    NzRadioModule,
    NzDescriptionsModule
  ],
})
export class ListModule { }

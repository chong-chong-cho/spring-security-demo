import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './list/list.component';
import { LoginsComponent } from './logins/logins.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'login',component:LoginsComponent,},
  {path:'list',children:[
    {
      path:'',
      loadChildren:()=>import("./list/list.module").then(m=>m.ListModule)
    }
  ], component:ListComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

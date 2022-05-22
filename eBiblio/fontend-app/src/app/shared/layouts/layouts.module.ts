import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardLayoutComponent} from './dashboard-layout/dashboard-layout.component';
import {AuthLayoutComponent} from './auth-layout/auth-layout.component';
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    DashboardLayoutComponent,
    AuthLayoutComponent,

  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutsModule {
}

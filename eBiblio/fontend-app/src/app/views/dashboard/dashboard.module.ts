import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import {DashboardRoutingModule} from "./dashboard-routing.module";
import { DocumentsComponent } from './documents/documents.component';
import { MembersListComponent } from './members-list/members-list.component';



@NgModule({
  declarations: [
    HomeComponent,
    DocumentsComponent,
    MembersListComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }

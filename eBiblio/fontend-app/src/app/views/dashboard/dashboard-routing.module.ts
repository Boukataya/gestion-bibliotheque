import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from "./home/home.component";
import {RouterModule, Routes} from '@angular/router';
import {MembersListComponent} from "./members-list/members-list.component";
import {HasRoleGuard} from "../../shared/guards/has-role.guard";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'members',
    component: MembersListComponent,
    canActivate: [HasRoleGuard],
    data: {
      role: 'ADMIN'
    }
  }

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class DashboardRoutingModule {
}

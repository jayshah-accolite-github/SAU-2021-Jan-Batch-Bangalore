import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './components/add/add.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [

  {path:"home",pathMatch:"full",component:HomeComponent},
  {path:"addWord",pathMatch:"full",component:AddComponent},
  {path: "**", redirectTo:"/home"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

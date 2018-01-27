import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';

import { UsersComponent } from '../users/users.component';
import { LanguagesComponent } from '../languages/languages.component';
import { CourseComponent } from '../course/course.component'

const appRoutes: Routes = [
  { path: '', redirectTo:'cursos', pathMatch:'full'},
  { path: 'usuarios', component: UsersComponent, pathMatch: 'full'},
  { path: 'cursos', component:LanguagesComponent, pathMatch:'full'},
  { path: '**', redirectTo:'cursos', pathMatch:'full'}
  
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class RoutesModuleModule { }

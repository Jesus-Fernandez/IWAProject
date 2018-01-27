import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { OptionsBarComponent } from './options-bar/options-bar.component';
import { UsersComponent } from './users/users.component';
import { LanguagesComponent } from './languages/languages.component';

import { UsersService } from '../services/user/users.service';
import { CourseService } from '../services/course/course.service';

import { RoutesModuleModule } from './routes-module/routes-module.module';

import { HttpClientModule } from '@angular/common/http';
import { TitleBarComponent } from './title-bar/title-bar.component';
import { CourseComponent } from './course/course.component';

@NgModule({
  declarations: [
    AppComponent,
    OptionsBarComponent,
    UsersComponent,
    LanguagesComponent,
    TitleBarComponent,
    CourseComponent
  ],
  imports: [
    RoutesModuleModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [UsersService, CourseService],
  bootstrap: [AppComponent]
})
export class AppModule { }

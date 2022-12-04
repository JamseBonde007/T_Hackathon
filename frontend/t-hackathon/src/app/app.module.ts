import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { LoginPostComponent } from './shared/post-preview/post-preview.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PostDetailComponent } from './main-page/post-detail/post-detail.component';
import { HeaderComponent } from './main-page/header/header.component';
import { AllPostsComponent } from './main-page/all-posts/all-posts.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FindJobComponent } from './main-page/find-job/find-job.component';
import { FindExpertComponent } from './main-page/find-expert/find-expert.component';
import { JobPreviewComponent } from './main-page/find-job/job-preview/job-preview.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPostComponent,
    LoginComponent,
    MainPageComponent,
    PostDetailComponent,
    HeaderComponent,
    AllPostsComponent,
    FindJobComponent,
    FindExpertComponent,
    JobPreviewComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    HttpClientModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

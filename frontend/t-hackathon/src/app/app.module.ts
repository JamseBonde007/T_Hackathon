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

@NgModule({
  declarations: [AppComponent, LoginPostComponent, LoginComponent, MainPageComponent, PostDetailComponent, HeaderComponent, AllPostsComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

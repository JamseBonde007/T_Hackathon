import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { MainPageComponent } from './main-page.component';
import { FormsModule } from '@angular/forms';
import { MainPageRoutingModule } from './main-page-routing.module';
import { LoginPostComponent } from '../shared/component/post-preview/post-preview.component';

@NgModule({
  declarations: [
    MainPageComponent,
    LoginPostComponent
  ],
  imports: [CommonModule, HttpClientModule, FormsModule, MainPageRoutingModule],
  providers: [],
})
export class MainPageModule {}

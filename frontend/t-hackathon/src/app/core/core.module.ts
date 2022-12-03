import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { DataService } from './service/data.service';

@NgModule({
  declarations: [],
  imports: [CommonModule, HttpClientModule],
  providers: [DataService],
})
export class CoreModule {}

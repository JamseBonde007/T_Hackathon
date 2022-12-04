import { Component, Input, OnInit } from '@angular/core';
import { Job } from 'src/app/shared/model/job.model';

@Component({
  selector: 'app-job-preview',
  templateUrl: './job-preview.component.html',
  styleUrls: ['./job-preview.component.scss'],
})
export class JobPreviewComponent implements OnInit {
  @Input() job: Job;
  

  constructor() {}

  ngOnInit(): void {}

  onClickApply() {
    alert('Tvoje CV bolo oodoslane!!!');
  }
}

import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Job } from 'src/app/shared/model/job.model';
import { MainService } from 'src/app/shared/service/main-service.service';

@Component({
  selector: 'app-find-job',
  templateUrl: './find-job.component.html',
  styleUrls: ['./find-job.component.scss'],
})
export class FindJobComponent implements OnInit {
  jobs$: Observable<Job[]> = this.mainService.jobState$;
  allJobsSubs: Subscription;

  skills = [
    'all',
    'plný pracovný úväzok',
    'polovičný pracovný úväzok',
    'stáž',
    'brigáda',
  ];
  selectedSkill = '';

  constructor(private mainService: MainService) {}

  ngOnInit(): void {
    this.allJobsSubs = this.mainService.getAllJobs().subscribe();
    console.log(this.jobs$);
  }

  onRegionChanged() {
    if (this.selectedSkill === 'all') {
      this.allJobsSubs = this.mainService.getAllJobs().subscribe();
      console.log(this.jobs$);
    } else {
      this.allJobsSubs = this.mainService
        .getInterestedJob(this.selectedSkill)
        .subscribe();
      console.log(this.jobs$);
    }
  }
}

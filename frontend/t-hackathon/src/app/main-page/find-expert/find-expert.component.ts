import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Publisher } from 'src/app/shared/model/publisher.model';
import { MainService } from 'src/app/shared/service/main-service.service';

@Component({
  selector: 'app-find-expert',
  templateUrl: './find-expert.component.html',
  styleUrls: ['./find-expert.component.scss']
})
export class FindExpertComponent implements OnInit {

  toppings = new FormControl('');
  skills;

  toppingList: string[] = ['Java', 'Spring boot', 'Angular', 'C', 'React', 'Postgres', 'Docker', 'Ux', 'Ui', 'Git'];


  experts$: Observable<Publisher[]> = this.mainService.expertsState$;
  expertsSubs: Subscription;

  constructor(private mainService: MainService) { }

  ngOnInit(): void {
    this.expertsSubs = this.mainService.getAllExperts().subscribe();
    console.log(this.experts$);
    
  }
  postSkill(){
    this.skills = this.toppings.value;
    console.log('Ahoj');
    
    if(this.skills.length === 0){
      this.expertsSubs = this.mainService.getAllExperts().subscribe();
    }else{
      var str = this.skills.join(); 
      console.log(str );
      this.expertsSubs = this.mainService.getInterestedExperts(str).subscribe();  
    }

    str = ''
  }

}







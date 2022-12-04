import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';




@Component({
  selector: 'app-find-expert',
  templateUrl: './find-expert.component.html',
  styleUrls: ['./find-expert.component.scss']
})
export class FindExpertComponent implements OnInit {

  toppings = new FormControl('');

  toppingList: string[] = ['Java', 'Spring boot', 'Angular', 'C', 'React', 'Postgres', 'Docker', 'Ux', 'Ui', 'Git'];
  constructor() { }

  ngOnInit(): void {
  }


  postSkill(){
    console.log(this.toppings.value);
  }

}







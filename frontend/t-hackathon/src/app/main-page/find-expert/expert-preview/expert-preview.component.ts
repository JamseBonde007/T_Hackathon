import { Component, Input, OnInit } from '@angular/core';
import { Publisher } from 'src/app/shared/model/publisher.model';

@Component({
  selector: 'app-expert-preview',
  templateUrl: './expert-preview.component.html',
  styleUrls: ['./expert-preview.component.scss']
})
export class ExpertPreviewComponent implements OnInit {

  @Input() expert: Publisher
  constructor() { }

  ngOnInit(): void {
  }

  onClickApply(){
    
  }

}

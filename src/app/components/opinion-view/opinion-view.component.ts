import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OpinionService } from 'src/app/services/opinion.service';
import { Opinion } from 'src/interfaces/opinion';

@Component({
  selector: 'app-opinion-view',
  templateUrl: './opinion-view.component.html',
  styleUrls: ['./opinion-view.component.css']
})
export class OpinionViewComponent implements OnInit {
  opinion:Opinion={} as Opinion;
  constructor(private route:ActivatedRoute,private opinionService:OpinionService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params)=>{
      this.opinionService.getOpinionWithId(params['id']).subscribe((opinion)=>(this.opinion=opinion));
    })
  }

}

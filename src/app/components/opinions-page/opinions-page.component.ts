import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OpinionService } from 'src/app/services/opinion.service';
import { Opinion } from 'src/interfaces/opinion';

@Component({
  selector: 'app-opinions-page',
  templateUrl: './opinions-page.component.html',
  styleUrls: ['./opinions-page.component.css']
})
export class OpinionsPageComponent implements OnInit {
  opinions: Opinion[] = [];

  constructor(private opinionService: OpinionService, private router: Router) { }

  ngOnInit(): void {
    this.opinionService.getOpinions().subscribe((opinions) => (this.opinions = opinions));
  }
  navigate(id: number): void {
    this.router.navigate(['opinionview', id])
  }
}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrls: ['./project-card.component.css']
})
export class ProjectCardComponent implements OnInit {
  @Input() project: Project = {} as Project;
  constructor(private router: Router) { }
  ngOnInit(): void {
  }
  navigate(): void {
    this.router.navigate(['projectview', this.project.id]);
  }
}

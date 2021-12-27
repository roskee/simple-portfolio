import { Component, Input, OnInit } from '@angular/core';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrls: ['./project-card.component.css']
})
export class ProjectCardComponent implements OnInit {
  @Input() project: Project = {} as Project;
  constructor() { }

  ngOnInit(): void {
  }

}

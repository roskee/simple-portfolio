import { Component, OnInit } from '@angular/core';
import { AboutService } from 'src/app/services/about.service';
import { Skill } from 'src/interfaces/skill';

@Component({
  selector: 'app-skills-page',
  templateUrl: './skills-page.component.html',
  styleUrls: ['./skills-page.component.css']
})
export class SkillsPageComponent implements OnInit {
  skills: Skill[] = [];
  constructor(private skillsService: AboutService) { }

  ngOnInit(): void {
    this.skillsService.getSkills().subscribe((skills) => (this.skills = skills));
  }
  viewImage(url: string): void {
    window.open("http://localhost:5000/" + url, "_blank")
  }
}

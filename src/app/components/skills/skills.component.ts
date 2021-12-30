import { Component, OnInit } from '@angular/core';
import { AboutService } from 'src/app/services/about.service';
import { Company } from 'src/interfaces/company';
import { Skill } from 'src/interfaces/skill';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skills: Skill[] = [];
  companies: Company[] = [];
  constructor(private skillService: AboutService) { }

  ngOnInit(): void {
    this.skillService.getSkills().subscribe((skills) => (this.skills = skills));
    this.skillService.getCompanies().subscribe((companies) => (this.companies = companies));
  }

}

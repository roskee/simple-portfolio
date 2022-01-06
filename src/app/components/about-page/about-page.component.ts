import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AboutInfo } from 'src/interfaces/aboutInfo';
import { Skill, Certificate } from 'src/interfaces/skill';
import { AboutService } from '../../services/about.service';
@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent implements OnInit {
  aboutInfo: AboutInfo = {} as AboutInfo;
  topCertificates: Certificate[] = [];
  constructor(private router: Router, private aboutService: AboutService) { }

  ngOnInit(): void {
    this.aboutService.getAboutInfo().subscribe((aboutInfo) => (this.aboutInfo = aboutInfo));
    //TODO: Temporary
    this.aboutService.getSkills().subscribe((skills) => {
      for (let skill of skills) {
        for (let certi of skill.certificates)
          if (certi.topCertificate)
            this.topCertificates.push(certi);
      }
    });
  }
}

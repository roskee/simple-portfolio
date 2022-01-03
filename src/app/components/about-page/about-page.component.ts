import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AboutInfo, Certificate } from 'src/interfaces/aboutInfo';
import { Skill } from 'src/interfaces/skill';
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
    this.aboutService.getTopCertificates().subscribe((topCertificates)=>(this.topCertificates = topCertificates));
  }
}

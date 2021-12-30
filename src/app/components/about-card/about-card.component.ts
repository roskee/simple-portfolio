import { Component, OnInit } from '@angular/core';
import { AboutService } from 'src/app/services/about.service';
import { AboutInfo } from 'src/interfaces/aboutInfo';

@Component({
  selector: 'app-about-card',
  templateUrl: './about-card.component.html',
  styleUrls: ['./about-card.component.css']
})
export class AboutCardComponent implements OnInit {
  aboutInfo: AboutInfo = {} as AboutInfo;
  constructor(private aboutService: AboutService) { }

  ngOnInit(): void {
    this.aboutService.getAboutInfo().subscribe((aboutInfo) => (this.aboutInfo = aboutInfo));
  }

}

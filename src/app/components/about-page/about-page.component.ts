import { Component, OnInit } from '@angular/core';
import { AboutInfo } from 'src/interfaces/aboutInfo';
import { AboutService } from '../../services/about.service';
@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent implements OnInit {
  aboutInfo:AboutInfo = {} as AboutInfo;
  constructor(private aboutService: AboutService) { }

  ngOnInit(): void {
    this.aboutService.getAboutInfo().subscribe((aboutInfo)=>(this.aboutInfo = aboutInfo));
  }

}

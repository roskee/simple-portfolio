import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentUrl: string = '/';
  subscription$
  constructor(private location: Location) {
    this.subscription$ = location.onUrlChange((url) => {
      this.currentUrl = url;
    });
  }

  ngOnInit(): void {
  }
  onSearchClick() {
    console.log('hi from header');
  }
}

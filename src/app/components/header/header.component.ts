import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title: string = 'Task Tracker'
  constructor() { }

  ngOnInit(): void {
  }
  onSearchClick() {
    console.log('hi from header');
  }
}

import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  h1Style = false;

  constructor(private data: DataService) { }

  ngOnInit() {
  }
  firstClick() {
    this.data.firstClick();
  }
}

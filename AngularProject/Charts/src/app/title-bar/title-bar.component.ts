import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';

declare var $:any;

@Component({
  selector: 'app-title-bar',
  templateUrl: './title-bar.component.html',
  styleUrls: ['./title-bar.component.css']
})
export class TitleBarComponent implements OnInit {


  @Input() titulo:string;


  constructor() { }

  ngOnInit() {
    $("#menu").click(function(){
      $("#sidecol").css("width", "20em");
    });
  }

}

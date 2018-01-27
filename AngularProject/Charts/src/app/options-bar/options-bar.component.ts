import { Component, OnInit } from '@angular/core';

import * as d3 from 'd3';

declare var $:any;
@Component({
  selector: 'app-options-bar',
  templateUrl: './options-bar.component.html',
  styleUrls: ['./options-bar.component.css']
})
export class OptionsBarComponent implements OnInit {


  public options = [{name: "Cursos", url:"/cursos"}, {name:"Usuarios", url:"/usuarios"}];
  private data:any;
  constructor() { 
    this.data = [
      {x:0, y:200},
      {x:30, y:200},
      {x:50, y:100},
      {x:70, y:200},
      {x:90, y:50},
      {x:130, y:250},
      {x:150, y:200},
      {x:170, y:200}   
      
    ];
  }

  ngOnInit() {
    $("#menu-op").click(function(){
      $(".sidecol").css("width","0");
    });
    $(window).resize(function(){
      $(".sidecol").css("width","");
    });
    let w = 200;
    let h = 300;
    let line = d3.line()
              .x(function(d){return d.x})
              .y(function(d){return d.y});


    let svg = d3.select("#figura").append("svg")
            .attr("width",w)
            .attr("height",h);

          svg.append("path")
          .attr("d", line(this.data))
          .attr("stroke", "#2274ac")
          .attr("stroke-width", 10)
          .attr("fill","#33434c");
  }

}

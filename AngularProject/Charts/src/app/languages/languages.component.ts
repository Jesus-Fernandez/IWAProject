import { Component, OnInit, ElementRef } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { CourseService } from '../../services/course/course.service';
import { UsersService } from '../../services/user/users.service';
import { Chart } from 'chart.js';

declare var jQuery:any;
declare var $:any;

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css']
})
export class LanguagesComponent implements OnInit {

  public courses:any;
  public users:any;
  public chart:Chart;
  private alumnos=[];
  private cursos=[];

  private deportes:any;
  private frutas:any;
  

  constructor(private courseService:CourseService, private userService: UsersService, private elementRef: ElementRef, private router:Router) { 
        
        this.deportes = {af: 0, sc: 0, bb:0, tn: 0};
        this.frutas = {b: 0, a:0, s:0}
        
  }

  private pieChart(){
        this.users.forEach(u=>{
            switch(u.favoriteSport){
                case 'american football':
                    this.deportes.af = this.deportes.af +1;
                break;
                case 'soccer':
                    this.deportes.sc = this.deportes.sc +1;
                break;
                case 'basketball':
                    this.deportes.bb = this.deportes.bb +1;
                break;
                case 'tennis':
                    this.deportes.tn = this.deportes.tn +1;
                break;
            }
        });
        var ctx = this.elementRef.nativeElement.querySelector(`#deportes`);
    this.chart = new Chart(ctx, {
    type: 'pie',
    data: {
        datasets: [{
            data: [
                (this.deportes.af*100)/this.users.length,
                (this.deportes.sc*100)/this.users.length,
                (this.deportes.bb*100)/this.users.length,
                (this.deportes.tn*100)/this.users.length,
            ],
            backgroundColor: [
                'rgba(0, 177, 235,1)',
                'rgba(234,79,68,1)',
                'rgba(81,174,48,1)',
                'rgba(0,87,167,1)'
            ],
            label: 'Dataset 1'
        }],
        labels: [
            "Football",
            "Soccer",
            "Basketball",
            "Tennis"
        ]
    },
    options: {
        responsive: true
    }
});
  }

  private doughnutChart(){
        this.users.forEach(u=>{
            switch(u.favoriteFruit){
                case 'apple':
                    this.frutas.a = this.frutas.a +1;
                break;
                case 'banana':
                    this.frutas.b = this.frutas.b +1;
                break;
                case 'strawberry':
                    this.frutas.s = this.frutas.s +1;
                break;
            }
        });
        var ctx = this.elementRef.nativeElement.querySelector(`#frutas`);
        this.chart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [
                    (this.frutas.a*100)/3,
                    (this.frutas.b*100)/3,
                    (this.frutas.s*100)/3
                ],
                backgroundColor: [
                    'rgba(0, 177, 235,1)',
                    'rgba(234,79,68,1)',
                    'rgba(81,174,48,1)'
                ],
                label: 'Dataset 1'
            }],
            labels: [
                "Manzana",
                "Platano",
                "Fresa"
            ]
        },
        options: {
            responsive: true
        }
    });
  }

  private elementosCursos(){
        this.courses.forEach(element => {
            this.alumnos.push(element.users.length);          
           });
           this.courses.forEach(element => {
               this.cursos.push(element.id);          
              });
              var ctx = this.elementRef.nativeElement.querySelector(`#cursos`);
              this.chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: this.cursos,
                    datasets: [{
                        label: null,
                        data: this.alumnos,
                        backgroundColor: [
                            'rgba(0, 177, 235,1)',
                            'rgba(234,79,68,1)',
                            'rgba(81,174,48,1)',
                            'rgba(0,87,167,1)',
                            'rgba(115,0,153,1)'
                        ],
                        borderColor: [
                            'rgba(0, 177, 235,1)',
                            'rgba(234,79,68, 1)',
                            'rgba(81,174,48, 1)',
                            'rgba(0,87,167, 1)',
                            'rgba(115,0,153, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero:true
                            }
                        }]
                    },
                    legend:false
                }
            });
    
    
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(data=>{
        this.users = data;
        this.pieChart();  
        this.doughnutChart(); 
    });
    this.courseService.getCourses().subscribe(data=>{
        this.courses = data;
        this.elementosCursos();
        let color = [
            'rgb(0, 177, 235)',
            'rgb(234,79,68)',
            'rgb(81,174,48)',
            'rgb(0,87,167)',
            'rgb(115,0,153)'
        ];
        this.courses.forEach((e,i)=>{
            e['color'] = color[i];
        });
        //console.log(this.courses);
    });
    
    
   
  
  }

}

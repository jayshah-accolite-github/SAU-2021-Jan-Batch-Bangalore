import { Component, OnInit } from '@angular/core';
import {SessionModel} from "../../models/SessionModel"
@Component({
  selector: 'app-sessions',
  templateUrl: './sessions.component.html',
  styleUrls: ['./sessions.component.css']
})
export class SessionsComponent implements OnInit {

  sessions!: SessionModel[];
  addTemplateToggleValue:boolean=false;
  addName:string="";
  addTrainer:string="";
  addDate:Date=new Date();
  editTemplateToggleValue:boolean=false;
  editName:string="";
  editTrainer:string="";
  editDate:Date=new Date();
  editId!:number;
  constructor() { }

  ngOnInit(): void {
    this.sessions=[
      new SessionModel("Git","Jay shah", new Date(1995, 11, 17) ),
      new SessionModel("Html","Ajay shah", new Date(2021, 11, 17) )
    ]
  }
  toggleDetails(id:number){
this.sessions.map((v,i)=>{
if(i==id) v.details=!v.details;
return v;
})
  }
  toggleAdd():void{
    this.addTemplateToggleValue=!this.addTemplateToggleValue;
  }
  addSessionList():void{
    this.sessions.push(new SessionModel(this.addName,this.addTrainer,this.addDate));
    this.addName="";
    this.addTrainer="";
    this.addDate=new Date();
    this.addTemplateToggleValue=false;
  }
  editSessionList():void{
    if(this.editId!==-1)
    {this.sessions.map((v,i)=>{
      
      if(i==this.editId) 
      {

        this.sessions[i].sessionName=this.editName;
        this.sessions[i].date=this.editDate;
        this.sessions[i].trainer=this.editTrainer;
       this.closeSessionList();
     } })}
    
   }
   closeSessionList(){
    this.editName="";
    this.editTrainer="";
    this.addDate=new Date();
    this.editTemplateToggleValue=false;
    this.editId=-1;
   }
  deleteSession(id:number):void{
    this.sessions.map((v,i)=>{
      if(i==id) this.sessions.splice(i,1);
    })
  }
  toggleSessionEdit(sessionObj:SessionModel,id:number):void{
    this.editName=sessionObj.sessionName;
    this.editDate=sessionObj.date;
    this.editTrainer=sessionObj.trainer;
    this.editId=id;
    this.editTemplateToggleValue=true;
  }
      
}

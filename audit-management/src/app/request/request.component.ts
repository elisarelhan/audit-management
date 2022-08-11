import { Component, OnInit} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { map, toArray } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';





@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent {
  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router) {}
 

  types = ['Internal', 'Other'];
  answers=['Yes','No'];
  request = {
    projectName: '',
    projectManagerName: '',
    applicationOwnerName: '',
    auditDetails:{
      auditType: '',
      auditQuestions:0
    }
    
  };
  checklist:String[]=[];
  //   answer1:'',
  //   answer2:'',
  //   answer3:'',
  //   answer4:'',
  //   answer5:''
  // };
 errorMessage='';
  submitted = false;
   questions=[];
   showTable: boolean = false;
   
  

// handleChange(value:any){
//   console.log(value.audittype);
// }
showTableOnSelection()
{
  this.showTable=true;
}

  getChecklist(value: any) {
    console.log(value)
    
    const headers= new HttpHeaders()
    .set('Authorization','Bearer '+ JSON.parse(localStorage.getItem('userData')||'{}')._token);
  this.request.auditDetails.auditType = value.audittype;
    
    this.http
    .get<any>('http://localhost:8002/audit-checklist/AuditCheckListQuestions'+'/'+ this.request.auditDetails.auditType,{ 'headers': headers })
    .pipe(map(response=>{
      this.questions=response;
    }))
    
    .subscribe((res)=>
    { 
      console.log(this.questions);
      this.showTableOnSelection();
    }
    ,(error) => {                              //Error callback
      console.error('error caught in component')
      this.errorMessage = error;
      

      //throw error;   //You can also throw the error to a global error handler
    });
    
    console.log(this.showTable);
  }

  onSubmit(form:NgForm)
  {
    console.log(this.submitted);
    this.submitted=true;
    this.request.projectName = form.value.projectname;
    this.request.projectManagerName = form.value.projectmanagername;
    this.request.applicationOwnerName = form.value.appowner;
    this.request.auditDetails.auditType = form.value.audittype;
    this.checklist.push(form.value.answer1);
    this.checklist.push(form.value.answer2);
    this.checklist.push(form.value.answer3);
    this.checklist.push(form.value.answer4);
    this.checklist.push(form.value.answer5);
console.log(this.checklist);
console.log(this.request.auditDetails.auditQuestions);
let count=0;
    for(let i in this.checklist)
    {
      console.log(i);
     
      if(this.checklist[i]==="No")
      {
        
        count=count+1;      
      }
      else{
        continue;
      }
      this.request.auditDetails.auditQuestions=count;
     
  
    }
    console.log(this.request);
   

    this.router.navigate(['response'],{state:{request: this.request}});
    
    
  }
}
  


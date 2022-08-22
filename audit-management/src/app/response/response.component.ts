import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Data, Params, Router } from '@angular/router';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.css']
})
export class ResponseComponent implements OnInit {
  request= {
    projectName: '',
    projectManagerName: '',
    applicationOwnerName: '',
    auditDetails: {
      auditType: '',
      auditQuestions: 0
    }
  };
  responseAvailable=false;
  response={
    responseId:'',
    projectExecStatus:'',
    actionDuration:''

  };
  errorMessage='';
  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router) {}
  ngOnInit() {
   this.request=history.state.request;
    this.getResponseData();
  }
  getResponseData(){
    
    
    const headers= new HttpHeaders()
  .set('Authorization','Bearer '+ JSON.parse(localStorage.getItem('userData')||'{}')._token);

    console.log(this.request);
    console.log(headers);
      this.http.post<any>('http://902477-lb1-1148941390.us-west-2.elb.amazonaws.com/api/severity/audit-severity/ProjectExecutionStatus', this.request, {headers :headers}).subscribe(data => {
        this.response = data;
        console.log(this.response);
        this.responseAvailable=true;
    }
    ,(error) => {                              //Error callback
      console.error('error caught in component')
      this.errorMessage = error;
    

      //throw error;   //You can also throw the error to a global error handler
    })
    {

    }
   
  }

}

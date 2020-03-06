import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Router } from '@angular/router';
import { LoginService } from '../../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  role: string;
  errorMessage: string;
  currentBuyer: any;

  constructor(protected emartService: EmartService,
              protected loginService: LoginService,
              protected router: Router) { }

  ngOnInit(): void {
    this.errorMessage = '';
  }
  validate(){
    if(this.role == 'buyer'){
        this.emartService.validateBuyer(this.username, this.password).subscribe((response)=> 
                                                {
                                                  this.currentBuyer = response;
                                                  this.emartService.setBuyer(this.currentBuyer);
                                                  this.emartService.setAllBills(this.currentBuyer.allBills);
                                                    
                                                  
                                                  if(this.currentBuyer.buyerId != 0){
                                                    
                                                    this.loginService.loginBuyer(this.currentBuyer);
                                                    this.loginService.loggedIn();
                                                    
                                                    this.router.navigate(['item-list']);
                                                  }
                                                  else{
                                                    this.errorMessage = "Invalid Username/Password";
                                                  }

                                                }
          );
    }
    if(this.role == 'seller'){
      let result = this.emartService.validateSeller(this.username, this.password);
      
      // if(result != null){
      //   this.loginService.loginSeller(result);
      //   this.router.navigate(['item-list']);
      // }
      // else{
      //   this.errorMessage = "Invalid Username/Password";
      // }


    }
  }
}

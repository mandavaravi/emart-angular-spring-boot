import { Injectable } from '@angular/core';
import { Buyer } from './buyer';
import { EmartService } from './emart.service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  buyer: any;
  cartItems : any;
  logged : boolean;
  constructor(protected emartService:EmartService) { 
    this.logged = false;
  }


  loginBuyer(buyer: Buyer){
    this.buyer = buyer;
  }

  logout(){
    this.buyer = null;
    this.emartService.setBuyer(this.buyer);
    this.emartService.setAllBills([]);
    this.emartService.setAllCart([]);
    this.loggedOut();
    this.isLogged();
  }

  isLogged(){
    return this.logged;
  }

  loggedIn(){
    this.logged = true;
  }

  loggedOut(){
    this.logged = false;
  }
}

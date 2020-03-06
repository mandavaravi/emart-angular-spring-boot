import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmartService {

  cartItems: any;
  allBills: any ;
  currentBuyer : any = null;
  
  constructor(protected http: HttpClient) { 
    this.cartItems = [];
    this.allBills = [];
  }

  setBuyer(currentBuyer: any) {
    this.currentBuyer = currentBuyer;
  }

  getCurrentBuyer(){
    return this.currentBuyer;
  }

  setAllBills(billsList: any){
    this.allBills = billsList;
  }

  getAllBills():any{
    return this.allBills;
  }

  getAllItems():any{
    return this.http.get('http://localhost:8097/emart/item/all');
  }

  
  getItem(itemId: string):any{
    
    return this.http.get('http://localhost:8097/emart/item/'+itemId);
  }

  addToCart(itemObj: any){
   this.cartItems.push(itemObj);
  }

  getAllCart(){
    return [].concat(this.cartItems);
  }

  setAllCart(cartItems: any){
    this.cartItems = cartItems;
  }

  deleteCartItem(itemNo: number){
    let size = this.cartItems.length;
    for(let i=0;i<size;i++){
      if(this.cartItems[i].itemId==itemNo){
        this.cartItems.splice(i,1);
        break;
      }
    }
    return [].concat(this.cartItems);
  }

  addBill( todayDate: Date, total: number){
    let allBillDetails: any = [];
    for(let i=0;i<this.cartItems.length; i++){
        allBillDetails.push({
          billDetailsId : 0,
          bill : null,
          item : this.cartItems[i]
        });
    }

    let bill: any = {
      billId: 0,
      billType : 'Credit',
      billDate : todayDate,
      billRemarks : 'Paid',
      billAmount : total,
      buyer: {
        buyerId : this.getCurrentBuyer().buyerId
      },
      allBillDetails : allBillDetails
    }
    this.cartItems = [];
    allBillDetails = [];
    return this.http.post("http://localhost:8097/emart/addBill", bill);
  }

  validateBuyer(user: string, password: string){

    let uData = user + ":" + password;
    let headers  = new HttpHeaders();
    headers  =  headers.set('Authorization', uData);
    return this.http.get('http://localhost:8097/emart/validate', {headers});
  }

  validateSeller(user: string, password: string){
    
  }
}

import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  allItems: any;
  currentBuyer: any;
  constructor(protected emartService: EmartService,
              protected router:Router) { }

  ngOnInit(): void {
    this.emartService.getAllItems().subscribe((response)=> {
      this.allItems = response;
    }
);

  }

  displayItemDetails(itemId: number){
    this.router.navigate(['/item-display/'+itemId]);
  }

  addToCart(item: any){
    this.emartService.addToCart(item);
  }
}

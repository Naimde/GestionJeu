import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder} from '@angular/forms';

import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { Personnage } from 'src/app/models/game.service';

import { OrgaApiService } from 'src/app/api/orga-api.service';

@Component({
  selector: 'app-orga-personnage',
  templateUrl: './orga-personnage.component.html',
  styleUrls: ['./orga-personnage.component.scss']
})
export class OrgaPersonnageComponent implements OnInit {
  productDialog!: boolean;

  products!: Personnage[];

  product!: Personnage;

  selectedProducts!: Personnage[];

  submitted!: boolean;

  statuses!: any[];

  constructor(
    private api: OrgaApiService, private formbuilder:UntypedFormBuilder, private messageService: MessageService, private confirmationService: ConfirmationService
  ) {
  }

  ngOnInit() {
    this.api.getAllPersonnage(localStorage.getItem("jeu")!).subscribe(data => this.products = data);

    this.statuses = [
        {label: 'INSTOCK', value: 'instock'},
        {label: 'LOWSTOCK', value: 'lowstock'},
        {label: 'OUTOFSTOCK', value: 'outofstock'}
    ];
  }

  openNew() {
    this.product = new Personnage();
    this.submitted = false;
    this.productDialog = true;
  }

  deleteSelectedProducts() {
    this.confirmationService.confirm({
        message: 'Are you sure you want to delete the selected products?',
        header: 'Confirm',
        icon: 'pi pi-exclamation-triangle',
        accept: () => {
            this.products = this.products.filter(val => !this.selectedProducts.includes(val));
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Products Deleted', life: 3000});
        }
    });
  }

  editProduct(product: Personnage) {
    this.product = {...product};
    this.productDialog = true;
  }

  deleteProduct(product: Personnage) {
    this.confirmationService.confirm({
        message: 'Are you sure you want to delete ' + product.nom + '?',
        header: 'Confirm',
        icon: 'pi pi-exclamation-triangle',
        accept: () => {
            this.products = this.products.filter(val => val.id_personnage !== product.id_personnage);
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Deleted', life: 3000});
        }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;

    if (this.product.id_personnage.trim()) {
        if (this.product.id_personnage) {
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Updated', life: 3000});
        }
        else {
            this.product.info_public = 'product-placeholder.svg';
            this.products.push(this.product);
            this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Created', life: 3000});
        }

        this.products = [...this.products];
        this.productDialog = false;
    }
  }

}
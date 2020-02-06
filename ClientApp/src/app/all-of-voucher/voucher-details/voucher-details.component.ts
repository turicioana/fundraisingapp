import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VoucherService } from 'src/app/voucher.service';

@Component({
  selector: 'app-voucher-details',
  templateUrl: './voucher-details.component.html',
  styleUrls: ['./voucher-details.component.scss']
})
export class VoucherDetailsComponent implements OnInit {

  public company = {
    name: '',
    address: '',
    contact_email: '',
    phone_number: ''
  }

  public fundraiser = {
    id:'',
    title:'',
    description: '',
    address: '',
    contact_email: '',
    phone_number: '',
    category: ''
  };

  public voucher = {
    id: '',
    type: '',
    purpose: '',
    number: 0,
    company: this.company,
    fundraiser: this.fundraiser
  };

  constructor(
    private route: ActivatedRoute,
    private voucherService: VoucherService
  ) { }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    this.voucherService.getVoucher(id).subscribe(
      data => this.voucher = data
    );
  }

}

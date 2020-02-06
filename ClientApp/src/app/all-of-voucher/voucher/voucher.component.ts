import { Component, OnInit } from '@angular/core';
import { VoucherService } from 'src/app/voucher.service';
import { Voucher } from 'src/app/models/voucher';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-voucher',
  templateUrl: './voucher.component.html',
  styleUrls: ['./voucher.component.scss']
})
export class VoucherComponent implements OnInit {

  public vouchersObservable: Observable<Voucher[]>;

  constructor(
    private voucherService: VoucherService
  ) {
    this.vouchersObservable = this.voucherService.getAllVouchers();
   }

  ngOnInit() {
  }

}

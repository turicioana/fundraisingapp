import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FundraiserService } from '../../fundraiser.service';

@Component({
  selector: 'app-voucher-form',
  templateUrl: './voucher-form.component.html',
  styleUrls: ['./voucher-form.component.scss']
})
export class VoucherFormComponent implements OnInit {

  voucherForm: FormGroup;
  loading = false;
  submitted =  false;
  returnUrl: string = '/vouchers';
  public id;
  public types: string[] = ['Free', '5%', '10%', '15%','20%'];



  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private fundraiserService: FundraiserService,
    ) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.voucherForm =  this.formBuilder.group({
      type: ['', Validators.required],
      purpose:['', [Validators.required, Validators.maxLength(200)]],
      number:['', [Validators.required, Validators.maxLength(3)]],
  });
  }
  get fval() {return this.voucherForm.controls;}

  onFormSubmit(){
    this.submitted = true;
    if(this.voucherForm.invalid){
        return;
    }
    this.loading =  true;
    this.fundraiserService.addVoucherForFundraiser(this.id,this.voucherForm.value)
    .subscribe(
        (data) => {
          alert('Vocuher successfully added!');
        this.router.navigateByUrl('/vouchers');
        this.voucherForm.reset();
      }
    );
  } 

}

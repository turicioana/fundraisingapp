import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { FundraiserService } from '../fundraiser.service';

@Component({
  selector: 'app-donation-form',
  templateUrl: './donation-form.component.html',
  styleUrls: ['./donation-form.component.scss']
})
export class DonationFormComponent implements OnInit {

  donationForm: FormGroup;
  loading = false;
  submitted =  false;
  returnUrl: string = '/home/fundraisers';
  public id;


  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private fundraiserService: FundraiserService,
    ) {}

  ngOnInit() {
    console.log("init form")
    this.id = this.route.snapshot.paramMap.get('id');
    this.donationForm =  this.formBuilder.group({
      amount: ['', Validators.required]
  });
  }
  get fval() {return this.donationForm.controls;}

  onFormSubmit(){
    this.submitted = true;
    if(this.donationForm.invalid){
        return;
    }
    this.loading =  true;
    this.fundraiserService.addDonatioForFundraiser(this.id,this.donationForm.value)
    .subscribe(
        (data) => {
          alert('Thank you for your donation!');
        this.router.navigateByUrl('/home/fundraisers');
        this.donationForm.reset();
      }
    );
  } 

}

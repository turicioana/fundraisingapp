import { Component, OnInit, SecurityContext } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FundraiserService } from '../../fundraiser.service';
import * as jwt_decode from 'jwt-decode';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';


@Component({
  selector: 'app-fundraiser-details',
  templateUrl: './fundraiser-details.component.html',
  styleUrls: ['./fundraiser-details.component.scss']
})
export class FundraiserDetailsComponent implements OnInit {
  public images: string[] = [];
  public decodedImages: SafeResourceUrl[] = [];

  public fundraiser = {
    id:'',
    title:'',
    description: '',
    address: '',
    contact_email: '',
    phone_number: '',
    category: '',
  };
  public currentUser;


  constructor(private route: ActivatedRoute,
    private fundraiserService: FundraiserService,
    private sanitizer: DomSanitizer) {
     }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');

    this.fundraiserService.getFundraiser(id).subscribe(
      data => {this.fundraiser = data;
              this.images = data['images'];
              this.decodedImages = this.decodeImages();
      }
    );
  }

  decodeImages(){
    var images1: SafeResourceUrl[] = [];
    this.images.forEach(image => {
      images1.push(this.sanitizer.sanitize(SecurityContext.RESOURCE_URL, this.sanitizer.bypassSecurityTrustResourceUrl(image)))
    });
    return images1;
  }

  hasRole(role: string){
    this.currentUser = JSON.parse(localStorage.getItem('token'));
    if(this.currentUser){
      var decode = jwt_decode(this.currentUser);
      if(role.indexOf(decode['roles'][0]['authority']) == -1){
        return false
      }
      return true;
    }
    return false;
  }

}

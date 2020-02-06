import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { FundraiserService } from '../../fundraiser.service';
import { Observable } from 'rxjs';
import { CategoryService } from '../../category/category.service';

import { Category } from '../../models/category';
import { FileUploader } from 'ng2-file-upload';

@Component({
  selector: 'app-fundraiser-form',
  templateUrl: './fundraiser-form.component.html',
  styleUrls: ['./fundraiser-form.component.scss']
})
export class FundraiserFormComponent implements OnInit {
  fundraiserForm: FormGroup;
  loading = false;
  submitted =  false;
  returnUrl: string = '/fundraisers';
  images: string[];

  public uploader:FileUploader = new FileUploader({
    isHTML5: true
  });

  public categoriesObservable: Observable<Category[]>;

  constructor(
    private formBuilder : FormBuilder,
    private router: Router,
    private fundraiserService: FundraiserService,
    private categoryService: CategoryService,
  ) {
    this.categoriesObservable = this.categoryService.getAllCategories();
   }

  ngOnInit() {
    this.fundraiserForm =  this.formBuilder.group({
      title: ['', Validators.required],
      description:['', [Validators.required, Validators.maxLength(200)]],
      address:['',  Validators.maxLength(100)],
      contact_email:['', Validators.email],
      phone_number:[''],
      category:[''],
      amount:['',Validators.required],
      images: ['', Validators.required]
  });
  }
  get fval() {return this.fundraiserForm.controls;}

  onFormSubmit(){
    this.submitted = true;
    if(this.fundraiserForm.invalid){
        return;
    }
    this.loading =  true;
    Promise.all(this.getImages()).then((images_b64: string[]) => {
      this.fundraiserForm.value['images'] = images_b64;
      this.fundraiserService.addFundraiser(this.fundraiserForm.value)
      .subscribe(
          (data) => {
            alert('Fundraiser successfully added!');
          this.router.navigateByUrl('/home/fundraisers');
          this.fundraiserForm.reset();
        }
      );
      }
    );
  }
    
  getImage(file: File) {
    return new Promise<string>((resolve) => {
      var myReader: FileReader =  new FileReader();
      myReader.onloadend = (e) => {
        resolve(myReader.result as string)
      };
      myReader.readAsDataURL(file);
    });
  }

  getImages() {
    var images: Promise<string>[] = [];
    for (let j = 0; j < this.uploader.queue.length; j++) {
      var file: File = this.uploader.queue[j]._file;
      if(file.size > 10000000){
        alert("Each file should be less than 10 MB of size.");
        return;
      }
      images.push(this.getImage(file))
    }
    return images
  }
  }
  
  // readImage(){
  //   var file:File = this.fundraiserForm.get('images').value.files[0];
  //   console.log(file);
  //   var myReader:FileReader = new FileReader();
  
  //   myReader.onloadend = (e) => {
  //     this.fundraiserForm.patchValue({
  //       'images': myReader.result
  //     })
  //     console.log(this.fundraiserForm.get('images').value)
  //   }
  //   myReader.readAsDataURL(file);
  // }

  // onFileChange(event, field) {
  //   if (event.target.files && event.target.files.length) {
  //     const [file] = event.target.files;
  //     // just checking if it is an image, ignore if you want
  //     if (!file.type.startsWith('image')) {
  //       this.fundraiserForm.get(field).setErrors({
  //         required: true
  //       });
  //       this.changeDetector.markForCheck();
  //     } else {
  //       // unlike most tutorials, i am using the actual Blob/file object instead of the data-url
  //       this.fundraiserForm.patchValue({
  //         [field]: file
  //       });
  //       // need to run CD since file load runs outside of zone
  //       this.changeDetector.markForCheck();
  //     }
  //   }
  // }
  // getErrorMessage() {
  //   return this.title.hasError('required') ? 'You must enter a value' :
  //           '';
  // }


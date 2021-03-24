import { Component, OnInit, ViewChild } from '@angular/core';
import { RestClientService } from '../../service/rest-client.service';
import { Editorial } from '../../service/class/editorial';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editorial-create',
  templateUrl: './editorial-create.component.html',
  styleUrls: ['./editorial-create.component.css']
})
export class EditorialCreateComponent implements OnInit {

  @ViewChild('createForm', { static: true })
  createForm;

  submitted = false;
  errorMessage = '';

  editorial: Editorial = new Editorial(
    undefined,
    undefined,
    undefined,
    undefined,
    undefined,
    undefined
  );

  constructor(
    private router: Router,
    private restClient: RestClientService
  ) { }

  ngOnInit(): void {
  }

  create() {
    this.submitted = true;
    this.restClient.createEditorial(this.editorial).subscribe(
      result => {
        console.log(result);
        this.router.navigate(['/']);
      },
      error => {
        console.error(error);
        this.errorMessage = error.toString();
        this.submitted = false;
      }
    );
  }

  cancel(): void {
    this.router.navigate(['/']);
  }

  get canSubmit() {
    return !this.submitted;
  }
  

}

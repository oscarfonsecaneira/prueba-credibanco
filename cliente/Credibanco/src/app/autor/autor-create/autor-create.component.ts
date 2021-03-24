import { Component, OnInit, ViewChild } from '@angular/core';
import { Autor } from '../../service/class/autor';
import { Router } from '@angular/router';
import { RestClientService } from '../../service/rest-client.service';

@Component({
  selector: 'app-autor-create',
  templateUrl: './autor-create.component.html',
  styleUrls: ['./autor-create.component.css']
})
export class AutorCreateComponent implements OnInit {

  @ViewChild('createForm', { static: true })
  createForm;

  submitted = false;
  errorMessage = '';

  autor: Autor = new Autor(
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
    if (this.autor.fecha_nacimiento != undefined){
      var splitted = this.autor.fecha_nacimiento.split("-", 3);
      this.autor.fecha_nacimiento = splitted[2] + "-" + splitted[1] + "-" + splitted[0];
    }
    
    console.log(this.autor);
    this.submitted = true;
    this.restClient.createAutor(this.autor).subscribe(
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

import { Component, OnInit, ViewChild } from '@angular/core';
import { Libro } from '../../service/class/libro';
import { Router } from '@angular/router';
import { RestClientService } from '../../service/rest-client.service';

@Component({
  selector: 'app-libro-create',
  templateUrl: './libro-create.component.html',
  styleUrls: ['./libro-create.component.css']
})
export class LibroCreateComponent implements OnInit {

  @ViewChild('createForm', { static: true })
  createForm;

  submitted = false;
  errorMessage = '';

  libro: Libro = new Libro(
    undefined,
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
    this.restClient.createLibro(this.libro).subscribe(
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
    this.libro.id = undefined;
    this.libro.titulo = undefined;
    this.libro.anio = undefined;
    this.libro.genero = undefined;
    this.libro.numero_paginas = undefined;
    this.libro.editorial_id = undefined;
    this.libro.autor_id = undefined;
  }

  cancel(): void {
    this.router.navigate(['/']);
  }

  get canSubmit() {
    return !this.submitted;
  }

}

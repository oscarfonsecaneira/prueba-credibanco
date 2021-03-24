import { Component, OnInit } from '@angular/core';
import { Editorial } from 'src/app/service/class/editorial';
import { Libro } from 'src/app/service/class/libro';
import { Libroinf } from 'src/app/service/class/libroinf';
import { Autor } from '../../service/class/autor';
import { ActivatedRoute, Router } from '@angular/router';
import { RestClientService } from '../../service/rest-client.service';

@Component({
  selector: 'app-libro-search',
  templateUrl: './libro-search.component.html',
  styleUrls: ['./libro-search.component.css']
})
export class LibroSearchComponent implements OnInit {

  submitted = false;
  errorMessage = '';
  edito = '';
  auto = '';

  editoriales: Editorial[] = [];
  autores: Autor[] = [];
  libros: Libro[] = [];
  librosinf: Libroinf[] = [];

  libro: Libro = new Libro(
    undefined,
    undefined,
    undefined,
    undefined,
    undefined,
    0,
    0
  );

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private restClient: RestClientService
  ) { }

  ngOnInit(): void {
    this.findEditoriales();
    this.findAutores();
  }

  findEditoriales() {
    this.restClient.findEditoriales().subscribe(
      results => {
        console.log(results);
        this.editoriales = results;
      },
      error => console.error(error)
    );
  }

  findAutores() {
    this.restClient.findAutores().subscribe(
      results => {
        console.log(results);
        this.autores = results;
      },
      error => console.error(error)
    );
  }

  buscar() {
    this.submitted = true;
    if (this.libro.titulo == undefined){
      this.libro.titulo = 'null';
    }
    if (this.libro.anio == undefined){
      this.libro.anio = 0;
    }
    if (this.libro.genero == undefined){
      this.libro.genero = 'null';
    }
    if (this.libro.numero_paginas == undefined){
      this.libro.numero_paginas = 0;
    }
    if (this.edito != ''){
      const founde = this.editoriales.find(element => element.nombre == this.edito);
      this.libro.editorial_id = founde.id;
    }
    if (this.auto != ''){
      const founda = this.autores.find(element => element.nombre_completo == this.auto);
      this.libro.autor_id = founda.id;
    }
    this.restClient.buscarLibro(this.libro).subscribe(
      results => {
        console.log(results);
        this.libros = results;
        this.librosinf = [];
        for (let i = 0; i < this.libros.length; i++){
          let l = this.libros[i];
          const founde = this.editoriales.find(element => element.id == l.editorial_id);
          const founda = this.autores.find(element => element.id == l.autor_id);
          let li = new Libroinf(
            l.titulo,
            l.anio,
            l.genero,
            l.numero_paginas,
            founde.nombre,
            founda.nombre_completo
          );
          this.librosinf.push(li);
        }
        this.libro.id = undefined;
        this.libro.titulo = undefined;
        this.libro.anio = undefined;
        this.libro.genero = undefined;
        this.libro.numero_paginas = undefined;
        this.libro.editorial_id = 0;
        this.libro.autor_id = 0;
        this.edito = '';
        this.auto = '';
      },
      error => {
        console.error(error);
        this.errorMessage = error.toString();
        this.submitted = false;
      }
    );
  }

  regresar() {
    this.router.navigate(['/']);
  }

}

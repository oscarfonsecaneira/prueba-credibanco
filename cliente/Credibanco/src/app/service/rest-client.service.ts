import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Libro } from './class/libro';
import { Editorial } from './class/editorial';
import { Autor } from './class/autor';

@Injectable({
  providedIn: 'root'
})
export class RestClientService {

  constructor(private http: HttpClient) { }


  private handleError(error: HttpErrorResponse): Observable<any> {
    console.log(error);
    return throwError('An error has occurred');
  }

  private get<T>(url): Observable<T> {
    console.log('get:', url);
    return this.http
      .get<T>(url, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        })
      })
      .pipe(
        // retry(5),
        catchError(this.handleError)
      );
  }

  private post<T>(url, data: T): Observable<T> {
    console.log('post:', url);
    return this.http
      .post<T>(url, data, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      })
      .pipe(
        // retry(5),
        catchError(this.handleError)
      );
  }

  buscarLibro(libro: Libro) {
    const url = `${environment.serviceBaseUrl}/libros/busqueda/` + libro.titulo + `/` + libro.anio + `/` + libro.genero + `/` + libro.numero_paginas + `/` + libro.editorial_id + `/` + libro.autor_id;
    const formParams = new HttpParams()
    return this.get<Libro[]>(url);
  }

  findEditoriales() {
    const url = `${environment.serviceBaseUrl}/editoriales/listado`;
    return this.get<Editorial[]>(url);
  }

  findAutores() {
    const url = `${environment.serviceBaseUrl}/autores/listado`;
    return this.get<Autor[]>(url);
  }

  createEditorial(editorial: Editorial) {
    const url = `${environment.serviceBaseUrl}/editoriales/registro`;
    return this.post(url, {
      nombre: editorial.nombre,
      direccion_correspondencia: editorial.direccion,
      telefono: editorial.telefono,
      correo: editorial.correo,
      max_libros: editorial.max_libros
    });
  }

  createAutor(autor: Autor) {
    const url = `${environment.serviceBaseUrl}/autores/registro`;
    return this.post(url, {
      nombre_completo: autor.nombre_completo,
      fecha_nacimiento: autor.fecha_nacimiento,
      ciudad_procedencia: autor.ciudad_procedencia,
      correo: autor.correo
    });
  }

  createLibro(libro: Libro) {
    const url = `${environment.serviceBaseUrl}/libros/registro`;
    return this.post(url, {
      titulo: libro.titulo,
      anio: libro.anio,
      genero: libro.genero,
      numero_paginas: libro.numero_paginas,
      editorial_id: libro.editorial_id,
      autor_id: libro.autor_id
    });
  }
}

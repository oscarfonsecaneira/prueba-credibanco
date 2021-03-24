import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibroSearchComponent } from './libro/libro-search/libro-search.component';
import { EditorialCreateComponent } from './editorial/editorial-create/editorial-create.component';
import { AutorCreateComponent } from './autor/autor-create/autor-create.component';
import { LibroCreateComponent } from './libro/libro-create/libro-create.component';

const routes: Routes = [
  {path: 'editorial/registro', component: EditorialCreateComponent },
  {path: 'autor/registro', component: AutorCreateComponent },
  {path: 'libro/registro', component: LibroCreateComponent },
  {path: 'libro/busqueda', component: LibroSearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

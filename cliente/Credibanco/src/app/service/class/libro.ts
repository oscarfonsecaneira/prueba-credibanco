export class Libro {
    constructor(
        public id: number,
        public titulo: string,
        public anio: number,
        public genero: string,
        public numero_paginas: number,
        public editorial_id: number,
        public autor_id: number
    ) {}
}

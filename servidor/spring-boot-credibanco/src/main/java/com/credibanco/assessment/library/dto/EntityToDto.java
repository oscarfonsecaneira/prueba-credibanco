package com.credibanco.assessment.library.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.credibanco.assessment.library.model.AutorEntity;
import com.credibanco.assessment.library.model.EditorialEntity;
import com.credibanco.assessment.library.model.LibroEntity;

@Component("EntityToDto")
public class EntityToDto {

	@Autowired
	private ModelMapper modelMapper;

	public Editorial convertToDTOEditorial(EditorialEntity editorial) {
		Editorial editorialDTO = null;

		if (editorial != null) {
			editorialDTO = modelMapper.map(editorial, Editorial.class);
		}
		return editorialDTO;
	}

	public Autor convertToDTOAutor(AutorEntity autor) {
		Autor autorDTO = null;

		if (autor != null) {
			autorDTO = modelMapper.map(autor, Autor.class);
		}
		return autorDTO;
	}

	public Libro convertToDTOLibro(LibroEntity libro) {
		Libro libroDTO = null;

		if (libro != null) {
			libroDTO = modelMapper.map(libro, Libro.class);
		}
		return libroDTO;
	}
}

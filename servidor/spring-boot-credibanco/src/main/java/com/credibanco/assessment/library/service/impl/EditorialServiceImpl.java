package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.Editorial;
import com.credibanco.assessment.library.dto.EntityToDto;
import com.credibanco.assessment.library.model.EditorialEntity;
import com.credibanco.assessment.library.repository.EditorialRepository;
import com.credibanco.assessment.library.service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepository repository;

	@Autowired
	private EntityToDto entityToDto;

	@Override
	public Editorial registrarEditorial(Editorial editorialDto) {
		Editorial editorialDTO = null;
		EditorialEntity editorial = new EditorialEntity();
		editorial.setNombre(editorialDto.getNombre());
		editorial.setDireccion_correspondencia(editorialDto.getDireccion_correspondencia());
		editorial.setTelefono(editorialDto.getTelefono());
		editorial.setCorreo(editorialDto.getCorreo());
		editorial.setMax_libros(editorialDto.getMax_libros());

		repository.save(editorial);

		editorialDTO = entityToDto.convertToDTOEditorial(editorial);

		return editorialDTO;
	}

	@Override
	public List<Editorial> listarEditoriales() {
		List<Editorial> list = null;
		List<EditorialEntity> editorial = repository.findAll();
		list = editorial.stream().map(param -> entityToDto.convertToDTOEditorial(param)).collect(Collectors.toList());
		return list;
	}

	@Override
	public EditorialEntity buscarEditorial(Long editorial_id) {
		return repository.findById(editorial_id)
				.orElseThrow(() -> new ResourceNotFoundException("Editorial no encontrado"));
	}

}

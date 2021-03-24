package com.credibanco.assessment.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.credibanco.assessment.library.model.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

	@Query("SELECT COUNT(l) FROM LibroEntity l WHERE l.editorial_id =:editorial_id")
	long contarLibros(Long editorial_id);

}

package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Profissional;

@Repository
public interface ProfissionalRepository extends CrudRepository<Profissional, Integer>{
	@Query("select p from Profissional p where p.usuario.id = :idUsuario")
	Collection<Profissional> findAll(@Param("idUsuario") Integer idUsuario);
}

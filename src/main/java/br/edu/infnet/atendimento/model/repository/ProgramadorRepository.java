package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Programador;

@Repository
public interface ProgramadorRepository extends CrudRepository<Programador, Integer>{
	@Query("select p from Programador p where p.usuario.id = :idUsuario")
	Collection<Programador> findAll(@Param("idUsuario") Integer idUsuario);
}

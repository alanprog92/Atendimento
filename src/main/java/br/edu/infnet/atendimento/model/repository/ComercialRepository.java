package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Comercial;

@Repository
public interface ComercialRepository extends CrudRepository<Comercial, Integer>{
	@Query("select c from Comercial c where c.usuario.id = :idUsuario")
	Collection<Comercial> findAll(@Param("idUsuario") Integer idUsuario);
}

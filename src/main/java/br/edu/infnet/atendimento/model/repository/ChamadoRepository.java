package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Chamado;

@Repository
public interface ChamadoRepository extends CrudRepository<Chamado, Integer>{
	@Query("select c from Chamado c where c.usuario.id = :idUsuario")
	Collection<Chamado> findAll(@Param("idUsuario") Integer idUsuario);
}

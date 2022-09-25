package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Suporte;

@Repository
public interface SuporteRepository extends CrudRepository<Suporte, Integer>{
	@Query("select s from Suporte s where s.usuario.id = :idUsuario")
	Collection<Suporte> findAll(@Param("idUsuario") Integer idUsuario);
}

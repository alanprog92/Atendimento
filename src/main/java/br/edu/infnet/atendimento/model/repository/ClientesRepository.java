package br.edu.infnet.atendimento.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer>{
	@Query("select c from Clientes c where c.usuario.id = :idUsuario")
	Collection<Clientes> findAll(@Param("idUsuario") Integer idUsuario);
}

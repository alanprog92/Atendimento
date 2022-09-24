package br.edu.infnet.atendimento.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atendimento.model.domain.Comercial;

@Repository
public interface ComercialRepository extends CrudRepository<Comercial, Integer>{

}

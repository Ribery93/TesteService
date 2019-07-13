package br.com.cilia.teste.repository;

import br.com.cilia.teste.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client save(Client client);

    void delete(Client client);

    List<Client> findAll();

    Client findOne(Long id);
}

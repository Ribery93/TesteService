package br.com.cilia.teste.repository;

import br.com.cilia.teste.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {

    Sale save(Sale sale);

    void delete(Sale sale);

    List<Sale> findAll();

    Sale findOne(Long id);
}

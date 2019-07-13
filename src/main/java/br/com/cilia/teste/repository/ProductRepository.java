package br.com.cilia.teste.repository;

import br.com.cilia.teste.model.Product;
import br.com.cilia.teste.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findOne(Long id);
}

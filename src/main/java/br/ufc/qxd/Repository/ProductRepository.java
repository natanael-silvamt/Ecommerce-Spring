package br.ufc.qxd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

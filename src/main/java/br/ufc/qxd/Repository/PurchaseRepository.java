package br.ufc.qxd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.Cart.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}

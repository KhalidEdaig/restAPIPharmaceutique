package org.pharmaceutique.repositries;

import java.util.Optional;

import org.pharmaceutique.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByCodeContaining(String code);
	Product findByNomContaining(String name);
}

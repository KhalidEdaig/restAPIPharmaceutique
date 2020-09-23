package org.pharmaceutique.repositries;

import java.util.Optional;

import org.pharmaceutique.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByCodeContaining(String code);
	Optional<Product> findByNomContaining(String name);
}

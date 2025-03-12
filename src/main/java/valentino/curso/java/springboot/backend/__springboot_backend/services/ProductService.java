package valentino.curso.java.springboot.backend.__springboot_backend.services;

import valentino.curso.java.springboot.backend.__springboot_backend.enties.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> deleteById(Long id);
}

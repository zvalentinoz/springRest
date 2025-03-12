package valentino.curso.java.springboot.backend.__springboot_backend.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valentino.curso.java.springboot.backend.__springboot_backend.enties.Product;
import valentino.curso.java.springboot.backend.__springboot_backend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceInpl implements ProductService  {

    private final ProductRepository repository;

    public ProductServiceInpl(ProductRepository  repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }
@Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
@Transactional
    @Override
    public Optional<Product> deleteById(Long id) {
       Optional<Product> productOptional = repository.findById(id);
       if(productOptional.isPresent()){
           repository.deleteById(id);
          return productOptional;
       }
        return Optional.empty();
        }

    }


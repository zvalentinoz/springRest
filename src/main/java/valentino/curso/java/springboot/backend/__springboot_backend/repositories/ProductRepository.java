package valentino.curso.java.springboot.backend.__springboot_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import valentino.curso.java.springboot.backend.__springboot_backend.enties.Product;

public interface ProductRepository  extends CrudRepository<Product , Long> {

}

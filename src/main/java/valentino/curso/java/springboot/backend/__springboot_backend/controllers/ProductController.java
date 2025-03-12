package valentino.curso.java.springboot.backend.__springboot_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import valentino.curso.java.springboot.backend.__springboot_backend.enties.Product;
import valentino.curso.java.springboot.backend.__springboot_backend.services.ProductService;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {
       final private ProductService service;

       public ProductController(ProductService service){
           this.service = service;
       }

       // si no lleva nada sin algo de parametro
       @GetMapping
    public ResponseEntity<List<Product>> list(){
           return ResponseEntity.ok(service.findAll());
       }

       //si lleva algo como id poner /{id}
       @GetMapping("/{id}")   // define una llamada URL
       public ResponseEntity<Product> details(@PathVariable Long id){
           Optional<Product> optionaProduct = service.findById(id);
           if(optionaProduct.isPresent()) {
               return ResponseEntity.ok(optionaProduct.orElseThrow());
           }
           return ResponseEntity.notFound().build();
       }

       @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
           ; // guardar el objeto creado
           return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
       }

       @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product , @PathVariable Long id){
           Optional<Product> optionalProduct = service.findById(id);
           if(optionalProduct.isPresent()){
               Product productDb = optionalProduct.orElseThrow();
               productDb.setDescription(product.getDescription());
               productDb.setName(product.getName());
               productDb.setPrice(product.getPrice());
               return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));

           }
           return ResponseEntity.notFound().build();
       }


       @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        Optional<Product> optionalProduct = service.deleteById(id);;
        if(optionalProduct.isPresent()){
            Product productDelete =  optionalProduct.orElseThrow(); // obtenemos el objeto eliminado
            return ResponseEntity.status(HttpStatus.OK).body(productDelete); // manda una respuesta que el producto fue eliminado
        }
        return ResponseEntity.notFound().build();
        // comentario Test
       }

}

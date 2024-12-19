package br.com.testevector.services;

import br.com.testevector.model.ProductDTO;
import br.com.testevector.repository.ProductRepository;

public class ProductService {
    
    public boolean createProduct(ProductDTO productDTO){

        ProductRepository repository = new ProductRepository(new ProductDTO(productDTO.id(), productDTO.description(), productDTO.price()));

        String response = repository.insertProduct();

        System.out.println("Inserindo no banco de dados: " + response);

        return response != null;
    }

}

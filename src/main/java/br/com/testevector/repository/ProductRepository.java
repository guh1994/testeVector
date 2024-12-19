package br.com.testevector.repository;


import br.com.testevector.model.ProductDTO;

import java.util.Objects;

public class ProductRepository {

    private final Long id;
    private final String description;
    private final Double price;

    public ProductRepository(ProductDTO productDTO) {
        this.id = productDTO.id();
        this.description = productDTO.description();
        this.price = productDTO.price();
    }

    public String insertProduct() {
        return "INSERT INTO TB_PRODUTOS (COD,DESCRICAO,VALOR) VALUES ("+id+",'"+description+"','"+price+"');";
    }

}

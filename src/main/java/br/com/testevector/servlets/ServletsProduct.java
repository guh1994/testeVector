package br.com.testevector.servlets;


import br.com.testevector.model.ProductDTO;
import br.com.testevector.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletsProduct extends HttpServlet {

    private ProductService service;

    @Override
    public void init() throws ServletException {
        this.service = new ProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("codigoProduto"));
        String description = req.getParameter("decricaoProduto");
        Double price = Double.parseDouble(req.getParameter("valorProduto"));

        boolean response = service.createProduct(new ProductDTO(id, description, price));

        if (response) {
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{ \"status\": \"sucesso\", \"mensagem\": \"Produto recebido com sucesso!\" }");
            out.flush();
        }else{
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print("{ \"status\": \"error\", \"mensagem\": \"Não foi possivel cadastrar o produto!\" }");
            out.flush();
        }

    }
}

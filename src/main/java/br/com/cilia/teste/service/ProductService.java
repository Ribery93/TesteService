package br.com.cilia.teste.service;


import br.com.cilia.teste.model.Product;
import br.com.cilia.teste.model.ResponseEntity;
import br.com.cilia.teste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/product")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * SALVAR UM NOVO REGISTRO
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity salvar(@RequestBody Product product) {
        try {

            this.productRepository.save(product);

            return new ResponseEntity(1, "Produto salvo com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * ATUALIZAR O REGISTRO DE UM CLIENTE
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity atualizar(@RequestBody Product product) {

        try {

            this.productRepository.save(product);

            return new ResponseEntity(1, "Produto atualizado com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * CONSULTAR TODAS OS CLIENTES
     *
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Product> consultar() {

        return this.productRepository.findAll();
    }

    /**
     * BUSCAR UM CLIENTE PELO CÓDIGO
     *
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/product/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Product buscar(@PathVariable("codigo") Long codigo) {

        return this.productRepository.findOne(codigo);
    }

    /***
     * EXCLUIR UM CLIENTE PELO CÓDIGO
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/product/{codigo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity excluir(@PathVariable("codigo") Long codigo) {
        Product p = productRepository.findOne(codigo);

        try {

            productRepository.delete(p);

            return new ResponseEntity(1, "Produto excluido com sucesso!");

        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage());
        }
    }
}
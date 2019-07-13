package br.com.cilia.teste.service;


import br.com.cilia.teste.model.Sale;
import br.com.cilia.teste.model.ResponseEntity;
import br.com.cilia.teste.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/sale")
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    /**
     * SALVAR UM NOVO REGISTRO
     *
     * @param sale
     * @return
     */
    @RequestMapping(value = "/sale", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity salvar(@RequestBody Sale sale) {
        try {

            this.saleRepository.save(sale);

            return new ResponseEntity(1, "Venda salva com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * ATUALIZAR O REGISTRO DE UM CLIENTE
     *
     * @param sale
     * @return
     */
    @RequestMapping(value = "/sale", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity atualizar(@RequestBody Sale sale) {

        try {

            this.saleRepository.save(sale);

            return new ResponseEntity(1, "Venda atualizada com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * CONSULTAR TODAS OS CLIENTES
     *
     * @return
     */
    @RequestMapping(value = "/sale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Sale> consultar() {

        return this.saleRepository.findAll();
    }

    /**
     * BUSCAR UM CLIENTE PELO CÓDIGO
     *
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/sale/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Sale buscar(@PathVariable("codigo") Long codigo) {

        return this.saleRepository.findOne(codigo);
    }

    /***
     * EXCLUIR UM CLIENTE PELO CÓDIGO
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/sale/{codigo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity excluir(@PathVariable("codigo") Long codigo) {
        Sale pessoaModel = saleRepository.findOne(codigo);

        try {

            saleRepository.delete(pessoaModel);

            return new ResponseEntity(1, "Venda excluida com sucesso!");

        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage());
        }
    }
}
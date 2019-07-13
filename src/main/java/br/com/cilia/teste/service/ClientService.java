package br.com.cilia.teste.service;


import br.com.cilia.teste.model.Client;
import br.com.cilia.teste.model.ResponseEntity;
import br.com.cilia.teste.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/service/client")
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * SALVAR UM NOVO REGISTRO
     *
     * @param client
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity salvar(@RequestBody Client client) {
        try {

            this.clientRepository.save(client);

            return new ResponseEntity(1, "Cliente salvo com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * ATUALIZAR O REGISTRO DE UM CLIENTE
     *
     * @param client
     * @return
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity atualizar(@RequestBody Client client) {

        try {

            this.clientRepository.save(client);

            return new ResponseEntity(1, "Cliente atualizado com sucesso!");

        } catch (Exception e) {

            return new ResponseEntity(0, e.getMessage());
        }
    }

    /**
     * CONSULTAR TODAS OS CLIENTES
     *
     * @return
     */
    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Client> consultar() {

        return this.clientRepository.findAll();
    }

    /**
     * BUSCAR UM CLIENTE PELO CÓDIGO
     *
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Client buscar(@PathVariable("codigo") Long codigo) {

        return this.clientRepository.findOne(codigo);
    }

    /***
     * EXCLUIR UM CLIENTE PELO CÓDIGO
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity excluir(@PathVariable("codigo") Long codigo) {
        Client pessoaModel = clientRepository.findOne(codigo);

        try {

            clientRepository.delete(pessoaModel);

            return new ResponseEntity(1, "Cliente excluido com sucesso!");

        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage());
        }
    }
}
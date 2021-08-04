package core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.models.Cliente;
import core.repositorys.ClienteRespository;

@RestController(value = "clientes")
public class ClienteController {
      
  @Autowired
  private ClienteRespository repo;

  @RequestMapping("/")
  public ResponseEntity<List<Cliente>> home() {
    
    
    return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
  }
}

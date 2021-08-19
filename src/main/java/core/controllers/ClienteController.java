package core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import core.models.Cliente;
import core.repositorys.ClienteRespository;

@RestController(value = "clientes")
@RequestMapping("/clientes")
public class ClienteController {
      
  @Autowired
  private ClienteRespository repo;

  @GetMapping("/todos")
  public ResponseEntity<List<Cliente>> pesquisarTodo() {
     
    return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<Cliente> pesquisarPorId(@PathVariable Long id ) {
     
    try {
      return new ResponseEntity<>(repo.findById(id).get(),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(repo.findById(id).get(),HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/pesquisarPorNome/{nome}")
  public ResponseEntity<List<Cliente>> pesquisarPorNome(@PathVariable String nome) {
    try {
      return new ResponseEntity<>(repo.findByNome(nome),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(repo.findByNome(nome),HttpStatus.NOT_FOUND);
    }
  }


  @GetMapping("/pesquisarPorCpf/{cpf}")
  public ResponseEntity<List<Cliente>> pesquisarPorCpf(@PathVariable String cpf) {
    try {
      return new ResponseEntity<>(repo.findByCpf(cpf),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(repo.findByCpf(cpf),HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente salvar(@RequestBody Cliente cliente) {
    return repo.save(cliente);
  }


  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestBody Cliente cliente) {
    
    if (!repo.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    cliente.setId(id);    
    repo.saveAndFlush(cliente);
    return ResponseEntity.ok(cliente);
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Cliente> delete(@PathVariable Long id) {
    
    if (!repo.existsById(id)) {
      return ResponseEntity.notFound().build();
    }    
    repo.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }




}

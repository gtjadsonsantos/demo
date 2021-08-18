package core.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import core.models.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente,Long> {


    List<Cliente> findByNome(String nome);
}

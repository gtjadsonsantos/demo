package core.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.models.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente,Long> {


}

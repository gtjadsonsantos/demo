package core.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import core.models.Cliente;

public interface ClienteRespository extends JpaRepository<Cliente,Long> {
    
}

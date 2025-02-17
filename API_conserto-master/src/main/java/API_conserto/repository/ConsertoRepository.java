package API_conserto.repository;

import API_conserto.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    public List<Conserto> findAllByAtivoTrue();
}
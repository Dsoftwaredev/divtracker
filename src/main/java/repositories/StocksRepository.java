package repositories;

import java.util.List;

import entities.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Integer> {

}

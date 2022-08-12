package controllers;

import entities.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import repositories.StocksRepository;

import java.util.List;
import java.util.Optional;

@Service
@RestController

public class StockController {

    private StockService service;

    @Autowired
    public StockController(StockService service) {
        super();
        this.service = service;
    }

    @GetMapping("/stocks")
    public List<Stocks> getAllStock() {
        return this.service.getAllStock();
    }


    @GetMapping("/stocks/{id}")
    public Optional<Stocks> getStockById(@PathVariable("id") Integer id) {
        return null;
    }

    @PostMapping("/stocks")
    public Stocks createStock(@RequestBody Stocks stock) {
        return this.service.createStock(stock);
    }

    @PutMapping("/stocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stocks updateStock(@PathVariable("id") Integer id, @RequestBody Stocks stock) {
        return this.service.updateStocks(id, stock);

    }

    @DeleteMapping("/stocks/{id}")
    public Stocks deleteStock(@PathVariable("id") Integer id) {
        return this.service.deleteStock(id);
    }

}

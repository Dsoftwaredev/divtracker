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

    private final StocksRepository stocksRepository;

    public StockController(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }

    @GetMapping("/stocks")
    public List<Stocks> getAllStocks() {
        return this.stocksRepository.findAll();
    }


    @GetMapping("/stocks/{id}")
    public Optional<Stocks> getStockById(@PathVariable("id") Integer id) {
        return this.stocksRepository.findById(id);
    }

    @PostMapping("/stocks")
    public Stocks createNewStock(@RequestBody Stocks stocks) {
        Stocks newStock = this.stocksRepository.save(stocks);
        return newStock;
    }

    @PutMapping("/stocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stocks updateStock(@PathVariable("id") Integer id, @RequestBody Stocks stock) {
        Optional<Stocks> stockToUpdateOptional = this.stocksRepository.findById(id);
        if (!stockToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Stocks stockToUpdate = stockToUpdateOptional.get();

        if (stock.getName() != null) {
            stockToUpdate.setName(stock.getName());
        }
        if (stock.getQuantity() != null) {
            stockToUpdate.setQuantity(stock.getQuantity());
        }
        if (stock.getStockPrice() != null) {
            stockToUpdate.setStockPrice(stock.getStockPrice());
        }
        if (stock.getDivFrequency() !=null) {
            stockToUpdate.setDivFrequency(stock.getDivFrequency());
        }
        if (stock.getNextDividendPayment() !=null) {
            stockToUpdate.setNextDividendPayment(stock.getNextDividendPayment());
        }

        Stocks updatedStock = this.stocksRepository.save(stockToUpdate);
        return updatedStock;
    }

    @DeleteMapping("/stocks/{id}")
    public Stocks deleteStock(@PathVariable("id") Integer id) {
        Optional<Stocks> stockToDeleteOptional = this.stocksRepository.findById(id);
        if (!stockToDeleteOptional.isPresent()) {
            return null;
        }
        Stocks stockToDelete = stockToDeleteOptional.get();
        this.stocksRepository.delete(stockToDelete);
        return stockToDelete;
    }

}

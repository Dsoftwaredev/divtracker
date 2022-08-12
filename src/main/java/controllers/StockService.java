package controllers;

import entities.Stocks;
import org.springframework.stereotype.Service;
import repositories.StocksRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StocksRepository stocksRepository;

    public StockService(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }




    public List<Stocks> getAllStock() {
        return this.stocksRepository.findAll();
    }

    public Stocks createStock(Stocks stocks) {
        Stocks newStock = this.stocksRepository.save(stocks);
        return newStock;
    }

    public Stocks updateStocks(Integer id, Stocks stocks) {
        Optional<Stocks> stockToUpdateOptional = this.stocksRepository.findById(id);
        if (!stockToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Stocks stockToUpdate = stockToUpdateOptional.get();

        if (stocks.getName() != null) {
            stockToUpdate.setName(stocks.getName());
        }
        if (stocks.getQuantity() != null) {
            stockToUpdate.setQuantity(stocks.getQuantity());
        }
        if (stocks.getStockPrice() != null) {
            stockToUpdate.setStockPrice(stocks.getStockPrice());
        }
        if (stocks.getDivFrequency() !=null) {
            stockToUpdate.setDivFrequency(stocks.getDivFrequency());
        }
        if (stocks.getNextDividendPayment() !=null) {
            stockToUpdate.setNextDividendPayment(stocks.getNextDividendPayment());
        }

        Stocks updatedStock = this.stocksRepository.save(stockToUpdate);
        return updatedStock;

    }

    public Stocks deleteStock(Integer id) {
        Optional<Stocks> stockToDeleteOptional = this.stocksRepository.findById(id);
        if (!stockToDeleteOptional.isPresent()) {
            return null;
        }
        Stocks stockToDelete = stockToDeleteOptional.get();
        this.stocksRepository.delete(stockToDelete);
        return stockToDelete;
    }

}

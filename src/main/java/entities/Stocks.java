package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="Stocks")
public class Stocks {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="QUANTITY")
    private Integer quantity;

    @Column(name="STOCK_PRICE")
    private Double stockPrice;

    @Column(name="DIV_FREQUENCY")
    private Integer divFrequency;

    @Column(name="NEXT_DIVIDEND")
    private Double nextDividendPayment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Integer getDivFrequency() {
        return divFrequency;
    }

    public void setDivFrequency(Integer divFrequency) {
        this.divFrequency = divFrequency;
    }

    public Double getNextDividendPayment() {
        return nextDividendPayment;
    }

    public void setNextDividendPayment(Double nextDividendPayment) {
        this.nextDividendPayment = nextDividendPayment;
    }
}

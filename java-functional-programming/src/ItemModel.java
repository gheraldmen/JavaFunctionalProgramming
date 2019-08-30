import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemModel {

    String item;
    LocalDate orderDate;
    Integer unitSold;
    BigDecimal price;

    public ItemModel(String item, LocalDate orderDate, Integer unitSold, BigDecimal price) {
        this.item = item;
        this.orderDate = orderDate;
        this.unitSold = unitSold;
        this.price = price;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(Integer unitSold) {
        this.unitSold = unitSold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }





}
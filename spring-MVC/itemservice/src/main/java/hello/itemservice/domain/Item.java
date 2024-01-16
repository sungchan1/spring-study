package hello.itemservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data // 핵심 에는 쓰지말자
//@Getter @Setter
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;


    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data 핵심에 사용하기에는 위험함 - dto(단순히 데이터가 이동하는 것) 쓸때는 괜찮은데,, 그것도 확인은 해봐야함
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // null 값 허용 - 가격이 안 들어간 상황도 고려
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}

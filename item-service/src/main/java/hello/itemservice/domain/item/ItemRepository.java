package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // @component 로 컴포넌트 스캔의 대상이 됨
public class ItemRepository {

    /**
     * Long = id
     */
    private static final Map<Long, Item> store = new HashMap<>();
    // 실제는 HashMap 쓰면 안됨, 멀티쓰레드 환경에서는 헤시맵 쓰면 안됨, ConcurrentHashMap<>() 써야 댐
    // long 도 마찬가지로 쓰면 안됨
    // 동시에 접근하면 값이 꼬임
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);

        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);

        // 정석으로 하려면 id 를 제외한 이름, 가격, 수량은 따로 객체를 만들어서 해야함, 하단에 셋팅하는 게 id 는 안하기 때문, 분리해줘야 함
        // id는 안하는건지 혼란을 줄 수 있기때문
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    // 테스트 용
    public void clearStore() {
        store.clear();

    }


}

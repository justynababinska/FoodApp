package pl.justynababinska.order;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import pl.justynababinska.item.Item;

@Component
@SessionScope
public class ClientOrder {

    private Order order;

    public ClientOrder() {
    	clear();
    }

    public Order getOrder() {
        return order;
    }

    public void add(Item item) {
        order.getItems().add(item);
    }

    public void clear() {
    	order = new Order();
        order.setStatus(OrderStatus.NEW);
    }
}
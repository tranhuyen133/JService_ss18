package re.ss18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ss18.entity.OrderItem;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Long> {
}

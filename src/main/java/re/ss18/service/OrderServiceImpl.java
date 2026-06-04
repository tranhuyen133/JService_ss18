package re.ss18.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import re.ss18.entity.Order;
import re.ss18.repository.OrderRepository;
import re.ss18.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl
        implements OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    @Override
    public Order createOrder(String email) {

        re.ss18.entity.User user =
                userRepository.findByEmail(email)
                        .orElseThrow();

        Order order = new Order();

        order.setUser(user);
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setTotalMoney(BigDecimal.ZERO);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getMyOrders(String email) {

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow();

        return orderRepository.findByUser(user);
    }
    

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @Override
    public Order updateStatus(
            Long id,
            String status
    ) {

        Order order =
                orderRepository.findById(id)
                        .orElseThrow();

        order.setStatus(status);

        return orderRepository.save(order);
    }
}

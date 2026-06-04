package re.ss18.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import re.ss18.entity.Order;
import re.ss18.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Order create(
            Authentication auth) {

        return orderService.createOrder(
                auth.getName());
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('USER')")
    public List<Order> myOrders(
            Authentication auth) {

        return orderService.getMyOrders(
                auth.getName());
    }

    @GetMapping
    @PreAuthorize(
            "hasAnyRole('STAFF','ADMIN')")
    public List<Order> allOrders() {

        return orderService.getAllOrders();
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('STAFF')")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return orderService.updateStatus(
                id,
                status);
    }
}

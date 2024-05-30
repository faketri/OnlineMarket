package com.faketri.market.infastructure.user.payload.order.controller;

import com.faketri.market.entity.product.payload.product.model.ProductItem;
import com.faketri.market.entity.user.payload.order.gateway.mapper.OrderMapper;
import com.faketri.market.entity.user.payload.order.model.EStatusOrder;
import com.faketri.market.entity.user.payload.order.model.Orders;
import com.faketri.market.entity.user.payload.user.model.Users;
import com.faketri.market.infastructure.user.payload.order.dto.OrdersDto;
import com.faketri.market.infastructure.user.payload.order.gateway.OrderService;
import com.faketri.market.infastructure.user.payload.user.gateway.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Orders", description = "Operation with orders")
public class OrdersPostController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final OrderService orderService;
    private final UserService userService;

    public OrdersPostController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    public Orders save(@RequestBody Orders orders) {
        return orderService.save(orders);
    }

    @RequestMapping("/create")
    public OrdersDto createOrder(@RequestBody final List<ProductItem> product) {
        final Users user = userService.getCurrentUser();
        log.info("CREATE ORDER " + user.getId());

        Orders orders = new Orders();

        orders.setUsers(user);
        orders.getProducts().addAll(product.stream().map(p -> new ProductItem(null, p.getProduct(), p.getQuantity())).toList());
        orders.setUsers(user);

        return OrderMapper.toDto(orderService.save(orders));
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value = "/{id}/change-status")
    public OrdersDto changeStatus(@RequestParam("id") UUID uuid,
                                  @RequestBody EStatusOrder statusOrder) {
        Orders orders = orderService.findById(uuid);
        orders.setStatusOrder(statusOrder);
        return OrderMapper.toDto(orderService.save(orders));
    }
}

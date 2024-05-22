package com.faketri.market.infastructure.user.payload.order.controller;

import com.faketri.market.entity.user.payload.order.gateway.mapper.OrderMapper;
import com.faketri.market.entity.user.payload.order.model.EStatusOrder;
import com.faketri.market.entity.user.payload.order.model.Orders;
import com.faketri.market.infastructure.user.payload.order.dto.OrderFindRequest;
import com.faketri.market.infastructure.user.payload.order.dto.OrdersDto;
import com.faketri.market.infastructure.user.payload.order.gateway.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Orders", description = "Operation with orders")
public class OrdersPostController {

    private final OrderService orderService;

    public OrdersPostController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Orders save(@RequestBody Orders orders){
        return orderService.save(orders);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value = "/{id}/change-status")
    public OrdersDto changeStatus(@RequestParam("id") UUID uuid,
                               @RequestBody EStatusOrder statusOrder){
        Orders orders = orderService.findById(uuid);
        orders.setStatusOrder(statusOrder);
        return OrderMapper.toDto(orderService.save(orders));
    }
}
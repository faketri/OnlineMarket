package com.faketri.market.infastructure.user.payload.order.controller;

import com.faketri.market.entity.user.payload.order.gateway.mapper.OrderMapper;
import com.faketri.market.entity.user.payload.order.model.EStatusOrder;
import com.faketri.market.infastructure.user.payload.order.dto.OrdersDto;
import com.faketri.market.infastructure.user.payload.order.gateway.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin({"http://localhost:8081", "http://192.168.1.106:8081/"})
@RequestMapping(path = "/api/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Orders", description = "Operation with orders")
public class OrdersGetController {

    private final OrderService orderService;

    public OrdersGetController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/user/{id}")
    public Page<OrdersDto> findByUser(@PathVariable("id") UUID id,
                                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                                      @RequestParam(name = "size", defaultValue = "20") Integer size) {
        return orderService.findByUser(id, PageRequest.of(page, size)).map(OrderMapper::toDto);
    }

    @RequestMapping("/get-all-status")
    public Map<EStatusOrder, String> getAllStatus() {
        return Arrays.stream(EStatusOrder.values()).collect(Collectors.toMap((e) -> e, EStatusOrder::getStatus));
    }

    @RequestMapping("/id/{id}")
    public OrdersDto findById(@PathVariable("id") UUID id) {
        return OrderMapper.toDto(orderService.findById(id));
    }

    @PreAuthorize("hasAuthority('EMPLOYEE')")
    @RequestMapping("/")
    public Page<OrdersDto> findAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "suffix", required = false) String suffix
    ) {
        return suffix == null ?
                  orderService.findAll(PageRequest.of(page, size)).map(OrderMapper::toDto)
                : orderService.findByUuidSuffix(suffix, PageRequest.of(page, size)).map(OrderMapper::toDto);
    }
}

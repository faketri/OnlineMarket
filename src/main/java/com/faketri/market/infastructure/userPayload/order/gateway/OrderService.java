package com.faketri.market.infastructure.userPayload.order.gateway;

import com.faketri.market.entity.userPayload.order.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {

    Orders findById(UUID uuid);

    Page<Orders> findAll(Pageable pageable);

    Page<Orders> findByUser(UUID uuidUser, Pageable pageable);

    Orders save(Orders orders);
}

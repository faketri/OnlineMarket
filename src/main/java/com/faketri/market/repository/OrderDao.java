package com.faketri.market.repository;

import com.faketri.market.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);
    List<Order> findByUserId(Long userId);
}

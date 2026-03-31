package com.dmazui.apidistocks.repository;

import com.dmazui.apidistocks.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

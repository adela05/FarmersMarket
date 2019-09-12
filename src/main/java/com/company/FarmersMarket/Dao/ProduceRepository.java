package com.company.FarmersMarket.Dao;

import com.company.FarmersMarket.Dto.Produce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduceRepository extends JpaRepository<Produce, Integer> {
}

package com.saintdenis.economy.repository;

import com.saintdenis.economy.model.TraderPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderPriceRepository extends JpaRepository<TraderPrice, Long>{

}

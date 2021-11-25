package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.DealerPayment;

@Repository
public interface IDealerPaymentRepository extends JpaRepository<DealerPayment, Integer> {

}

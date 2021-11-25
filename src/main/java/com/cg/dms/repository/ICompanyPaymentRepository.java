package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.CompanyPayment;

@Repository
public interface ICompanyPaymentRepository extends JpaRepository<CompanyPayment, Integer>{

}

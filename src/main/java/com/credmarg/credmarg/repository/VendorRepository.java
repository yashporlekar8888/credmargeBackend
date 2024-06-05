package com.credmarg.credmarg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.credmarg.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}

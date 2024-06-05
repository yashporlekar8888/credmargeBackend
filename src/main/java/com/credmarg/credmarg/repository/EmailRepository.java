package com.credmarg.credmarg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.credmarg.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}

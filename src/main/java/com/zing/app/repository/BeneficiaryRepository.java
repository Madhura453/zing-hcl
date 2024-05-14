package com.zing.app.repository;

import com.zing.app.model.BeneficiaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryDetails, Long> {
}

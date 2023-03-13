package com.learningSpringBoot.data.repositories;

import com.learningSpringBoot.data.models.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository <Human, Long>{
}

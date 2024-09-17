package com.zipsh.zipshare.repository;

import com.zipsh.zipshare.model.page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pageRepository extends JpaRepository<page, Long> {
    page findByString(String code);
}

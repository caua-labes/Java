package com.zipsh.zipshare.repository;

import com.zipsh.zipshare.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pageRepository extends JpaRepository<Page, Long> {
}

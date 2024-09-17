package com.zipsh.zipshare.repository;

import com.zipsh.zipshare.model.pageContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pageContentRepository extends JpaRepository<pageContent, Long> {
}

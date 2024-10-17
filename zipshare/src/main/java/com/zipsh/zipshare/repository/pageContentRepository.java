package com.zipsh.zipshare.repository;

import com.zipsh.zipshare.model.Page;
import com.zipsh.zipshare.model.PageContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface pageContentRepository extends JpaRepository<PageContent, Long> {
    Optional<PageContent> findById(UUID id);
}

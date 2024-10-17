package com.zipsh.zipshare.repository;

import com.zipsh.zipshare.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface pageRepository extends JpaRepository<Page, Long> {
    Page getBycodePage(String codePage);
    Optional<Page> findById(UUID id);
}

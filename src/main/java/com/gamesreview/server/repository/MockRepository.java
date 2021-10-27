package com.gamesreview.server.repository;

import com.gamesreview.server.model.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends JpaRepository<Mock, Long> {
}

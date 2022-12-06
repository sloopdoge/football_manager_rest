package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
}

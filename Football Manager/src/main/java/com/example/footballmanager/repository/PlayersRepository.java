package com.example.footballmanager.repository;

import com.example.footballmanager.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Players, Long> {

}

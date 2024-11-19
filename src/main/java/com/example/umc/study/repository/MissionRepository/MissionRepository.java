package com.example.umc.study.repository.MissionRepository;


import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}

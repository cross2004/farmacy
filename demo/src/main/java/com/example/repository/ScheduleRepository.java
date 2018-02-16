package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Pacient;
import com.example.model.Schedule;


@Repository("scheduleRepository")
public interface ScheduleRepository  extends JpaRepository<Schedule, Integer>{
	List<Schedule> findAll();
}

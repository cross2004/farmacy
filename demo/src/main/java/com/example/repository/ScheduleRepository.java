package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Schedule;


@Repository("scheduleRepository")
public interface ScheduleRepository  extends JpaRepository<Schedule, Integer>{

}

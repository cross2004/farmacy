package com.example.service;

import java.util.List;

import com.example.model.Pacient;
import com.example.model.Schedule;

public interface ScheduleService {
		public void saveSchedule(Schedule sch);
		public void editSchedule(Schedule sch);
		public List<Schedule> findAll(); 
		
}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Schedule;
import com.example.repository.ScheduleRepository;

public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public void saveSchedule(Schedule schedule) {
		schedule.setDetails(schedule.getDetails());
		schedule.setDoctorID(schedule.getDoctorID());
		schedule.setLastDate(schedule.getLastDate());
		schedule.setPacientID(schedule.getPacientID());
		scheduleRepository.save(schedule);
	}

	@Override
	public void editSchedule(Schedule schedule) {
		schedule.setDetails(schedule.getDetails());
		schedule.setDoctorID(schedule.getDoctorID());
		schedule.setLastDate(schedule.getLastDate());
		schedule.setPacientID(schedule.getPacientID());
		scheduleRepository.save(schedule);
		
	}

	
}

package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Schedule;
import com.example.repository.ScheduleRepository;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	protected EntityManager em;

	public ScheduleServiceImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void saveSchedule(Schedule schedule) {
		schedule.setDetails(schedule.getDetails());
		schedule.setDoctorId(schedule.getDoctorId());
		//schedule.setLastDate(schedule.getLastDate());
		schedule.setPacientId(schedule.getPacientId());
		schedule.setStartTime(schedule.getStartTime());
		schedule.setEndTime(schedule.getEndTime());
		scheduleRepository.save(schedule);
	}

	@Override
	public void editSchedule(Schedule schedule) {
		schedule.setDetails(schedule.getDetails());
		schedule.setDoctorId(schedule.getDoctorId());
		schedule.setPacientId(schedule.getPacientId());
		scheduleRepository.save(schedule);
		
	}
	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();

	}
	
}

package com.sparta.customscedule.service;

import com.sparta.customscedule.dto.ScheduleRequestDto;
import com.sparta.customscedule.dto.ScheduleResponseDto;
import com.sparta.customscedule.entity.Schedule;
import com.sparta.customscedule.repository.ScheduleRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ScheduleService {
    private final JdbcTemplate jdbcTemplate;
    public ScheduleService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Long updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);

        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(id);
        if(schedule != null) {
            // memo 내용 수정
            scheduleRepository.update(id, scheduleRequestDto);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    public Long deleteSchedule(Long id) {
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(id);
        if(schedule != null) {
            // memo 삭제
            scheduleRepository.delete(id);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }


    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        //RequestDto -> Entity
        Schedule schedule = new Schedule(scheduleRequestDto);
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);
        Schedule saveSchedule = scheduleRepository.save(schedule);

        //Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedules() {
        // DB 조회
        ScheduleRepository scheduleRepository = new ScheduleRepository(jdbcTemplate);
        return scheduleRepository.findAll();
    }



}
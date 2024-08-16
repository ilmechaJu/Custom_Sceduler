package com.sparta.customscedule.controller;

import com.sparta.customscedule.dto.ScheduleRequestDto;
import com.sparta.customscedule.dto.ScheduleResponseDto;
import com.sparta.customscedule.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final JdbcTemplate jdbcTemplate;
    public ScheduleController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //SceduleService sceduleService = new SceduleService();

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedules(@RequestBody ScheduleRequestDto scheduleRequestDto) { //DTO형식으로 @

        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.getSchedules();
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedules(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }

    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedules(@PathVariable Long id) {
        ScheduleService scheduleService = new ScheduleService(jdbcTemplate);
        return scheduleService.deleteSchedule(id);
    }


}

package com.sparta.customscedule.controller;

import com.sparta.customscedule.dto.SceduleRequestDto;
import com.sparta.customscedule.dto.SceduleResponseDto;
import com.sparta.customscedule.service.SceduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class SceduleController {
    private final JdbcTemplate jdbcTemplate;
    public SceduleController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    //SceduleService sceduleService = new SceduleService();

    @PostMapping("/scedules")
    public SceduleResponseDto createScedule(@RequestBody SceduleRequestDto sceduleRequestDto) { //DTO형식으로 @

        SceduleService sceduleService = new SceduleService(jdbcTemplate);
        return sceduleService.createScedule(sceduleRequestDto);


    }
    @GetMapping("/scedules")
    public List<SceduleResponseDto> getScedules() {
        SceduleService sceduleService = new SceduleService(jdbcTemplate);
        return sceduleService.getTodo();
    }

    /*@PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody SceduleRequestDto sceduleRequestDto) {
        return sceduleService.updateScedule(id, sceduleRequestDto);
    }*/

    /*@DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return SceduleService.deleteScedule(id);
    }*/


}

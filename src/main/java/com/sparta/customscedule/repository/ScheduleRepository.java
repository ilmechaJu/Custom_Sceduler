package com.sparta.customscedule.repository;

import com.sparta.customscedule.dto.ScheduleRequestDto;
import com.sparta.customscedule.dto.ScheduleResponseDto;
import com.sparta.customscedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;


    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ScheduleResponseDto> findAll() {
        String sql = "SELECT * FROM Scedule";

        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String username = rs.getString("major_name");
                String contents = rs.getString("to_do");
                return new ScheduleResponseDto(id, username, contents);
            }
        });
    }

    public void delete(Long id) {
        String sql = "DELETE FROM Scedule WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Schedule save(Schedule schedule) {
        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO Scedule (to_do, major_name, pass_word) VALUES (?, ?, ?)";
        jdbcTemplate.update( con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);


                    preparedStatement.setString(1, schedule.getTo_do());
                    preparedStatement.setString(2, schedule.getMajor_name());
                    preparedStatement.setString(3, schedule.getPass_word());
                    //preparedStatement.setString(4, sceduler.getM_date());
                    //preparedStatement.setString(5, sceduler.getB_date());

                    return preparedStatement;
                },
                keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        schedule.setId(id);

        return schedule;
    }

    public Schedule findById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM Scedule WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setMajor_name(resultSet.getString("major_name"));
                schedule.setTo_do(resultSet.getString("to_do"));
                return schedule;
            } else {
                return null;
            }
        }, id);
    }

    public void update(Long id, ScheduleRequestDto scheduleRequestDto) {
        String sql = "UPDATE Scedule SET major_name = ?, to_do = ? WHERE id = ?";
        jdbcTemplate.update(sql, scheduleRequestDto.getMajor_name(), scheduleRequestDto.getTodo(), id);
    }
}

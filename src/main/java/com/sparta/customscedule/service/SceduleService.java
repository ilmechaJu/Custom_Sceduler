package com.sparta.customscedule.service;

import com.sparta.customscedule.dto.SceduleRequestDto;
import com.sparta.customscedule.dto.SceduleResponseDto;
import com.sparta.customscedule.entity.Sceduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SceduleService {
    private final JdbcTemplate jdbcTemplate;
    public SceduleService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Long updateScedule(Long id, SceduleRequestDto sceduleRequestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Sceduler sceduler = findById(id);
        if(sceduler != null) {
            // memo 내용 수정
            String sql = "UPDATE Custom_Scedule SET major_name = ?, to_do = ? WHERE id = ?";
            jdbcTemplate.update(sql, sceduleRequestDto.getMajor_name(), sceduleRequestDto.getTodo(), id);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    public Long deleteScedule(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Sceduler sceeduler = findById(id);
        if(sceeduler != null) {
            // memo 삭제
            String sql = "DELETE FROM memo WHERE id = ?";
            jdbcTemplate.update(sql, id);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }


    public SceduleResponseDto createScedule(SceduleRequestDto sceduleRequestDto) {
        //RequestDto -> Entity
        Sceduler sceduler = new Sceduler(sceduleRequestDto);


        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO Scedule (to_do, major_name, pass_word) VALUES (?, ?, ?)";
        jdbcTemplate.update( con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);


                    preparedStatement.setString(1, sceduler.getTo_do());
                    preparedStatement.setString(2, sceduler.getMajor_name());
                    preparedStatement.setString(3, sceduler.getPass_word());
                    //preparedStatement.setString(4, sceduler.getM_date());
                    //preparedStatement.setString(5, sceduler.getB_date());

                    return preparedStatement;
                },
                keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        sceduler.setId(id);



        //Entity -> ResponseDto
        SceduleResponseDto sceduleResponseDto = new SceduleResponseDto(sceduler);

        return sceduleResponseDto;
    }

    public List<SceduleResponseDto> getTodo() {
        // DB 조회
        String sql = "SELECT * FROM memo";

        return jdbcTemplate.query(sql, new RowMapper<SceduleResponseDto>() {
            @Override
            public SceduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String username = rs.getString("major_name");
                String contents = rs.getString("to_do");
                return new SceduleResponseDto(id, username, contents);
            }
        });
    }
    private Sceduler findById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM Custom_Scedule WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Sceduler sceduler = new Sceduler();
                sceduler.setMajor_name(resultSet.getString("major_name"));
                sceduler.setTo_do(resultSet.getString("to_do"));
                return sceduler;
            } else {
                return null;
            }
        }, id);
    }
}
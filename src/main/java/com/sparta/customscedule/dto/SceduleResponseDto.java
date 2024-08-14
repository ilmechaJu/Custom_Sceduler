package com.sparta.customscedule.dto;
import com.sparta.customscedule.entity.Sceduler;
import lombok.Getter;

@Getter
public class SceduleResponseDto {
    private String todo;
    private Long id;
    private String major_name;
    //private String m_date;
    //private String b_date;

    public SceduleResponseDto(Sceduler sceduler) {
        //할일, 담당자명, 작성일, 수정일 ->유저에게 반환
        this.id = sceduler.getId();
        this.todo = sceduler.getTo_do();
        this.major_name = sceduler.getMajor_name();
        //this.m_date = sceduler.getM_date(); //날짜, 시간
        //this.b_date = sceduler.getB_date(); //최초는 위와 같음
    }

    public SceduleResponseDto(Long id, String username, String contents) {
        this.id = id;
        this.major_name = username;
        this.todo = contents;

    }
}


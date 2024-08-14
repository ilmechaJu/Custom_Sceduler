package com.sparta.customscedule.entity;

import com.sparta.customscedule.dto.SceduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sceduler {
    private Long id;
    private String to_do;
    private String major_name;
    private String pass_word;
    private String m_date;
    private String b_date;

    public Sceduler (SceduleRequestDto requestDto){
        this.to_do = requestDto.getTodo();
        this.pass_word = requestDto.getPassword();
        this.major_name = requestDto.getMajor_name();
        //this.m_date = requestDto.getMakedate();
        //this.b_date = requestDto.getChangedate();
    }
}


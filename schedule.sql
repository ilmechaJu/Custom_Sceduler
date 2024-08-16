CREATE TABLE IF NOT EXISTS Scedule
(
    id bigint primary key,
    to_do varchar(100) not null comment '할일',
    major_name varchar(100) not null comment '담당자명',
    pass_word varchar(100) not null comment '비밀번호'
    #m_date varchar(100) comment '작성일',
    #b_date varchar(100) comment '수정일'
    );
ALTER TABLE Scedule MODIFY COLUMN id bigint auto_increment;

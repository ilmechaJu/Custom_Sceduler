<aside>
🏁 **Goal:  "나만의 일정 관리 앱 서버 만들기"**

</aside>

- **학습 과제를 끝내고 나면 해낼 수 있어요!** 👍
    1. 구현하고자 하는 서비스의 전체적인 흐름을 파악하고 필요한 기능을 설계할 수 있습니다.
    2. API 명세서, ERD, SQL을 작성할 수 있습니다.
    3. Spring Boot를 기반으로 CRUD(Create, Read, Update, Delete) 기능이 포함된 REST API를 만들 수 있습니다.


| 기능       | Method | URL                | return                   |
|----------|--------|--------------------|--------------------------|
| 스케줄 생성하기 | POST   | /api/scedules      | SceduleResponseDto       |
| 스케줄 조회하기 | GET    | /api/scedules      | List<SceduleResponseDto> |
| 스케줄 수정하기 | PUT    | /api/scedules/{id} | Long updateSchedules |
| 스케줄 삭제하기 | DELETE | /api/scedules/{id} | Long deleteSchedules |


<img width="237" alt="스크린샷 2024-08-16 10 53 40" src="https://github.com/user-attachments/assets/0e584051-c94e-4011-9691-441fc8d91081">



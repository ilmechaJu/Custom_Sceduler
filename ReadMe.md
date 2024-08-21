<aside>
🏁 **Goal:  "나만의 일정 관리 앱 서버 만들기"**
</aside>

- **Custom_Sceduler Project를 통해 얻을 수 있는 것** 👍
    1. 구현하고자 하는 서비스의 전체적인 흐름을 파악하고 필요한 기능을 설계할 수 있습니다.
    2. API 명세서, ERD, SQL을 작성할 수 있습니다.
    3. Spring Boot를 기반으로 CRUD(Create, Read, Update, Delete) 기능이 포함된 REST API를 만들 수 있습니다.
 
- **API 실행 및 테스트 하기!**
    - 과제를 진행 하시면서 여러분들이 개발한 API가 요구사항에 맞게 동작 하는지 확인하려면 API가 반환하는 반환(결과) 값을 계속해서 확인하셔야 합니다.
    - 이때, 더 쉽게 확인 하실 수 있는 도구가 있는데 바로 Postman 입니다. 사용법은 아래 페이지에서 꼭 확인해주세요!
    
    [Postman사용법](https://www.notion.so/Postman-be0d729a230b4b1288be5a1eda8f91bc?pvs=21)
    
- **주의사항 및 참고!**
    - Entity를 그대로 반환하지 말고, DTO에 담아서 반환해주세요!
        - 최근에는 프론트엔드와 백엔드가 느슨하게 결합하는 환경이 더 일반적입니다.
        - 따라서 앞으로 남은 강의 예제와 실습에서는 html/css/js, 즉 View 도 같이 반환 하겠지만 과제에서는 여러분들이 서버 로직에 더 집중하실 수 있도록 JSON을 반환하는 API 형태로 진행하려고 합니다.
        
        [왜? 우리는 DTO를 사용해야할까?](https://www.notion.so/DTO-72e0c55fe8eb43af83ae8b0ef1ba2ada?pvs=21)
        
    - **ResponseEntity**
        - ResponseEntity는 Spring Framework에서 제공하는 클래스 중 하나로 HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하고 있는 클래스입니다.
        - HTTP 요청에 대한 응답을 처리할 때 해당 클래스를 사용하면 유연하고 편리하게 처리할 수 있습니다.
            
            [ResponseEntity (Spring Framework 6.0.12 API)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html)
            
            [Spring ResponseEntity - Using ResponseEntity in Spring Application](https://www.javaguides.net/2019/08/spring-responseentity-using-responseentity-in-spring-application.html)
            
            [Example usage for org.springframework.http ResponseEntity ok](http://www.java2s.com/example/java-api/org/springframework/http/responseentity/ok-1-0.html)
          


| 기능       | Method | URL                | return                   |
|----------|--------|--------------------|--------------------------|
| 스케줄 생성하기 | POST   | /api/scedules      | SceduleResponseDto       |
| 스케줄 조회하기 | GET    | /api/scedules      | List<SceduleResponseDto> |
| 스케줄 수정하기 | PUT    | /api/scedules/{id} | Long updateSchedules |
| 스케줄 삭제하기 | DELETE | /api/scedules/{id} | Long deleteSchedules |


<img width="237" alt="스크린샷 2024-08-16 10 53 40" src="https://github.com/user-attachments/assets/0e584051-c94e-4011-9691-441fc8d91081">



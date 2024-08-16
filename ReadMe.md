| 기능       | Method | URL                | return                   |
|----------|--------|--------------------|--------------------------|
| 스케줄 생성하기 | POST   | /api/scedules      | SceduleResponseDto       |
| 스케줄 조회하기 | GET    | /api/scedules      | List<SceduleResponseDto> |
| 스케줄 수정하기 | PUT    | /api/scedules/{id} | Long updateSchedules |
| 스케줄 삭제하기 | DELETE | /api/scedules/{id} | Long deleteSchedules |
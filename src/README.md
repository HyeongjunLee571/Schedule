## 일정 API 설계

| Aa 기능 | Method | URl                         | request                                                                                                                                                                                       | response                                                                                                                                                                                               | 상태코드     |
|-------|--------|-----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| 일정 작성 | POST   | /api/schedules              | 요구값 : <br/>"name" : "이형준",<br/>"password" : 12345,<br/>"verifyPassword" : 12345,<br/>"title" : "나의 일상",<br/>"contents" : "몰라 고기 땡긴다."<br/>"date": "2025-05-15",<br/>"time": "03:36:32.268798" | 응답값 : <br/>"name" : "이형준",<br/>"password" : 12345,<br/>"verifyPassword" : 12345,<br/>"title" : "나의 일상",<br/>"contents" : "몰라 고기 땡긴다.",<br/>"date": "2025-05-15",<br/>"time": "03:36:32.268798"         | 200:정상등록 |
| 일정 수정 | PUT    | /api/schedules/{scheduleId} | 요구값 : <br/>"name" : "이형준2",<br/>"contents" : "자고싶다"                                                                                                                                           | 응답값 : <br/>"name" : "이형준2",<br/>"password" : 12345,<br/>"verifyPassword" : 12345,<br/>"title" : "나의 일상",<br/>"contents" : "자고싶다"<br/>"date": "2025-05-15",<br/>"time": "03:36:32.268798"               | 200:정상수정 |
| 일정 조회 | GET    | /api/schedules/{scheduleId} | 요구값 : schedule Id                                                                                                                                                                             | 응답값 : <br/>"id" : 1,<br/>"name" : "이형준",<br/>"password" : 12345,<br/>"verifyPassword" : 12345,<br/>"title" : "나의 일상",<br/>"contents" : "몰라 고기 땡긴다."<br/>"date": "2025-05-15",<br/>"time": "03:36:32.268798" | 200:정상조회 |
| 일정 삭제 | DELETE | /api/schedules/{scheduleId} | 요구값 : schedule Id                                                                                                                                                                             | 응답값 : -                                                                                                                                                                                                | 200:정상삭제 |

* 조회 및 삭제는 매개변수에 있는 값을 조회해서 출력 하거나 매개변수 안에 값을 삭제하기에 요구값이 매개변수임
* 반면 등록 및 삭제는 첫 등록 즉 변수에 값을 담는것은 body에서 진행하고 화면에 값을 추가하거나 해당 값을 수정하거나
  할때는 body에서 진행됨


##필수과제 ERD
![ERD1](./C:\Users\user\Desktop/ERD1.png)




##도전과제 ERD
![ERD2](https://erd-cloud.s3.amazonaws.com/upload/EmaLDtDg9vgnFssgn/amFoS05IUzJQaUMzVzVuYnFfZmh1b1dzQVFaTkRKYU54dG0ucG5n)
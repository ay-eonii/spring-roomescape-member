## 기능 요구 사항

### 1단계

- [x] 0단계에서 이전 미션의 코드를 옮겨와도 어드민 페이지에서 기능이 정상적으로 동작하지 않습니다.
    -[x] 이를 보완하기 위해 시간 관리, 예약 관리 API가 적절한 응답을 하도록 변경합니다.
-[ ] 발생할 수 있는 예외 상황에 대한 처리를 하여, 사용자에게 적절한 응답을 합니다.
    -[x] 시간 생성 시 시작 시간에 유효하지 않은 값이 입력되었을 때
        - "", null, "   "
    -[x] 예약 생성 시 예약자명, 날짜, 시간에 유효하지 않은 값이 입력 되었을 때
    -[x] 특정 시간에 대한 예약이 존재하는데, 그 시간을 삭제하려 할 때
    -[x] 중복된 예약 시간 생성하려고 할 때
    -[x] 등등
-[x] 아래와 같은 서비스 정책을 반영합니다.
    -[x] 지나간 날짜에 대한 예약 생성은 불가능하다.
    -[x] 지나간 시간에 대한 예약 생성은 불가능하다.
    -[x] 중복 예약은 불가능하다.
        -[x] ex. 이미 4월 1일 10시에 예약이 되어있다면, 4월 1일 10시에 대한 예약을 생성할 수 없다.
-[x] 어드민의 시간 관리 페이지, 방탈출 예약 페이지에서 모든 기능이 정상적으로 동작하는지 확인합니다.

### 2단계

- [x] 방탈출 게임은 '테마' 라는 정보를 포함합니다. 사용자 예약 시 원하는 테마를 선택할 수 있도록 테마 도메인을 추가합니다.
- [ ] 모든 테마는 시작 시간과 소요 시간이 동일하다고 가정합니다.
- [ ] 관리자가 테마를 관리할 수 있도록 기능을 추가합니다.
- [ ] 관리자가 방탈출 예약 시, 테마 정보를 포함할 수 있도록 기능을 변경합니다.

## 회고

+ 시간을 잘 지키자
+ dataFormatException 처리
+ 좋은 개발

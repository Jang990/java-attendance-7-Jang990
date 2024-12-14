# java-attendance-precourse

## 구현 기능 목록
- 닉네임 리더
- 시간 리더
- 날짜 리더


- 출석 기록
  - 결석 횟수 조회
  - 지각 횟수 조회
  - 출석 기록 toString `- 빙티: 결석 3회, 지각 2회 (면담)`

- 출석 시간
  - 출석 시간 toString `12월 02일 월요일 13:00 (출석)`
  - 출석 상태 확인
    - 출석, 지각, 결석

  
- 출석 정보 리더
  - 닉네임 입력 `닉네임을 입력해 주세요.`, `이든`
  - 등교시간 입력 `등교 시간을 입력해 주세요.`, `09:59`
  - 이미 출석을 하였는데 다시 출석 확인 `[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.`

- 출석 기능
  - 출석 내역 저장
  - 출석 여부 확인

- 출석 수정
  - 닉네임 입력 `출석을 수정하려는 크루의 닉네임을 입력해 주세요.`, `빙티`
  - 수정 날짜 입력 `수정하려는 날짜(일)를 입력해 주세요.`,`3`
  - 변경 시간 입력 `언제로 변경하겠습니까?`, `09:58`
  - 변경 전후 출석 기록 출력 `12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!`

- 크루별 출석 기록 확인
  - 닉네임 입력 `닉네임을 입력해 주세요.`, `빙티`
  - 출석 기록 출력 `...`

- 제적 위험자 확인
  - 제적 위험자는 제적 대상자, 면담 대상자, 경고 대상자순으로 출력
  - 항목별 정렬 순서는 지각을 결석으로 간주하여 내림차순
  - 출석 상태가 같으면 닉네임으로 오름차순 정렬

- 예외 출력
  - 기능 선택 항목, 날짜 또는 시간을 잘못된 형식으로 입력 `[ERROR] 잘못된 형식을 입력하였습니다.`
  - 등록되지 않은 닉네임을 입력 `[ERROR] 등록되지 않은 닉네임입니다.`
  - 주말 또는 공휴일에 출석을 확인하거나 수정 `[ERROR] 12월 14일 토요일은 등교일이 아닙니다.`
  - 미래 날짜로 출석을 수정 `[ERROR] 아직 수정할 수 없습니다.`
  - 등교 시간이 캠퍼스 운영 시간이 아님 `[ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다.`



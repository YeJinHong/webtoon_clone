# TID (Today I Done)
## 3월 29일
- SpringBoot 프로젝트 생성
	- Gradle 의존성 적용되지 않는 문제 해결
	(SpringBoot 버전에 따른 Java 버전 문제)
	- Spring Data JPA 적용 시 필요한 datasource 설정 작성 

## 3월 30일
- datasource 설정 에러 `public key retrieval is not allowed` 해결
	- spring.datasource.url 파라미터에 allowPublicKeyRetrieval=true 추가
- SpringBoot 패키지 계층형 구조 초기화 [[참고블로그](allowPublicKeyRetrieval=true)]

## 4월 3일
- H2 Database 테스트용 코드 작성
- @Slf4j관련 에러 발생 `error: cannot find symbol`
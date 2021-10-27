# batchStudy


#### @EnableBatchProcessing 
: 스프링 배치가 작동하기 위해 선언해야 하는 어노테이션
 - 총 4개의 설정 클래스를 실행시키며 스프링 배치의 모든 초기화 및 실행 구성이 이루어진다.
 - 스프링 부트 배치의 설정 클래스가 실행됨으로 빈으로 등록된 모든 job을 검색해서 
   초기화와 동시에 job을 수행하도록 구성 됨.

### !스프링 배치 초기화 설정 클래스
#### BatchAutoConfiguration
- 스프링 배치가 초기화 될때 자동으로 실행되는 설정 클래스
- Job을 수행하는 JobLauncherApplicationRunnre 빈을 생성

#### SimpleBatchConfiguration
- JobBuilderFactory 와 StepBuilderFactory 생성
- 스프링 배치가 초기화 될때 자동으로 실행되는 설정 클래스
 
#### BatchConfigurerConfiguration
- BasicBatchConfigurer
  - SimpleBatchConfiguration 에서 생성한 프로식 객체의 실제 대상 객체를 생성하는 설정 클래스
  - 빈으로 의존성 주입을 받아서 주요 객체들을 참조해서 사용할 수 있다.
- JpaBatchConfigurer
  - Jpa 관련객체를 생성하는 설정 클래스

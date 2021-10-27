# batchStudy

<center>@EnableBatchProcessing</center>
<center>↓</center>
<center>SimpleBatchConfiguration</center>  
<center>↓</center>
<center>BatchConfigurerConfiguration
<br/>- BasicBatchConfigurer
<br/>- JpaBatchConfigurer</center>
<center>↓</center>
<center>BatchAutoConfiguration</center>

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
- 사용자 정의 BatchConfigurer 인터페이스를 구현하여 사용할 수 있음

### !스프링 배치 시작

#### 1. @Configuration 선언
- 하나의 배치 job을 정의하고 빈 설정
#### 2. JobBuilderFactory 
- job을 생성하는 빌더 팩토리
#### 3. StepBuilderFactory
- Step 생성하는 빌더 팩토리
#### 4. Job
- helloJob 이름으로 Job 생성
#### 5. Step
- helloStep 이름으로 Step 생성
#### 6. tasklet
- Step 안에서 단일 태스크로 수행되는 로직 구현
#### 7. Job 구동 > Step 실행 > Tasklet 실행

# batchStudy

----------------------------------------------------

@EnableBatchProcessing<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓<br/>
SimpleBatchConfiguration<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓<br/>
BatchConfigurerConfiguration
<br/>- BasicBatchConfigurer
<br/>- JpaBatchConfigurer<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓<br/>
BatchAutoConfiguration

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
----------------------------------------------------
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

----------------------------------------------------

### !스프링 배치 메타 데이터
: 스프링 배치의 실행 및 관리를 위한 목적으로 여러 도메인들(Job, Step, JobParameters..)  의 정보들을 저장, 업데이트, 조회할 수 있는 스키마 제공<br/>
DB 와 연동할 경우 필수적으로 메타 테이블이 생성 되어야 함

#### - Job  관련 테이블
#### BATCH_JOB_INSTANCE
- Job 이 실행될 때 JobInstance 정보가 저장되며 job_name과 job_key를 키로 하여 하나의 데이터가 저장
동일한 job_name 과 job_key 로 중복 저장될 수 없다

#### BATCH_JOB_EXECUTION
- job 의 실행정보가 저장되며 Job 생성, 시작, 종료 시간,  실행상태, 메시지 등을 관리

#### BATCH_JOB_EXECUTION_PARAMS
- Job과 함께 실행되는 JobParameter 정보를 저장

#### BATCH_JOB_EXECUTION_CONTEXT
- Job 의 실행동안 여러가지 상태정보, 공유 데이터를 직렬화 (Json 형식) 해서 저장
Step 간 서로 공유 가능함

#### - Step  관련 테이블
#### BATCH_STEP_EXECUTION
- Step 의 실행정보가 저장되며 생성, 시작, 종료 시간,  실행상태, 메시지 등을 관리

#### BATCH_STEP_EXECUTION_CONTEXT
- Step 의 실행동안 여러가지 상태정보, 공유 데이터를 직렬화 (Json 형식) 해서 저장
Step 별로 저장되며 Step 간 서로 공유할 수 없음

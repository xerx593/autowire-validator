# autowire-validator

Solution code for:
- [Cannot Autowired a beans into customized validator](https://stackoverflow.com/q/70065756/592355) and
- [Inject Service in ConstraintValidator [Bean Validator - JSR 303] Spring](https://stackoverflow.com/q/13350537/592355)

Shows how to auto wire a "spring bean" (`MyService`) into a `javax.validation.ConstraintValidator`.

### Run tests

    mvn clean test
    
### Run application

    mvn spring-boot:run
    
### Use Endpoint

    curl -X POST http://localhost:8080/some \
     -H 'Content-Type: application/json' \
     -d '{"name": "john","email": "john.doe@localhost","custom": "heLLo"}' 
     
    


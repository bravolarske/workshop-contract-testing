# Setup

The customer asks for a api call to `/api/meal-vouchers/{id}`.

He wants the producer  balance of your meal-vouchers.

REQUEST GET `/api/meal-vouchers/{id}`.

```
{
    amount: 80,
    endDate: '1996-12-02' //YYYY-MM-DD
}
```

Steps to create:

1. Add contract testing libraries to `pom.xml` `producer`.

```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-contract-verifier</artifactId>
        <scope>test</scope>
        <version>3.1.4</version>
    </dependency>
    ...
</dependencies>
...
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-contract-maven-plugin</artifactId>
            <version>3.1.4</version>
            <extensions>true</extensions>
            <configuration>
                <baseClassForTests>com.axxes.producer.BaseTestClass</baseClassForTests>
            </configuration>
        </plugin>
        ...
    </plugins>
    ...
</build>
```

✅ `mvn clean install` in `consumer` works.

2. Adding contract testing to `pom.xml` `consumer`.

```
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-contract-stub-runner</artifactId>
        <version>2.1.1.RELEASE</version>
        <scope>test</scope>
    </dependency>
    ...
</dependencies>
```

✅ `mvn clean install` in `consumer` works.

# Add contract on producer-Side
3. Create contract in producer.

You can find an example contract in [this file](./find_hat_by_id.groovy). This is a contract for the HAT api, which has an id, name, size and color.

Write contract in `producer/test/resources/contracts/xxx.groovy` for the mealvoucher class.

This should be placed under `/producer/contracts/contract.groovy`.

✅ `mvn clean install --skipTests` works and in target a stubs jar has been created.
--OPTIONAL: check in .m2 if stubs jar has been created.

# Add test on consumer-Side

4. Create test in consumer.

Add a java class under `/consumer/test`.

Add annotation above class.

```
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {
        "com.axxes:producer:+:stubs:8095" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
```

`com.axxes:producer:+:stubs:8095`

```
8095 -> Port of stub runner

+ -> you can specify version of stub package generated in .m2
  
com.axxes:producer -> package of maven pom.
```


Add with mvcMock call to mock of produced contract. 

Url : localhost:8095

✅ Run test.


# Make generated test on producer side work

❌ run test should fail in producer.

test is found under `/producer/generated-test-sources`

Create the endpoint with the expected value in the contract.

✅ Run test, it should now work.


# Change soo it works with a mock repository

Change value in repository.

❌ run test should fail in producer.

change BaseTestClass too mock Repository.

✅ Run test, it should now work.

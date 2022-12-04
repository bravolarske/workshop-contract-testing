# Writing a consumer contract

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

3. Create contract in producer.

Write contract in `producer/test/resources/contracts/xxx.groovy`.

✅ `mvn clean install` works and in target a stubs jar has been created.
--OPTIONAL: check in .m2 if stubs jar has been created.

4. Create test in consumer.

Add a java class under test.

Add annotation above class.

```
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {
        "com.axxes.producer:*:stubs" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
```

Add with mvcMock call to mock of produced contract.

✅ Run test. If successful to [oef_2](./oef_2.md).
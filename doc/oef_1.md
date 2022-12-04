# Writing a consumer contract

The customer asks for a api call to `/meal-vouchers`.

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

1. Adding contract testing to `pom.xml` `consumer`.

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

1. Create contract in producer. (FOR NOW)
2. Create test in consumer.

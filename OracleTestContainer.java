package com.example.demo;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class OracleTestContainer {


    @Container
    public OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe")//"phx.ocir.io/toddrsharp/oracle-db/oracle/database:18.4.0-xe"
            .withEnv("ORACLE_PWD", "Str0ngPassw0rd")
            .withStartupTimeoutSeconds(900)
            .withConnectTimeoutSeconds(900)
//            .withInitScript()
            .withPassword("Str0ngPassw0rd");

    // @Container
    //    public GenericContainer redis = new
    // GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
    //                                            .withExposedPorts(6379);

    @BeforeEach
    void beforeEach() {
        oracle.start();
    }

    @AfterEach
    void afterEach() {
        oracle.stop();
    }

    @Test
    void testOracleStartUp(){
        String url = oracle.getJdbcUrl();
        System.out.println("url = " + url);
    }

}

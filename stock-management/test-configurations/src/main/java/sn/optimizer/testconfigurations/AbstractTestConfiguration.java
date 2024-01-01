package sn.optimizer.testconfigurations;


import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class AbstractTestConfiguration {

    protected static final PostgreSQLContainer<?> psqlTestContainer=new PostgreSQLContainer<>("postgres")
            .withDatabaseName("stock-test")
            .withUsername("test_user")
            .withPassword("password");

}

package br.com.arquivei.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Primary
@Configuration
@Profile("unit-test")
public class TestConfiguration {

//    @Bean
//    @Primary
//    public VoucherRepository voucherRepositoryStub() {
//        return new VoucherRepositoryStub();
//    }
//
//    @Bean
//    @Primary
//    public AclRepository aclRepositoryStub() {
//        return new AclRepositoryStub();
//    }
//
//    @Bean
//    @Primary
//    public CustomerRepository customerRepositoryStub() {
//        return new CustomerRepositoryStub();
//    }

}

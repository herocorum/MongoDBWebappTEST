package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
@Configuration
//@ComponentScan(basePackageClasses = {MongoDBApp.class})
//@PropertySource("classpath:application.properties")
@EnableMongoRepositories
//(basePackageClasses=RepositoryPackage.class)
//@ComponentScan(basePackageClasses=TemplatePackage.class)
@ComponentScan(basePackages = "test")
public class MongoConfiguration extends AbstractMongoConfiguration{


    @Override
    protected String getDatabaseName() {
        return "yourdb";
    }
    
    @Override
    @Bean
    public MongoClient mongo() throws Exception {
        MongoClient client = new MongoClient("127.0.0.1");
        client.setWriteConcern(WriteConcern.SAFE);
        return client;
    }
    
    //SUAN ISE YARAMIYOR
    @Override
    @Bean
    protected String getMappingBasePackage() {
        return "test";
    }
  // ---------------------------------------------------- MongoTemplate
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
    
    

//  public Mongo mongo2() throws Exception {
//      return new Mongo();
//  }
    
}
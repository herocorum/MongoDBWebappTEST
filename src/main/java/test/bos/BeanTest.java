package test.bos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

//import test.MongoConfiguration;
//import test.model.Person;
//import test.repository.MongoTestRepository;
//@Component
//public class test {
//	
//	  
//	public static void main(String[] args) {
//
//       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
//        
//       MongoTestRepository repo = ctx.getBean(MongoTestRepository.class);
//        
//        Person[] persons = new Person[] {
//                new Person(1, "tayfun","celik"),
//                new Person(2, "tolga","celik"),
//                new Person(3, "ahmet","celik")
//            };
//            
//            // save multiple entities
//        repo.save(Arrays.asList(persons));
//            ctx.close();
//        
//	}
//}

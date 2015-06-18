//package testClasses;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import test.dao.PersonDAO;
//import test.model.Person;
//
//import com.mongodb.DB;
//import com.mongodb.MongoClient;
//
//import de.flapdoodle.embed.mongo.MongodExecutable;
//import de.flapdoodle.embed.mongo.MongodProcess;
//import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.config.IMongodConfig;
//import de.flapdoodle.embed.mongo.config.MongoCmdOptionsBuilder;
//import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
//import de.flapdoodle.embed.mongo.config.Net;
//import de.flapdoodle.embed.mongo.distribution.Version;
//
//public  class AbstractMongoDbTest {
//	
//	final static Logger logger = Logger.getLogger(AbstractMongoDbTest.class);
//	
//	private static MongodProcess mongodProcess;
//	private static MongodExecutable mongodExecutable;
//	private static final String IP = "127.0.0.1";
//	private static final int PORT = 27017;
//	private static final String DB_NAME = "test";
//
//
//    @Autowired
//    private PersonDAO personDAO;
//
//    
//    @Before
//	public  void beforeClass() throws IOException {
//		MongodStarter starter = MongodStarter.getDefaultInstance();
//		IMongodConfig mongodConfig = new MongodConfigBuilder()
//			.version(Version.Main.PRODUCTION)
//			.net(new Net(IP, PORT, false))
//			.cmdOptions(new MongoCmdOptionsBuilder()
//			.useSmallFiles(true)
//			.useNoJournal(true)
//			.useNoPrealloc(true)
//			.build()).build();
//		 
//		mongodExecutable = starter.prepare(mongodConfig);
//	 
//		mongodProcess = mongodExecutable.start();
//		logger.info("Mongo DB started" );
//		
//	 	personDAO = mock(PersonDAO.class);
//	}
//
// 
//	@After
//	public void after() throws Exception{
//		 
//		MongoClient client = new MongoClient(IP, PORT);
//		DB db = client.getDB(DB_NAME);
//		db.dropDatabase();
//		client.close();
//		 
//	}
//
// 
//	@AfterClass
//	public static void destroyMongodInstance() throws UnknownHostException {
// 
//		logger.warn("I am closing MongoDB...");
//		if (mongodProcess != null) {
//			mongodProcess.stop();
//		}
//	 
//		if (mongodExecutable != null) {
//			mongodExecutable.stop();
//		}
//
//		logger.warn("  MongoDB closed ...");
//	 
//	}
//	
//	   @Test
//	   public void testCreate() {
//	       Person person = new Person();
//	       person.setId(1L);
//	       person.setName("test");
//	       person.setSurName("test");
//	       personDAO.create(person);
//
//
//	       when(personDAO.get(1L)).thenReturn(person);
//	     
//	       
//	       Person newPerson = personDAO.get(person.getId());
//	       
//	       Assert.assertEquals(person.getId(), newPerson.getId());
//	       
//	   }
//	   
//	   
//
//}
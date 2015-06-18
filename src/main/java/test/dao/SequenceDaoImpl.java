package test.dao;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import test.model.SequenceId;




public class SequenceDaoImpl implements SequenceDao{

	final static Logger logger = Logger.getLogger(SequenceDaoImpl.class);
	
	
//	@Autowired 
//	private MongoOperations mongo;
	private MongoTemplate mongoTemplate;

	public long getNextSequenceId(String key) throws SequenceException {

		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);

		if (seqId == null) {
			logger.fatal("Unable to get sequence id for key: " + key);
			throw new SequenceException("Unable to get sequence id for key : " + key);
		}

		logger.info("sequence id succesfully created");
		return seqId.getSeq();
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	 
}

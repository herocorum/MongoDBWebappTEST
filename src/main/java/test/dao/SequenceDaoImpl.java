package test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;
//@Repository
public class SequenceDaoImpl implements SequenceDao{

//	@Autowired
//	private MongoOperations mongo;
	private MongoTemplate mongoTemplate;

	//shortway
//	public long getNextSequence(String collectionName) {
//		SequenceId counter = mongo.findAndModify(
//				query(where("_id").is(collectionName)),
//				new Update().inc("seq", 1), 
//				options().returnNew(true),
//				SequenceId.class);
//	       
//	    return counter.getSeq();
//	  }
//	
	//clear way
	public long getNextSequenceId(String key) throws SequenceException {

		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);

		if (seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeq();
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	 
}

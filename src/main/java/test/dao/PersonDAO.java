package test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.model.Person;
import test.model.SequenceId;

@Repository
public class PersonDAO {
//    @Autowired    private MongoOperations mongoOperations;
	
	 @Autowired 
    private MongoTemplate mongoTemplate;

    public Person  create (Person person) {
    	person.setId(getUniqueId());
    	mongoTemplate.save (person);
    	
    	return get(person.getId());
    }

    public void update(Person person) {
    	mongoTemplate.save (person);
	}
    
    public Person get (Long id) {
        return mongoTemplate.findOne (Query.query (Criteria.where ("_id").is (id)), Person.class);
    }
    @Transactional
    public List<Person> getAll () {
        return mongoTemplate.findAll (Person.class);
    }

    public void remove (Long id) {
    	mongoTemplate.remove (Query.query (Criteria.where ("_id").is (id)), Person.class);
    }

    /**
     * 
     * @param key
     * @return
     * @throws SequenceException
     * I am getting all data form db and
     * I am try to find biggest id which is in MongoDB
     * and I will increase by 1 that id
     * after I will assign as an id to my new object
     * 
     */
    public long getNextSequenceId(String key) throws SequenceException {

    	Query query = new Query(Criteria.where("_id").is("1"));

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

    public Long getUniqueId(){
    	
    	List<Person> personList = getAll();
    	List<Long> idList = new ArrayList<Long>();
    	
    	if(personList.size()<1)
    		return Long.parseLong("1");
    	
    	for (Person person : getAll()) {
    		idList.add(person.getId());
		}
     
    	Long maxId=null;
    	if(idList.size()>0)
    		maxId= sorted(idList);
    	
    	return maxId+1;
    }
    
    public Long sorted(List<Long> persons){
    	
    	Long maxValue =Long.parseLong("1");
    	
    	for (Long personID : persons) {
    		if(maxValue<personID)
    			maxValue=personID;
		}
    	
		return maxValue;
    }

}
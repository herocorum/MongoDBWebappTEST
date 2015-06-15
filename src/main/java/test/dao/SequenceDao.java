package test.dao;

public interface  SequenceDao {
 
	
	long getNextSequenceId(String key) throws SequenceException;

//	public long getNextSequence(String collectionName);
}
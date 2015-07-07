package com.ktds.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDAO {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void insertTextVO() {
		TestVO testVO = new TestVO();
		
		testVO.setName("고길동");
		testVO.setJob("부처");
		
		mongoTemplate.insert(testVO, "person");
	}
	
	public class TestVO {
		@Id
		private String id;
	
		private String name;
		private String job;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String jbo) {
			this.job = jbo;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}
}

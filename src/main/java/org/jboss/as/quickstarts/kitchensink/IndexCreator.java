package org.jboss.as.quickstarts.kitchensink;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

@Component
public class IndexCreator {

	@Bean
	CommandLineRunner ensureIndexes(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
		return args -> {
			IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
			IndexOperations indexOps = mongoTemplate.indexOps(Member.class);
			resolver.resolveIndexFor(Member.class).forEach(indexOps::ensureIndex);
		};
	}
}

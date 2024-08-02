package org.jboss.as.quickstarts.kitchensink.data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Aggregation;
import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {

    // Find a member by their ID
    Optional<Member> findById(String id);

    // Find all members ordered by their name
    List<Member> findAll(Sort sort);

    // Find a member by their email
    Optional<Member> findByEmail(String email);

    // Custom query to find all members ordered by name
    @Query("{}")
    List<Member> findAllOrderedByName(Sort sort);

    // Custom method to delete a member by email
    void deleteByEmail(String email);

    // Optional: Paginate results if needed
    Page<Member> findAll(Pageable pageable);

    // Optional: Custom query using Aggregation
    @Aggregation(pipeline = {
        "{ $sort: { name: 1 } }" // Sort by name in ascending order
    })
    List<Member> findAllSortedByName();
}


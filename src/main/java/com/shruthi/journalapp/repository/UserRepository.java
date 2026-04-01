package com.shruthi.journalapp.repository;

import com.shruthi.journalapp.entity.JournalEntry;
import com.shruthi.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);
    void deleteByUserName(String username);
}

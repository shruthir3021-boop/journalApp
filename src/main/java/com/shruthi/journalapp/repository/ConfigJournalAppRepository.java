package com.shruthi.journalapp.repository;

import com.shruthi.journalapp.entity.ConfigJournalAppEntity;
import com.shruthi.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}

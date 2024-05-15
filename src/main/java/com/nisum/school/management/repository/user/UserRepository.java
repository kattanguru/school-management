package com.nisum.school.management.repository.user;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.nisum.school.management.model.User;
import reactor.core.publisher.Flux;

public interface UserRepository extends FirestoreReactiveRepository<User> {

    Flux<User> findByCountry(String country);

}

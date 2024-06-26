package com.nisum.school.management.service.impl;

import com.nisum.school.management.model.User;
import com.nisum.school.management.repository.user.UserRepository;
import com.nisum.school.management.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> save(User user) {

        return userRepository.save(user);
    }

    @Override
    public Mono<User> delete(String id) {

        return this.userRepository
                .findById(id).flatMap(p ->
                        this.userRepository
                                .deleteById(p.getId())
                                .thenReturn(p));
    }

    @Override
    public Mono<User> update(String id, User user) {

        return this.userRepository.findById(id)
                .flatMap(u -> {
                    u.setId(id);
                    u.setEmail(user.getEmail());
                    u.setName(user.getName());
                    u.setCountry(user.getCountry());
                    return save(u);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }
}

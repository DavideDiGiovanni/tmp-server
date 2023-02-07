package com.tmpserver.tmpserver.mock;

import com.tmpserver.tmpserver.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockedUserRepository {

    private final List<User> studentList;

    public MockedUserRepository() {
        studentList = new ArrayList<>(List.of(
                new User(
                        "davide.digiovanni@sysconsgroup.com",
                        "Davide",
                        "Di Giovanni",
                        "password12"
                ),
                new User(
                        "marco.baratto@sysconsgroup.com",
                        "Marco",
                        "Baratto",
                        "password34"
                )
            )
        );
    }

    public Optional<User> findById(String id) {
        return studentList.stream()
                .filter(student -> student.getEmail().equals(id))
                .findFirst();
    }

    public List<User> findAll() {
        return studentList;
    }

    public void save(User user) {
        studentList.add(user);
    }
}

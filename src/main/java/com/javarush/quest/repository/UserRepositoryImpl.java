package com.javarush.quest.repository;

import com.javarush.quest.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User registerUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
        return users.get(name);
    }

    @Override
    public void addWinning(User user) {
        user.setWinsCount(user.getWinsCount() + 1);
    }

    @Override
    public void addLosing(User user) {
        user.setLossesCount(user.getLossesCount() + 1);
    }
}

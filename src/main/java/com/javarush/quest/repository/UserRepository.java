package com.javarush.quest.repository;

import com.javarush.quest.model.User;

public interface UserRepository {
    User registerUser(String name);
    void addWinning(User user);
    void addLosing(User user);
}


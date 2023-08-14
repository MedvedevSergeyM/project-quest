package com.javarush.quest.services;

import com.javarush.quest.model.*;
import com.javarush.quest.repository.QuestRepository;
import com.javarush.quest.repository.QuestRepositoryImpl;
import com.javarush.quest.repository.UserRepository;
import com.javarush.quest.repository.UserRepositoryImpl;

public enum QuestService {

    QUEST_SERVICE;

    private final QuestRepository questRepository = new QuestRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();

    public User registerUser(String name) {
        return userRepository.registerUser(name);
    }

    public Situation getSituation(long id) {
        return questRepository.getSituation(id);
    }

    public Option selectOption(long id, User user) {
        Option option = questRepository.getOption(id);
        if (option instanceof OptionWinning) {
            userRepository.addWinning(user);
        } else if (option instanceof OptionLosing) {
            userRepository.addLosing(user);
        }
        return option;
    }
}


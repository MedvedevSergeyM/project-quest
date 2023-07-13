package com.javarush.quest.services;

import com.javarush.quest.model.Quest;
import com.javarush.quest.repository.QuestRepository;
import com.javarush.quest.repository.QuestRepositoryImpl;

import java.util.Collection;
import java.util.Optional;

public enum QuestService {

    QUEST_SERVICE;

    private final QuestRepository questRepository = new QuestRepositoryImpl();

    public Collection<Quest> getAll() {
        return questRepository.getAll();
    }

    public Optional<Quest> get(long id) {
        return questRepository.get(id);
    }

    public String getVictoryMessage() {
        return questRepository.getVictoryMessage();
    }

}

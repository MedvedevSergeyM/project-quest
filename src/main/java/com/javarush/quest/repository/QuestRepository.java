package com.javarush.quest.repository;

import com.javarush.quest.model.Quest;

import java.util.Collection;
import java.util.Optional;

public interface QuestRepository {

    Collection<Quest> getAll();
    Optional<Quest> get(long id);
    String getVictoryMessage();

}

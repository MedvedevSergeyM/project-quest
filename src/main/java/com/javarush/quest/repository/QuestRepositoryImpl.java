package com.javarush.quest.repository;

import com.javarush.quest.model.Quest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QuestRepositoryImpl implements QuestRepository {

    private final Map<Long, Quest> map = new HashMap<>();
    private final String victoryMessage;

    public QuestRepositoryImpl() {
        victoryMessage = "Тебя вернули домой. Победа";

        map.put(0L, new Quest(
                0,
                "Ты потерял память. Принять вызов НЛО?",
                "Принять вызов",
                "Отклонить вызов",
                "Ты отклонил вызов. Поражение",
                1)
        );
        map.put(1L, new Quest(
                1,
                "Ты принял вызов. Поднимаешься на мостик к капитану?",
                "Подняться на мостик",
                "Отказаться подниматься на мостик",
                "Ты не пошел на переговоры. Поражение",
                2)
        );
        map.put(2L, new Quest(
                2,
                "Ты поднялся на мостик. Ты кто?",
                "Рассказать правду о себе",
                "Солгать о себе",
                "Твою ложь разоблачили. Поражение",
                -1)
        );
    }

    @Override
    public String getVictoryMessage() {
        return victoryMessage;
    }

    @Override
    public Collection<Quest> getAll() {
        return map.values();
    }

    @Override
    public Optional<Quest> get(long id) {
        return Optional.ofNullable(map.get(id));
    }
}

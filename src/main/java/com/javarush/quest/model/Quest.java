package com.javarush.quest.model;

import lombok.Data;

@Data
public class Quest {

    private final long id; // 0 - начало квеста, -1 - завершение квеста, n - шаг квеста
    private final String question; // вопрос
    private final String answerRight; // правильный ответ, победа или следующий шаг
    private final String answerLeft; // НЕправильный ответ, поражение
    private final String defeat; // Текст поражения
    private final long nextId; // следующий шаг квеста

}

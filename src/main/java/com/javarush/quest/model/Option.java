package com.javarush.quest.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

// Вариант
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Option extends BaseEntity {

    public Option(long id, String text) {
        super(id, text);
    }

}

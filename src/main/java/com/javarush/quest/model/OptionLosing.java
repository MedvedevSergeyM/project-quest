package com.javarush.quest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Проигрышный вариант
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OptionLosing extends Option {

    @Getter
    private final String message;

    public OptionLosing(long id, String text, String message) {
        super(id, text);
        this.message = message;
    }

}

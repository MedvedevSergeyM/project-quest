package com.javarush.quest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

// Ситуация
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Situation extends BaseEntity {

    @Getter
    List<Option> options;

    public Situation(long id, String text, List<Option> options) {
        super(id, text);
        this.options = options;
    }

}

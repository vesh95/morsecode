package ru.vesh95.core;

import java.util.Iterator;
import java.util.Map;

public class Translator {
    private final Map<String, Character> map;

    public Translator(Map<String, Character> map)
    {
        this.map = map;
    }

    public String translate(MorseCodeArticle article)
    {

        StringBuilder translated = new StringBuilder();
        article.forEach(s -> translated.append(map.get(s)));

        return translated.toString();
    }
}

package ru.vesh95.core;

import jdk.dynalink.beans.StaticClass;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class LangCollationCharBuilder {
    Map<String, Character> map = new HashMap<>();

    public LangCollationCharBuilder()
    {
        this.map.put(" ", ' ');
        this.map.put("\n", '\n');
    }

    public LangCollationCharBuilder RU() {
        this.map.put(".-", 'А');
        this.map.put("-...", 'Б');
        this.map.put(".--", 'В');
        this.map.put("--.", 'Г');
        this.map.put("-..", 'Д');
        this.map.put(".", 'Е');
        this.map.put("...-", 'Ж');
        this.map.put("--..", 'З');
        this.map.put("..", 'И');
        this.map.put(".---", 'Й');
        this.map.put("-.-", 'К');
        this.map.put(".-..", 'Л');
        this.map.put("--", 'М');
        this.map.put("-.", 'Н');
        this.map.put("---", 'О');
        this.map.put(".--.", 'П');
        this.map.put(".-.", 'Р');
        this.map.put("...", 'С');
        this.map.put("-", 'Т');
        this.map.put("..-", 'У');
        this.map.put("..-.", 'Ф');
        this.map.put("....", 'Х');
        this.map.put("-.-.", 'Ц');
        this.map.put("---.", 'Ч');
        this.map.put("----", 'Ш');
        this.map.put("--.-", 'Щ');
        this.map.put(".--.-", 'Ъ');
        this.map.put("-.--", 'Ы');
        this.map.put("-..-", 'Ь');
        this.map.put("..-..", 'Э');
        this.map.put("..--", 'Ю');
        this.map.put(".-.-", 'Я');

        return this;
    }

    @SuppressWarnings("unused")
    public LangCollationCharBuilder set(String code, Character outChar)
    {
        this.map.put(code, outChar);

        return this;
    }

    public Map<String, Character> build()
    {
        return this.map;
    }
}

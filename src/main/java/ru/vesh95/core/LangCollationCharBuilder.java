package ru.vesh95.core;

import java.util.Map;

import static java.util.Map.entry;

public class LangCollationCharBuilder {
    public static Map<String, Character> RU()
    {
        return Map.ofEntries(
                entry(".-", 'А'),
                entry("-...", 'Б'),
                entry(".--", 'В'),
                entry("--.", 'Г'),
                entry("-..", 'Д'),
                entry(".", 'Е'),
                entry("...-", 'Ж'),
                entry("--..", 'З'),
                entry("..", 'И'),
                entry(".---", 'Й'),
                entry("-.-", 'К'),
                entry(".-..", 'Л'),
                entry("--", 'М'),
                entry("-.", 'Н'),
                entry("---", 'О'),
                entry(".--.", 'П'),
                entry(".-.", 'Р'),
                entry("...", 'С'),
                entry("-", 'Т'),
                entry("..-", 'У'),
                entry("..-.", 'Ф'),
                entry("....", 'Х'),
                entry("-.-.", 'Ц'),
                entry("---.", 'Ч'),
                entry("----", 'Ш'),
                entry("--.-", 'Щ'),
                entry(".--.-", 'Ъ'),
                entry("-.--", 'Ы'),
                entry("-..-", 'Ь'),
                entry("..-..", 'Э'),
                entry("..--", 'Ю'),
                entry(".-.-", 'Я'),
                entry(" ", ' ')
        );
    }
}

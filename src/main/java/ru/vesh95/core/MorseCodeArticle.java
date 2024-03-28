package ru.vesh95.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class MorseCodeArticle implements Iterable<String> {
    private static final String ALLOWED_CHARS_PATTERN = "[^.\\- \\n]";
    private final String rawText;
    private final LinkedList<String> characters = new LinkedList<>();

    public MorseCodeArticle(String rawText)
    {
        this.rawText = this.validate(rawText);
        this.parse();
    }

    public Integer length()
    {
        return this.characters.size();
    }

    @Override
    public Iterator<String> iterator() {
        return this.characters.iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.characters.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return this.characters.spliterator();
    }

    /**
     * Save as separated items
     */
    private void parse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rawText.length(); i++) {
            if (!Character.isSpaceChar(this.rawText.charAt(i))) {
                sb.append(this.rawText.charAt(i));
            } else {
                characters.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        this.characters.add(sb.toString());
    }

    /**
     * Validate input string
     */
    private String validate(String rawText) {

        if (Pattern.compile(ALLOWED_CHARS_PATTERN).matcher(rawText).find()) {
            throw new RuntimeException("Invalid character error");
        }

        return rawText;
    }
}

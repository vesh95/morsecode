package ru.vesh95;


import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import ru.vesh95.core.LangCollationCharBuilder;
import ru.vesh95.core.MorseCodeArticle;
import ru.vesh95.core.Translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArgumentParser parser = getArgumentParser();

        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);

            System.exit(1);
        }

        Boolean verbose = ns.getBoolean("verbose");
        String inputFileName = ns.getString("file");
        String outFileName = ns.getString("out");

        String rawText = getRawString(inputFileName);

        if (verbose) System.out.println(rawText);

        Translator translator = new Translator(new LangCollationCharBuilder().RU().build());
        try {
            String translatedString = translator.translate(new MorseCodeArticle(rawText));
            if (verbose) System.out.println(translatedString);
            writeToFile(outFileName, translatedString);
        } catch (RuntimeException e) {
            System.out.println("Ошибка при переводе");
            System.exit(1);
        }
    }

    private static void writeToFile(String outFileName, String translatedString) {
        FileWriter fw;
        try {
            fw = new FileWriter(outFileName);
            fw.write(translatedString);
        } catch (IOException e) {
            System.out.println("Ошибка записи");

            System.exit(1);
        }
    }

    private static String getRawString(String inputFileName) {
        File f = new File(inputFileName);

        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");

            System.exit(1);
        }

        return sb.toString();
    }

    private static ArgumentParser getArgumentParser() {
        ArgumentParser parser = ArgumentParsers.newFor("morsecode").build()
                .defaultHelp(true)
                .description("Переводит код морзе из указанного файла и сохраняет в файл");

        parser.addArgument("-v", "--verbose").action(Arguments.storeTrue()).help("Выводить содержимое и перевод");
        parser.addArgument("file").help("Входной файл");
        parser.addArgument("out").help("Файл с переводом");
        return parser;
    }
}
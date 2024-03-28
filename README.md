# Morsecode

## Запуск
### Через Run configuration в IntelliJ IDEA
Запустить сценарий Main для запуска программы.
Будет прочитан текст из [example.txt](example.txt) и выведет его в поток, выведет перевод и сохранит его в файл [output/translate.txt](output%2Ftranslate.txt)(файл создастся после запуска).

Запустить сценарий Help для получения справки по команде. 

### Через JDK
```
java ru.vesh95.Main.class --verbose $MODULE_DIR$/example.txt $MODULE_DIR$/output/translate.txt
```
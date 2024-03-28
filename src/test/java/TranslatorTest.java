import org.junit.Assert;
import org.junit.Test;
import ru.vesh95.core.LangCollationCharBuilder;
import ru.vesh95.core.MorseCodeArticle;
import ru.vesh95.core.Translator;

public class TranslatorTest {
    @Test
    public void TranslateText()
    {
        MorseCodeArticle article = new MorseCodeArticle(".--. .-. .. .-- . - .-.- -- ..-.. - -");

        Translator translator = new Translator(new LangCollationCharBuilder().RU().build());

        Assert.assertEquals("ПриветяМэтт".toUpperCase(), translator.translate(article));
    }
}

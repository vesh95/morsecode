import org.junit.Assert;
import org.junit.Test;
import ru.vesh95.core.MorseCodeArticle;

import java.util.Iterator;

public class ArticleParserTest {
    @Test
    public void TestWithoutErrors()
    {
        MorseCodeArticle article = new MorseCodeArticle(".- -... .--");
        Assert.assertEquals(3, (int) article.length());
    }

    @Test(expected = RuntimeException.class)
    public void TestWithAlphabetErrors()
    {
        new MorseCodeArticle("-ad/f.a fsdrfs erf");
    }

    @Test(expected = RuntimeException.class)
    public void TestOnlyAlphabetErrors()
    {
        new MorseCodeArticle("adfafsdrfserf");
    }

    @Test
    public void TestParsedChars()
    {
        MorseCodeArticle article = new MorseCodeArticle(".- -... .--");
        Iterator<String> artIterator = article.iterator();
        Assert.assertEquals(".-", artIterator.next());
        Assert.assertEquals("-...", artIterator.next());
        Assert.assertEquals(".--", artIterator.next());
        Assert.assertFalse(artIterator.hasNext());
    }
}

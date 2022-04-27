package tests;

import org.junit.*;
import src.MarkdownParser;

import static org.assertj.core.api.Assertions.assertThat;


public class MarkdownParserShould {

    @Test
    public void not_parse_normal_text(){
        MarkdownParser parser = new MarkdownParser();

        assertThat(parser.parse("Hola")).isEqualTo("Hola");
    }

    @Test
    public void parse_url_text(){
        MarkdownParser parser = new MarkdownParser();

        assertThat(parser.parse("[visible text link](url)")).isEqualTo("visible text link [^anchor1]\n" + "[^anchor1]: url");
        assertThat(parser.parse("some other text [this book](https://codigosostenible.com)")).isEqualTo("some other text this book [^anchor1]\n" + "[^anchor1]: https://codigosostenible.com");
        assertThat(parser.parse("some other text [this book](https://codigosostenible.com) some other text")).isEqualTo("some other text this book [^anchor1] some other text\n" + "[^anchor1]: https://codigosostenible.com");

    }

    //Test cuando hay mas de un enlace

    //Test que no detecte imagen


}

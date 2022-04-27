package src;

public class MarkdownParser {
    public String parse(String text){
        if(text.indexOf("](") >= 0){
            var startIndex = text.indexOf('[');
            var finalIndex = text.indexOf(']');

            var parsedText = text.substring(0,startIndex) +
                    text.substring(startIndex+1, finalIndex);

            var urlStartIndex = finalIndex + 1;
            var urlFinalIndex = text.indexOf(')');

            parsedText += " [^anchor1]" + text .substring(urlFinalIndex +1)  + "\n[^anchor1]: " + text.substring(urlStartIndex+1, urlFinalIndex);
            return parsedText;
        }
        return text;
    }
}

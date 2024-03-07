package dev.lpa;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Review {

    public static void main(String[] args) {


        String phoneList = """
                (800) 123-4567
                (800)123-4567
                (800) 123 4567
                800-123-4567
                800 123-4567
                800 123 4567
                8001234567
                """;

        Pattern phonePattern =
                Pattern.compile("\\(*[0-9]{3}[)\\s-]*\\d{3}[\\s-]*\\p{Digit}{4}");

        Matcher phoneMatcher = phonePattern.matcher(phoneList);
        phoneMatcher.results().forEach(mr -> System.out.println(mr.group()));

        String htmlSnippets = """
                
                <H1>My Heading</H1>
                <h2>Sub-heading</h2>
                <p>This is a paragraph about something.</p>
                <p style="abc">This is another paragraph about something else.</p>
                <h3 id="third">Summary</h3>
                <br/>
                <p>Testing</p>
                """;

        Pattern htmlPattern =
                Pattern.compile("<(\\w+)[^>]([^\\v</>]*)(</\\1>)*");
    }
}

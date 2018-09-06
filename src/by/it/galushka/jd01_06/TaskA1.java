package by.it.galushka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 9/1/2018.
 */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[А-Яа-яёЁ]{4,}");
        Matcher matcher = compile.matcher(sBuilder);
        while (matcher.find()) {
            int position = matcher.start();
            sBuilder.setCharAt(position+3, '#');
            if (matcher.end() - matcher.start() >= 7) {
                sBuilder.setCharAt(position + 6, '#');
            }
        }
        System.out.println(sBuilder);
    }
}

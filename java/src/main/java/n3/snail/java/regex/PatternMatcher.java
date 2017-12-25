package n3.snail.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author N3 on 2017/11/15.
 */
public class PatternMatcher {

    public boolean isPatternMatches(String src, String pattern) {
        Pattern compilePattern = Pattern.compile(pattern);
        Matcher matcher = compilePattern.matcher(src);
        return matcher.matches();
    }

    public String[] patternSplit(String src, String pattern) {
        Pattern compilePattern = Pattern.compile(pattern);
        return compilePattern.split(src);
    }

    public String[] patternSplitMax(String src, String pattern, int max) {
        Pattern compilePattern = Pattern.compile(pattern);
        return compilePattern.split(src, max);
    }
}

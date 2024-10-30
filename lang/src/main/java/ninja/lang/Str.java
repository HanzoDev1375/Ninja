package ninja.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Str {
  private String nsi;

  public Str(String nsi) {
    this.nsi = nsi;
  }

  public String getNsi() {
    return this.nsi;
  }

  public boolean endText(Str text) {
    return nsi.endsWith(text.getNsi());
  }

  public boolean startText(Str text) {
    return nsi.startsWith(text.getNsi());
  }

  public boolean endText(String text) {
    return nsi.endsWith(text);
  }

  public boolean startText(String text) {
    return nsi.startsWith(text);
  }

  public boolean NotTextIsEmpty(String text) {
    if (text == null) {
      return false;
    } else return !text.isEmpty();
  }

  public boolean NotTextIsNull(String text) {
    if (text == null) return false;
    else return true;
  }

  public boolean NotTextIsEmpty(Str text) {
    if (text == null) {
      return false;
    } else return !text.getNsi().isEmpty();
  }

  public boolean NotTextIsNull(Str text) {
    if (text == null) return false;
    else return true;
  }

  public boolean Checkinglengthoftext(Str text) {
    if (text.getNsi().length() > 0) {
      return true;
    }
    return false;
  }

  public boolean isNumber(char c) {
    return Character.isDigit(c);
  }

  public boolean isNumber(Str c, int user) {
    return Character.isDigit(c.getNsi().charAt(user));
  }

  public boolean matchText(String text, String regex, int dataType) {
    Pattern pattern = Pattern.compile(regex, dataType);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      return matcher.matches();
    }
    return false;
  }

  public boolean matchText(String text, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      return matcher.matches();
    }
    return false;
  }
  
}

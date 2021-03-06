package coding.example.ecommerce.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.bridge.MessageUtil;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtilityImpl {

  private static final Logger logger = LogManager.getLogger(MessageUtil.class);
  private final static Locale defaultLocale = new Locale("en");

  public static ResourceBundle getBundle(Locale locale) {
    if(locale == null) {
      locale = defaultLocale;
    }
    return ResourceBundle.getBundle("messages", locale);
  }

  public static String getMessage(String key) {
    String message = "Message key not found !!!";
    try {
      message = getBundle(null).getString(key);
    }catch (Exception e) {
      logger.error(String.format("Error while getting message for key %s", key), e);
    }
    return message;
  }

  public static String getMessage(String key, Locale locale) {
    return getBundle(locale).getString(key);
  }

  public static String getMessage(String key, Object... messageArguments) {
    return getMessage(key, messageArguments, null);
  }

  public static String getMessage(String key, Object[] params, Locale locale) {
    return MessageFormat.format(getBundle(locale).getString(key), params);
  }
}

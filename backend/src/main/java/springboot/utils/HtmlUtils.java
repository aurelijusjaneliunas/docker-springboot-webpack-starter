package springboot.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by aurelijus on 16.7.9.
 */
public class HtmlUtils {

    public final static String JS_TAG = "<script src='@path'></script>";
    public final static String CSS_TAG = "<link rel='stylesheet' href='@path'>";

    public static String cssWrite(String resourcePath){
        return writeDocument(resourcePath, false);
    }

    public static String jsWrite(String resourcePath){
        return writeDocument(resourcePath, true);
    }

    public static String writeDocument(String resourcePath, boolean isJs){
        StringBuilder writeDocument = new StringBuilder();
        writeDocument.append("document.write(\"");
        writeDocument.append(resolveTagValue(resourcePath, isJs));
        writeDocument.append("\")");
        return writeDocument.toString();
    }

    private static String resolveTagValue(String resourcePath, boolean isJs) {
        return StringUtils.replace(isJs ? new String(JS_TAG) : new String(CSS_TAG), "@path", resourcePath);
    }

}

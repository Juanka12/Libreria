package utiles;

import java.io.File;

/* Utils.java is used by FileChooserDemo2.java. */
public class Tools {
    public final static String data = "data";

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
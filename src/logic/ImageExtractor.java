/*
 *  This is a Supplemental File from the Main Project used
 *  in APPSTIMERKILLER
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author ASUS
 */
public class ImageExtractor {

    /*public static void main(String[] args) {
        extractFile("timer.jpg");
    }*/

    private static void extractFile(String name) {
        try {
            File dirTarget = new File(System.getenv("APPDATA") + "\\appstimekiller");

            dirTarget.mkdirs();

            File target = new File(dirTarget.getAbsoluteFile(), name);
            if (target.exists()) {
                return;
            }

            FileOutputStream out = new FileOutputStream(target);
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            InputStream in = cl.getSystemResourceAsStream("images/timer.jpg");

            byte[] buf = new byte[8 * 1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();

        } catch (Exception ex) {
            System.out.println("Error on 47 " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}

package com.mycompany.covidclient;

/**
 *
 * @author did
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class COVIDOp {
    //URL Okuma
    public String readUrl(String urlString) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } catch (MalformedURLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
          } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
          } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
          return null;
    }

    

   

}

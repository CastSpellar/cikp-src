/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Bruno
 */
public class FileUtils {

    public static byte[] getBytesFromFile( File file ) {

           long length = file.length();
           byte[] bytes = new byte[(int)length];

           try {
               InputStream is = new FileInputStream(file);

               // Read in the bytes
               int offset = 0;
               int numRead = 0;
               while (offset < bytes.length
                       && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                   offset += numRead;
               }

               // Ensure all the bytes have been read in
               if (offset < bytes.length) {
                   throw new IOException("Could not completely read file "+file.getName());
               }

               // Close the input stream and return bytes
               is.close();
           } catch(Exception e ) {
               throw new RuntimeException(e);
           }
           return bytes;
       }

}

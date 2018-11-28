package com.fenbeitong.openapitest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LogStatic
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-28 - 下午6:29.
 **/
public class LogStatic {

    public static void main(String[] args) {
        BufferedReader br = null;
        FileWriter fop = null;
        PrintWriter pw = null;
        try {

            File out = new File("/home/ivan/static");
            if (!out.exists()) {
                out.createNewFile();
            }
            fop = new FileWriter(out);
            pw = new PrintWriter(fop);
            br = new BufferedReader(new FileReader("/home/ivan/open-9071-2018-10-09"));
            String contentLine = br.readLine();
            while(null != contentLine) {
                if (contentLine.contains("Found 1 matching mapping")) {
                    String[] array = contentLine.split(":");
                    String url = array[array.length - 1];
                    pw.println(url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            pw.flush();
            try{
                fop.flush();
                pw.close();
                fop.close();
                br.close();
            }catch(Exception ex){

            }

        }
    }
}

package jmeterjavarequest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Export {
    public static void output(String filename,String variable){

        BufferedWriter out = null;try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
            out.write(variable + "\r\n");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

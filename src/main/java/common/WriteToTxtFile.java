package common;

import java.io.*;
import java.util.List;

public class WriteToTxtFile {

    public static List<String> writeTxtFile(String txtPath,List<String> writeList) throws IOException {
        //List<String> list = new ArrayList<String>();
        char t = 1;
        String soh = String.valueOf(t);
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(txtPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            for (int i=0;i<writeList.size();i++){
                fw.write(writeList.get(i) + soh);
            }
            fw.flush();
            fw.close();
            System.out.println("写入文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writeList;

    }
}

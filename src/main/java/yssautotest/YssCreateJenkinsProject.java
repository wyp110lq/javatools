package yssautotest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YssCreateJenkinsProject {
    public static List<String> readTxts() throws IOException {
        String paths = System.getProperty("user.dir") + "\\src\\main\\resources\\jenkins\\inputfile.txt";
        String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\jenkins\\outfile.txt";;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(paths), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int count = 0;
        List<String> list = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            list.add(line);
            count++;
        }
        System.out.println("原始文件list为:" + list);
        System.out.println("读取总条数：" + count + "||读取的list的长度" + list.size());
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            for (int i=0;i<list.size();i++){
                fw.write("cp -r "+ list.get(i) + " " + "REFACSTOR_投资交易_" + list.get(i) + "\r\n");
            }
            fw.flush();
            fw.close();
            System.out.println("写入文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String[] args) throws IOException {
        readTxts();
    }
}

package yssautotest;
import common.ReadExcel;
import common.WriteToTxtFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YssFispTest {
    public static void main(String[] args) throws IOException {
        char t = 1;
        String soh = String.valueOf(t);
        //excel文件地址
        String execlPath = "C:\\Users\\Administrator\\Desktop\\fisp.xlsx";
        //txt文件地址
        String txtPath = System.getProperty("user.dir") + "\\src\\main\\resources\\outfile.txt";
        //excel文件的sheetName名称
        String sheetName = "产品信息-申请数据";
        System.out.println("txt路径为： " +  txtPath);
        //头信息
        List<String> AllList = new ArrayList<String>();
        AllList.add("1008=FISP.1.0");
        AllList.add("1009=字节数");
        AllList.add("1035=001");
        AllList.add("135=C01");
        AllList.add("2008=001");
        AllList.add("2004=123456");
        AllList.add("1051=20170524");
        AllList.add("1052=133832");
        AllList.add("2011=1");
        //戚旭提供的头信息
        String message = "1008=FISP.1.0" + soh + "1009=字节数" + soh + "1035=001" + soh + "135=C01" + soh
                + "2008=001" + soh + "2004=123456" + soh + "1051=20170524" + soh + "1052=133832" + soh
                + "2011=1" + soh;

        message = message + "1008=FISP1.0" + soh + "1009=999" + soh + "1035=001" + soh +
                "135=C01" + soh + "2008=002" + soh + "2009=1" + soh + "2038=tougr" +
                soh + "2010=2" + soh + "2039=gd" + soh + "2011=3" + soh +
                "2004=00001121" + soh + "2005=2017010101" + soh + "2002=fisp" + soh + "140=01088888888" +
                soh + "2003=guangda" + soh + "92=20161013" + soh + "93=131212" +
                soh + "85=中国结算" + soh + "27=0" + soh + "72=266322" + soh +
                "286=20170605" + soh + "2064=1" + soh + "2032=张003" + soh + "2033=建设银行" + soh +
                "2034=6220007910000797928" + soh + "2019=长春" + soh + "2013=999999999999" +
                soh + "2067=zujieshubiaoshi" + soh +
                "2016=股票" + soh + "98=1" + soh + "5=622301188601235689" + soh + "6=0" +
                soh + "7=法人001" + soh + "2006=Y" + soh + "1010=999" + soh;

        ReadExcel cp = new ReadExcel();
       // _column 读物哪一列,从0开始
       //_row 从哪一行开始读取，从0开始，存在表头，所以从1开始读。
        //取第2列的值
        ArrayList<String> list_col1 = new ArrayList<String>();
        list_col1 = (ArrayList<String>) cp.readExcelReturnListOrString("list",execlPath,1,1,sheetName);
       //取第3列的值
        ArrayList<String> list_col2 = new ArrayList<String>();
        list_col2 = (ArrayList<String>) cp.readExcelReturnListOrString("list",execlPath,2,1,sheetName);

        for(int i = 0;i<list_col1.size();i++){

            AllList.add(list_col1.get(i)+ "=" +list_col2.get(i));
        }


        //写入txt文件

        WriteToTxtFile.writeTxtFile(txtPath,AllList);




    }



}
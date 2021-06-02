package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel操作工具类
 */
public  class ReadExcel {
    /**
     * 读取excel 返回某一列 数据的list或者string
     * @param excelPath 文件路径
     * @param _column 读物哪一列
     * @param _row 从哪一行开始读取
     * @param type 返回数据的类型
     * @return
     */
    public static Object readExcelReturnListOrString(String type,String excelPath,int _column,int _row,String sheetName) {
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            ArrayList<String> list = new ArrayList<String>();
            StringBuilder str = new StringBuilder();
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断5ttree
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return null;
                }
                //开始解析
                //Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                Sheet sheet = wb.getSheet(sheetName);
                int firstRowIndex = sheet.getFirstRowNum()+_row;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                Row row = null;
                Cell cell_a = null;
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    row = sheet.getRow(rIndex);          //取得第i行 （从第二行开始取，因为第一行是表头）
                    cell_a = row.getCell(_column);        //取得i行的第一列
                    cell_a.setCellType(CellType.STRING);
                    String cellValue = cell_a.getStringCellValue().trim();
                    if(cellValue==""){
                        //设置一个默认值1
                        cellValue = "1";
                    }
                    list.add(cellValue);
                    str.append(cellValue+",");
//                    if(cellValue!="") {
//                        list.add(cellValue);
//                        str.append(cellValue+",");
//                    }
                }
                if("string".equals(type)) {
                    String strings = str.substring(0, str.length()-1);
                    System.out.println("读取完后的字符串为： " + strings);
                    return strings;
                }else {
                    //System.out.println("list大小为： " + list.size());
                    return list;
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("解析excel文件失败");
        }
        return null;
    }

}

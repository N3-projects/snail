package n3.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**写入excel文件
 * @author N3 on 2017/6/1.
 */
public class WriteExcel {

    public static void main(String[] args) {

        String fileName = "D:" + File.separator + "temp" + File.separator + "test1.xlsx";
        List<String> stringList = Arrays.asList("fffsdf","wegfefef","3443g4","f3f3gerg");
        writeToFile(fileName, stringList);

    }

    private static void writeToFile(String fileName, List<String> stringList) {
        Workbook workbook;

        try {
            if(fileName.endsWith("xlsx")){
                workbook = new XSSFWorkbook();
            }else if(fileName.endsWith("xls")){
                workbook = new HSSFWorkbook();
            }else{
                throw new Exception("invalid file name, should be xls or xlsx");
            }

            Sheet sheet = workbook.createSheet("Sheet1");

            Iterator<String> iterator = stringList.iterator();

            int rowIndex = 0;
            while(iterator.hasNext()){
                String str = iterator.next();
                Row row = sheet.createRow(rowIndex);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(str);
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(str.substring(0, 1));
                rowIndex++;
            }

            //lets write the excel data to file now
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            System.out.println(fileName + " written successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package n3;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**生成文件路径树，并输出到excel文件中
 * @author N3 on 2017/6/1.
 */
public class GenerateFilePathTreeExcel {

    @Test
    public void generateFilePathTreeExcel() {
        String excelFile = "D:" + File.separator + "temp" + File.separator + "tree.xlsx";
        String srcPath = "D:\\netease\\git-repository\\epay\\epay-core\\src\\main\\java\\com\\netease\\epay";
        String separatorChar = "\t";

        List<String> pathList = generateFilePathTree(srcPath, separatorChar);
        writeToExcel(excelFile, pathList, separatorChar);
    }

    private void writeToExcel(String fileName, List<String> stringList, String separatorChar) {
        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Sheet1");

            Iterator<String> iterator = stringList.iterator();

            int rowCount = 0;
            while(iterator.hasNext()) {
                String rowString = iterator.next();
                Row row = sheet.createRow(rowCount);
                int cellCount = 0;
                for (String cellString : rowString.split(separatorChar)) {
                    Cell cell = row.createCell(cellCount);
                    cell.setCellValue(cellString);
                    cellCount++;
                }
                rowCount++;
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

    private List<String> generateFilePathTree(String srcPath, String separatorChar) {
        File path = new File(srcPath);
        if(!path.exists() || !path.isDirectory()) {
            return null;
        }
        List<String> tree = new ArrayList<>();
        fillFilePathTree(tree, new File(srcPath), separatorChar, 0);
        return tree;
    }

    private void fillFilePathTree(List<String> tree, File path, String separatorChar, int index) {
        if(path==null || !path.exists()) {
            return ;
        }
        if(!path.isDirectory())
        {
            tree.add(getFilePathString(path.getName(), separatorChar, index));
        }
        else {
            //当前path是路径
            //打印路径
            tree.add(getFilePathString("——"+path.getName(), separatorChar, index));
            index++;
            //轮询path下的子目录
            File[] subFiles = path.listFiles();
            if (subFiles!=null && subFiles.length > 0) {

                for (File subFile : subFiles) {
                    fillFilePathTree(tree, subFile, separatorChar, index);
                }
            }
        }
    }

    private String getFilePathString(String name, String separatorChar, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(separatorChar);
        }
        sb.append(name);
        System.out.println(sb.toString());
        return sb.toString();
    }
}

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {
    public ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();

        FileInputStream data = new FileInputStream("//Users//codewithazam//Desktop//Azam//Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(data);

        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i=0; i< numberOfSheets; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("testData")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> row = sheet.iterator();
                Row firstRow = row.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                cell.next();
                int k = 0;
                int column = 0;
                while(cell.hasNext()){
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Test")){
                        column=k;
                    }
                    k++;
                }
                //System.out.println(column);

                while (row.hasNext()){
                    Row r = row.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase("BTC")){
                        Iterator<Cell> cv =  r.cellIterator();
                        while (cv.hasNext()){
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            }
                            else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
    public static void main(String[] args) throws IOException {

    }
}

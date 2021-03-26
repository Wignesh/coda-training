package ga.veee.day15;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ExcelRead {
    private static final String EXCEL_FILE_LOCATION = "Marks.xls";

    public static void main(String[] args) {

        Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));

            Sheet sheet = workbook.getSheet(0);
            Cell[] header = sheet.getRow(0);
            for (Cell cell : header) {
                System.out.printf("%-10s",cell.getContents());
            }
            System.out.printf("\n%s\n","_".repeat(70));
            for (int i = 1; i < sheet.getRows(); i++) {
                Cell[] cells = sheet.getRow(i);
                for (Cell cell : cells) {
                    System.out.printf("%-10s",cell.getContents());
                }
                System.out.println();
            }

        } catch (IOException | BiffException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }
}

package ga.veee.day15;


import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ExcelWriter {
    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write() throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Marks", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet);

        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet) throws WriteException {
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        times = new WritableCellFormat(times10pt);
        times.setWrap(true);
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        addCaption(sheet, 0, 0, "NAME");
        addCaption(sheet, 1, 0, "M1");
        addCaption(sheet, 2, 0, "M2");
        addCaption(sheet, 3, 0, "M3");
        addCaption(sheet, 4, 0, "M4");
        addCaption(sheet, 5, 0, "M5");
        addCaption(sheet, 6, 0, "TOTAL");


    }

    private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
        addLabel(sheet, 0, 1, "VIGNESH");
        addLabel(sheet, 0, 2, "VIJAY");
        addLabel(sheet, 0, 3, "SURYA");

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                addNumber(sheet, j, i, j);
            }
        }
        sheet.addCell(new Formula(6, 1, "SUM(B2:F2)"));
        sheet.addCell(new Formula(6, 2, "SUM(B3:F3)"));
        sheet.addCell(new Formula(6, 3, "SUM(B4:F4)"));
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row, Integer integer) throws WriteException, RowsExceededException {
        jxl.write.Number number;
        number = new jxl.write.Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }

    public static void main(String[] args) throws WriteException, IOException {
        ExcelWriter test = new ExcelWriter();
        test.setOutputFile("excel.xls");
        test.write();
        System.out.println("Please check the result file under excel.xls ");
    }
}

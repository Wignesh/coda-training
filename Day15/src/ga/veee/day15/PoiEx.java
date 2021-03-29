package ga.veee.day15;


import ga.veee.day15.Billing.Invoice;
import ga.veee.day15.Billing.InvoiceItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PoiEx {

    public static int drawLine(Workbook workbook, Sheet sheet, int rowId) {
        CellStyle cellStyle = workbook.createCellStyle();
        Row row = sheet.createRow(rowId);
        Cell cell = row.createCell(0);

        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(cellStyle);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:N%d", rowId + 1, rowId + 1)));

        return rowId + 1;
    }

    private static void addText(String value, Sheet sheet, Cell cell, boolean isBold, int fontSize, HorizontalAlignment hAlign, VerticalAlignment vAlign, IndexedColors colors) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setAlignment(hAlign);
        cellStyle.setVerticalAlignment(vAlign);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(colors.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private static void addText(Integer value, Sheet sheet, Cell cell, boolean isBold, int fontSize, HorizontalAlignment hAlign, VerticalAlignment vAlign, IndexedColors colors) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setAlignment(hAlign);
        cellStyle.setVerticalAlignment(vAlign);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(colors.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private static void addText(Float value, Sheet sheet, Cell cell, boolean isBold, int fontSize, HorizontalAlignment hAlign, VerticalAlignment vAlign, IndexedColors colors) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setAlignment(hAlign);
        cellStyle.setVerticalAlignment(vAlign);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(colors.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private static void addText(Double value, Sheet sheet, Cell cell, boolean isBold, int fontSize, HorizontalAlignment hAlign, VerticalAlignment vAlign, IndexedColors colors) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setAlignment(hAlign);
        cellStyle.setVerticalAlignment(vAlign);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(colors.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    public static void billTo(Sheet sheet, Invoice invoice) {
        Row row = sheet.createRow(14);
        Cell cell = row.createCell(0);
        addText("BILL TO", sheet, cell, true, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        CellRangeAddress cellMerge = new CellRangeAddress(14, 14, 0, 5);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellMerge, sheet);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 17, 17)));
        row = sheet.createRow(16);
        cell = row.createCell(0);
        addText(invoice.getBillToContactName(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 18, 18)));
        row = sheet.createRow(17);
        cell = row.createCell(0);
        addText(invoice.getBillToCompanyName(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 19, 19)));
        row = sheet.createRow(18);
        cell = row.createCell(0);
        addText(invoice.getBillToStreet(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 20, 20)));
        row = sheet.createRow(19);
        cell = row.createCell(0);
        addText(invoice.getBillToCity(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 21, 21)));
        row = sheet.createRow(20);
        cell = row.createCell(0);
        addText(invoice.getBillToState(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);


        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 22, 22)));
        row = sheet.createRow(21);
        cell = row.createCell(0);
        addText(invoice.getBillToCountry(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 23, 23)));
        row = sheet.createRow(22);
        cell = row.createCell(0);
        addText(invoice.getBillToZip(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 24, 24)));
        row = sheet.createRow(23);
        cell = row.createCell(0);
        addText(invoice.getBillToPhone(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 25, 25)));
        row = sheet.createRow(24);
        cell = row.createCell(0);
        addText(invoice.getBillToEmail(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);
    }

    public static void shipTo(Sheet sheet, Invoice invoice) {
        Row row = sheet.getRow(14);
        Cell cell = row.createCell(7);
        addText("SHIP TO", sheet, cell, true, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        CellRangeAddress cellMerge = new CellRangeAddress(14, 14, 7, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellMerge, sheet);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 17, 17)));
        row = sheet.getRow(16);
        cell = row.createCell(7);
        addText(invoice.getShipToContactName(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 18, 18)));
        row = sheet.getRow(17);
        cell = row.createCell(7);
        addText(invoice.getShipToCompanyName(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 19, 19)));
        row = sheet.getRow(18);
        cell = row.createCell(7);
        addText(invoice.getShipToStreet(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 20, 20)));
        row = sheet.getRow(19);
        cell = row.createCell(7);
        addText(invoice.getShipToCity(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 21, 21)));
        row = sheet.getRow(20);
        cell = row.createCell(7);
        addText(invoice.getShipToState(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);


        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 22, 22)));
        row = sheet.getRow(21);
        cell = row.createCell(7);
        addText(invoice.getShipToCountry(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 23, 23)));
        row = sheet.getRow(22);
        cell = row.createCell(7);
        addText(invoice.getShipToZip(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 24, 24)));
        row = sheet.getRow(23);
        cell = row.createCell(7);
        addText(invoice.getShipToPhone(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("H%d:N%d", 25, 25)));
        row = sheet.getRow(24);
        cell = row.createCell(7);
        addText(invoice.getShipToEmail(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

    }

    public static void company(Sheet sheet, Invoice invoice) throws IOException {
        Row row = sheet.createRow(3);
        Cell cell = row.createCell(0);
        addText("INVOICE", sheet, cell, true, 28, HorizontalAlignment.LEFT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(0);

        cell = row.createCell(1);
        addText("", sheet, cell, true, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);

        CellRangeAddress cellMerge = new CellRangeAddress(3, 3, 1, 13);
        sheet.addMergedRegion(cellMerge);
        InputStream inputStream = new FileInputStream("logo.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = sheet.getWorkbook().addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        CreationHelper helper = sheet.getWorkbook().getCreationHelper();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(12);
        anchor.setRow1(3);
        anchor.setCol2(13);
        anchor.setRow2(4);
        Picture pict = drawing.createPicture(anchor, pictureIdx);
        cell = sheet.getRow(3).createCell(12);
        int widthUnits = 25 * 128;
        sheet.setColumnWidth(5, widthUnits);

        short heightUnits = 64 * 25;
        cell.getRow().setHeight(heightUnits);


        String[] billToInfo = new String[]{"ABC CORP", "123, A Street", "CHENNAI", "TAMILNADU", "INDIA", "400500", "1234567890", "abc-corp@abc.com"};

        row = sheet.createRow(5);
        cell = row.createCell(0);
        addText(invoice.getCompanyName(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 5, 5)));

        row = sheet.createRow(6);
        cell = row.createCell(0);
        addText(invoice.getCompanyStreet(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 6, 6)));


        row = sheet.createRow(7);
        cell = row.createCell(0);
        addText(invoice.getCompanyCity(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 7, 7)));

        row = sheet.createRow(8);
        cell = row.createCell(0);
        addText(invoice.getCompanyState(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 8, 8)));

        row = sheet.createRow(9);
        cell = row.createCell(0);
        addText(invoice.getCompanyCountry(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 9, 9)));

        row = sheet.createRow(10);
        cell = row.createCell(0);
        addText(invoice.getCompanyZip(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 10, 10)));

        row = sheet.createRow(11);
        cell = row.createCell(0);
        addText(invoice.getCompanyPhone(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 11, 11)));


        row = sheet.createRow(12);
        cell = row.createCell(0);
        addText(invoice.getCompanyEmail(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.addMergedRegion(CellRangeAddress.valueOf(String.format("A%d:G%d", 12, 12)));


        row = sheet.getRow(6);
        cell = row.createCell(7);
        addText("INVOICE DATE", sheet, cell, true, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(7);

        cell = row.createCell(8);
        addText(":", sheet, cell, false, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);

        cell = row.createCell(9);
        addText(invoice.getInvoiceDate().toString(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(9);

        row = sheet.getRow(7);
        cell = row.createCell(7);
        addText("INVOICE NO", sheet, cell, true, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(7);

        cell = row.createCell(8);
        addText(":", sheet, cell, false, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);

        cell = row.createCell(9);
        addText(invoice.getInvoiceId(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(9);

        row = sheet.getRow(8);
        cell = row.createCell(7);
        addText("DUE DATE", sheet, cell, true, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(7);

        cell = row.createCell(8);
        addText(":", sheet, cell, false, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);

        cell = row.createCell(9);
        addText(invoice.getInvoiceDueDate().toString(), sheet, cell, false, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(9);

        row = sheet.getRow(9);
        cell = row.createCell(7);
        addText("COMMENT", sheet, cell, true, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(7);

        cell = row.createCell(8);
        addText(":", sheet, cell, false, 16, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);

        cell = row.createCell(9);
        addText(invoice.getInvoiceComment(), sheet, cell, true, 14, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM, IndexedColors.WHITE);
        sheet.autoSizeColumn(9);

    }

    protected static void setBordersToCells(Sheet sheet, CellRangeAddress rangeAddress) {
        RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet);
    }

    public static void tableHeader(Sheet sheet) {

        Row row = sheet.createRow(26);

        Cell cell = row.createCell(0);
        addText("DESCRIPTION", sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM, IndexedColors.LIGHT_ORANGE);
        CellRangeAddress cellMerge = new CellRangeAddress(26, 26, 0, 6);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);

        cell = row.createCell(7);
        addText("QTY", sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM, IndexedColors.LIGHT_ORANGE);
        cellMerge = new CellRangeAddress(26, 26, 7, 7);
        setBordersToCells(sheet, cellMerge);


        cell = row.createCell(8);
        addText("UNIT PRICE", sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM, IndexedColors.LIGHT_ORANGE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(26, 26, 8, 10);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);

        cell = row.createCell(11);
        addText("TOTAL", sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM, IndexedColors.LIGHT_ORANGE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(26, 26, 11, 13);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);

    }

    public static void tableRow(Sheet sheet, InvoiceItem item, int rowId) {

        Row row = sheet.createRow(rowId);

        Cell cell = row.createCell(0);
        addText(item.getDescription(), sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        CellRangeAddress cellMerge = new CellRangeAddress(rowId, rowId, 0, 6);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);

        cell = row.createCell(7);
        addText(item.getQuantity(), sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        cellMerge = new CellRangeAddress(rowId, rowId, 7, 7);
        setBordersToCells(sheet, cellMerge);


        cell = row.createCell(8);
        addText(item.getUnitPrice(), sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);


        cell = row.createCell(11);
        addText(item.getTotal(), sheet, cell, true, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        setBordersToCells(sheet, cellMerge);


    }

    public static int tableBody(Sheet sheet, ArrayList<InvoiceItem> invoiceItems) {
        int rowId = 27;
        for (InvoiceItem item : invoiceItems) {
            tableRow(sheet, item, rowId);
            rowId++;
        }
        return rowId;
    }

    public static void format(Sheet sheet) {
        CellRangeAddress cellMerge = new CellRangeAddress(25, 25, 0, 13);
        sheet.addMergedRegion(cellMerge);
        sheet.autoSizeColumn(8);
    }

    public static int totals(Sheet sheet, int rowId, Invoice invoice) {

        rowId++;

        Row row = sheet.createRow(rowId);
        Cell cell = row.createCell(8);
        addText("SUB TOTAL", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        CellRangeAddress cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getSubTotal(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.DASHED, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("DISCOUNT", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getDiscountAmount(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.DASHED, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("SUB TOTAL - DISCOUNT", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getSubTotalAfterDiscount(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.DASHED, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("SGST " + invoice.getsGSTPercent() + "%", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getsGSTAmount(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.DASHED, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("CGST " + invoice.getsGSTPercent() + "%", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getcGSTAmount(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.DASHED, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("SHIPPING CHARGES", sheet, cell, false, 14, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellMerge, sheet);

        cell = row.createCell(11);
        addText(invoice.getShippingCharges(), sheet, cell, false, 14, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellMerge, sheet);

        rowId++;

        row = sheet.createRow(rowId);
        cell = row.createCell(8);
        addText("BALANCE DUE", sheet, cell, true, 16, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(8);
        cellMerge = new CellRangeAddress(rowId, rowId, 8, 10);
        sheet.addMergedRegion(cellMerge);

        cell = row.createCell(11);
        addText(invoice.getTotalPayable(), sheet, cell, true, 16, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, IndexedColors.WHITE);
        sheet.autoSizeColumn(11);
        cellMerge = new CellRangeAddress(rowId, rowId, 11, 13);
        sheet.addMergedRegion(cellMerge);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellMerge, sheet);

        return rowId;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        Invoice invoice = new Invoice();
        invoice.addCompanyInfo("ABC CORP", "123, A Street,", "CHENNAI", "TAMILNADU", "INDIA", "600900", "9087654321", "abc-corp@abc.com");
        invoice.addBillToInfo("A Person", "BCD CORP", "123, B Street,", "CHENNAI", "TAMILNADU", "INDIA", "900800", "8790654321", "bcd-corp@bcd.com");
        invoice.addShipToInfo("B Person", "BCD CORP", "123, C Street,", "COIMBATORE", "TAMILNADU", "INDIA", "500600", "7098654321", "bcd-corp-cbe@bcd.com");
        invoice.addInvoiceInfo(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), 1, "PAY ASAP", "Remarks");
        invoice.setTax(9, 9);
        invoice.addItem(new InvoiceItem("PEN", 1, 1, 25));
        invoice.addItem(new InvoiceItem("PAPER", 1, 2, 5));
        invoice.setDiscountAmount(2);
        invoice.setShippingCharges(12);
        System.out.println(invoice.getTotalPayable());

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Invoice");
        sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
        sheet.setFitToPage(true);
        int rowId = 0;
        rowId = drawLine(workbook, sheet, rowId);
        company(sheet, invoice);
        billTo(sheet, invoice);
        shipTo(sheet, invoice);
        tableHeader(sheet);
        rowId = tableBody(sheet, invoice.getInvoiceItems());
        rowId = totals(sheet, rowId, invoice);
        rowId = drawLine(workbook, sheet, rowId + 5);

        workbook.setPrintArea(
                0, //sheet index
                0, //start column
                14, //end column
                0, //start row
                60  //end row
        );
        format(sheet);

        FileOutputStream fileOut = new FileOutputStream("Invoice.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }
}

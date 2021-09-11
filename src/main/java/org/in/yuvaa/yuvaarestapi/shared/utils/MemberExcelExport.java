package org.in.yuvaa.yuvaarestapi.shared.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.in.yuvaa.yuvaarestapi.shared.dto.joinus.JoinUsDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class MemberExcelExport {

    public static ByteArrayInputStream memberListToExcelSheet(List<JoinUsDto> joinus){
        try (Workbook workbook = new XSSFWorkbook()) {


            Sheet sheet = workbook.createSheet("Members");
            Row row = sheet.createRow(0);

            // create header
            Cell cell = row.createCell(0);
            cell.setCellValue("Name");

            cell = row.createCell(1);
            cell.setCellValue("Mobile");

            cell = row.createCell(2);
            cell.setCellValue("Email");

            cell = row.createCell(3);
            cell.setCellValue("College");

            // creating data rows for each customer
            for (int i = 0; i < joinus.size(); i++){
                Row dataRow = sheet.createRow(i+1);
                dataRow.createCell(0).setCellValue(joinus.get(i).getName());
                dataRow.createCell(1).setCellValue(joinus.get(i).getMobile());
                dataRow.createCell(2).setCellValue(joinus.get(i).getEmail());
                dataRow.createCell(3).setCellValue(joinus.get(i).getCollege());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());


        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}

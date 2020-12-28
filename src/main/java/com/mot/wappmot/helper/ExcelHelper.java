package com.mot.wappmot.helper;

import com.mot.wappmot.model.Products;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "එළවළු", "මිල පරාසය", "අලවර්ග", "මිල පරාසය", "පලාවර්ග", "ධාන්\u200Dයය", "පළතුරු" };
    static List<String> list = Arrays.asList(HEADERs);
    static String SHEET = "Products";
    static int check = 0;


    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Products> excelToProducts(InputStream inputStream){

        try {

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Products> products = new ArrayList<Products>();


            while (rows.hasNext()){

                Row currentRow = rows.next();


//                System.out.println("Last cell is "+currentRow.getZeroHeight());

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Products products1 = new Products();

                int cellIdx = 0;

                while (cellsInRow.hasNext()){

                    Cell currentCell = cellsInRow.next();

//                    System.out.println(currentCell.getCellType());
//                    System.out.println(currentCell);

                    if (!currentCell.getCellType().equals("STRING") && !list.contains(currentCell.toString())) {
                        if (currentCell != null){

                            switch (cellIdx) {

                                case 0:
                                    products1.setItem(currentCell.getStringCellValue());
                                    System.out.println("String val"+currentCell.getStringCellValue());
                                    break;

                                case 1:
                                    products1.setMinPrice((int) currentCell.getNumericCellValue());
                                    System.out.println(currentCell.getNumericCellValue());
                                    break;

                                case 2:
                                    products1.setMaxPrice((int) currentCell.getNumericCellValue());
                                    System.out.println(currentCell.getNumericCellValue());
                                    break;

                                default:
                                    break;

                            }

                        cellIdx++;

                    }
                    }
                }


                    products.add(products1);

            }

            workbook.close();

            return products;

        } catch (IOException e){

            throw new RuntimeException("Fail to parse Excel file: " +e.getMessage());

        }

    }


}

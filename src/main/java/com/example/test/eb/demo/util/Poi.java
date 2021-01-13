package com.example.test.eb.demo.util;

/**
 * @author lizongren
 * @create 2020.05.20 10:55
 */


/**
 * @author lizongren
 * @create 2020.05.18 20:46
 */


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Poi {
    private static HSSFWorkbook workbook = null;

    /**
     * 判断文件是否存在.
     * @param fileDir  文件路径
     * @return
     */
    public static boolean fileExist(String fileDir){
        boolean flag = false;
        File file = new File(fileDir);
        flag = file.exists();
        return flag;
    }
    /**
     * 判断文件的sheet是否存在.
     * @param fileDir   文件路径
     * @param sheetName  表格索引名
     * @return
     */
    public static boolean sheetExist(String fileDir,String sheetName) throws Exception{
        boolean flag = false;
        File file = new File(fileDir);
        if(file.exists()){    //文件存在
            //创建workbook
            try {
                workbook = new HSSFWorkbook(new FileInputStream(file));
                //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
                HSSFSheet sheet = workbook.getSheet(sheetName);
                if(sheet!=null)
                    flag = true;
            } catch (Exception e) {
                throw e;
            }

        }else{    //文件不存在
            flag = false;
        }
        return flag;
    }
    /**
     * 创建新excel.
     * @param fileDir  excel的路径
     * @param sheetName 要创建的表格索引
     * @param titleRow excel的第一行即表格头
     */
    public static void createExcel(String fileDir,String sheetName,String titleRow[]) throws Exception{
        //创建workbook
        workbook = new HSSFWorkbook();
        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
        HSSFSheet sheet1 = workbook.createSheet(sheetName);
        //新建文件
        FileOutputStream out = null;
        try {
            //添加表头

            HSSFRow row = workbook.getSheet(sheetName).createRow(0);    //创建第一行
            for(short i = 0;i < titleRow.length;i++){
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(titleRow[i]);
            }
            out = new FileOutputStream(fileDir);
            workbook.write(out);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 往excel中写入(已存在的数据无法写入).
     * @param fileDir    文件路径
     * @param sheetName  表格索引
     * @throws Exception
     */
    public static void writeToExcel(String fileDir,String sheetName,List<String> mapList) throws Exception{
        //创建workbook
        File file = new File(fileDir);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //流
        FileOutputStream out = null;
        HSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        // int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum()+1;
        try {
            // 获得表头行对象
            HSSFRow titleRow = sheet.getRow(0);
            if(titleRow!=null){
                for(int rowId=0;rowId<mapList.size();rowId++){
                    String map = mapList.get(rowId);
                    HSSFRow newRow=sheet.createRow(rowId+1);
                    HSSFCell cell = newRow.createCell(0);
                    cell.setCellValue(map);
                }
            }

            out = new FileOutputStream(fileDir);
            workbook.write(out);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Poi.fileExist("E:/Poi2.xls"));
        //创建文件
        String title[] = {"imei"};
        Poi.createExcel("E:/Poi2.xls","sheet1",title);
        List<String> list=new ArrayList<String>();
        for (int i=0;i<65535;i++){
            list.add("Poi"+i);
        }
        Poi.writeToExcel("E:/Poi2.xls","sheet1",list);
    }
}


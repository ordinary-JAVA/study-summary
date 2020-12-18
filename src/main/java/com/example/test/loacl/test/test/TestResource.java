package com.example.test.loacl.test.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author lizongren
 * @create 2020.04.15 10:26
 */

@RestController
@RequestMapping("/test")
public class TestResource {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/post")
    public String s1(@RequestParam("name") String name) {
        System.out.println("test");
        return name;
    }


    @GetMapping("/get")
    public String s121() {
        try {
            new Callable(){

                @Override
                public Object call() throws Exception {
                    return "ss";
                }
            };

           return "success";
        } catch (Exception e) {
            System.out.println("导出失败!");
            return null;
        }

    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                countDownLatch.countDown();
                return "ss";
            }
        };
        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                countDownLatch.countDown();
                return "ss1";
            }
        };
        countDownLatch.await(2, TimeUnit.SECONDS);
        String s=String.valueOf(callable1.call())+String.valueOf(callable.call());
        System.out.println(callable.call());
    }

   /* @GetMapping("/get")
    public Response s12(*//*HttpServletResponse response,*//* @RequestParam("name") String name,
                                                          @HeaderParam("user-agent") String userAgent) {
            List<Map<String, Object>> isList = new ArrayList<Map<String, Object>>();
        try {
            Date t = new Date();
            //获取当前年月日
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            String datestr = df.format(t);
                buildFile(name,  isList);
                return Response.ok(zipAll(isList).toByteArray()).header("Content-Disposition",
                       contentDisposition("用户分群_" + datestr + ".zip", userAgent)).build();
            } catch (Exception e) {
                System.out.println("导出失败!");
                return null;
            }

    }*/
    public static ByteArrayOutputStream zipAll(List<Map<String, Object>> isList) throws Exception {
        ByteArrayOutputStream by = new ByteArrayOutputStream();
        ZipOutputStream out = new ZipOutputStream(by);
        for (Map<String, Object> map : isList) {
            out.putNextEntry(new ZipEntry(map.get("fileName").toString()));
            InputStream is = (InputStream) map.get("inputStream");
            BufferedInputStream bi = new BufferedInputStream(is);
            int b;
            while ((b = bi.read()) != -1) {
                out.write(b);
            }
            bi.close();
        }
        out.close(); // 输出流关闭
        return by;
    }
    public static String contentDisposition(String fileName, String userAgent) throws UnsupportedEncodingException {
        // IE 7/8/9/10/11  Edge
        if (userAgent.contains("msie") || userAgent.contains("MSIE")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            fileName = fileName.replace("+", "%20");// 处理空格变“+”的问题
        } else {// FF chrome
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        }
        return "attachment;filename=".concat(fileName);
    }
    public void buildFile(String name,List<Map<String, Object>> isList) throws IOException {
        String fileName = UUID.randomUUID().toString()  + ".xlsx";
        String sql = "select id from  "+name;
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
        cell.setCellValue("imei");
       /* jdbcTemplate.query(sql, new RowCountCallbackHandler() {
            @Override
            protected void processRow(ResultSet rs, int rowNum) throws SQLException {
                Row row = sheet.createRow(rowNum + 1);
                Cell cell = null;
                String data = null;
                for (int i=0;i<1;i++){
                    cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                    data = rs.getString(i+1);
                    cell.setCellValue(data);
                }
            }
        });*/
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        wb.write(baos);
        InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        Map<String, Object> map = new HashMap<>();
        map.put("fileName", fileName);
        map.put("inputStream",inputStream );
        isList.add(map);
    }

}

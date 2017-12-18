package com.yundao.tenant;

import com.yundao.core.utils.FileUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.FileDto;
import com.yundao.tenant.dto.common.FileBaseDto;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gjl on 2017/7/21.
 */
public class Test {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        List<FileBaseDto> fileDtoList = new ArrayList<>();
//        FileBaseDto fileDto = new FileBaseDto();
//        fileDto.setUrl("http://www.zcmall.com");
//        fileDto.setName("name1");
//        fileDto.setSeqencing(1);
//        fileDtoList.add(fileDto);
//        System.out.print(JsonUtils.objectToJson(fileDtoList));
//        String strDate = "2017-08-08 18:30:10";
//        int i = strDate.lastIndexOf(" ");
//        System.out.printf(Integer.valueOf(i).toString());
//
//        System.out.printf(strDate.substring(0,i));

//        FileDto fileDto = new FileDto();
//        fileDto.setFileName("name");
//        fileDto.setFileUrl("url");
//        List<FileDto> fileDtolist = new ArrayList<>();
////        fileDtolist.add(fileDto);
//        String name = CamelUtil.toCamel("user_visit");
//        System.out.print("Base" + name.substring(0,1).toUpperCase() + name.substring(1));
        List<Content> contents = new ArrayList<>();
        for (int i=0;i<43;i++){
            String content = org.apache.commons.io.FileUtils.readFileToString(new File("D:\\temp\\data\\"+i+".json"));
            ResultTemp objects = JsonUtils.jsonToObject(content,ResultTemp.class);
            contents.addAll(objects.getContent());
        }
        System.out.println(contents);
        //上传
        report(contents);
    }

    public static <T> void report(List<T> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
        String pattern = "yyyy-MM-dd hh:mm:ss";
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        String sheetName = "Sheet1";
        HSSFSheet sheet = workbook.createSheet(sheetName);
        /* sheet.autoSizeColumn((short)3000); */
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        T ht = list.get(0);
        Field[] hFields = ht.getClass().getDeclaredFields();


        for (short i = 0; i < hFields.length; i++) {
            Field field = hFields[i];
            // 通过注解，设置表格头部
            String header = "";
            if (i == hFields.length - 2) {
                header = "错误提示";
            }
            HSSFCell hcell = row.createCell(i);
            hcell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(header);
            hcell.setCellValue(text);

            // 调整宽度
            sheet.setColumnWidth(i, (short) 3500);
        }

        // 遍历集合数据
        Iterator<T> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = it.next();
            // 利用反射得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                if (fieldName.equals("rowNumber")) {
                    continue;
                }
                HSSFCell cell = row.createCell(i);
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Class<? extends Object> tCls = t.getClass();
                Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                Object value = getMethod.invoke(t, new Object[]{});


                if (fieldName.equals("errorAlert")) {
                    HSSFCellStyle errStyle = workbook.createCellStyle(); // 样式对象
                    HSSFFont errFont = workbook.createFont();//生成一个字体
                    errFont.setColor(HSSFColor.RED.index);//字体颜色
                    errStyle.setFont(errFont);
                    cell.setCellStyle(errStyle);
                }

                // 判断值的类型后进行强制类型转换
                String textValue;
                if (value instanceof Date) {
                    Date date = (Date) value;
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    textValue = sdf.format(date);
                } else {
                    // 其它数据类型都当作字符串简单处理
                    textValue = value != null ? value.toString() : "";
                }

                if (textValue != null) {
                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        // 是数字当作double处理
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richString = new HSSFRichTextString(textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
        }

        try {
            //默认导出到E盘下
            FileOutputStream out = new FileOutputStream("D:\\temp\\data\\深圳基金公司.xls");
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null, "导出成功!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "导出失败!");
            e.printStackTrace();
        }
    }
}

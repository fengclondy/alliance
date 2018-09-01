package com.ai.aso.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DataFormat;

/**
 * 
 * @author wanghl
 *
 */
public class ExportExcleUtil
{
	
	
	 public static boolean  exportExcleUtil(List<LinkedHashMap<String,Object>> values,String[] keys,String fileName,String[] header,HttpServletResponse response,String filePath){
         try
         {
        	 File  file=new File(filePath);
        	 InputStream  inputStream=new FileInputStream(file);
             HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
             HSSFSheet sheet = workbook.getSheetAt(0);
             
             
             HSSFRow row0 = sheet.getRow(2);

             for (int i = 0; i < values.size(); i++)
             {
                 HSSFRow row = sheet.createRow(i+2);//创建一行 

                 int j = 0;
                 HashMap obj = (HashMap) values.get(i);
                 for (int k = 0; k < keys.length; k++)
                {

                     Object value = obj.get(keys[k]);
                     if(value == null){
                         value = "";
                     }
                     HSSFCell cell = row.createCell(j);
                     cell.setCellStyle(row0.getCell(k).getCellStyle());
                     cell.setCellValue(String.valueOf(value));
                     j++;
                }
                
             }
             response.reset();
             response.setCharacterEncoding("UTF-8");
             if (fileName!=null||!"".equals(fileName))
             {
                 //fileName = URLEncoder.encode(fileName, "utf-8");
             }
             response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
             response.setHeader("Content-Type", "application/force-download");
             response.setHeader("Content-Type", "application/vnd.ms-excel");
             OutputStream os = response.getOutputStream();
             workbook.write(os);
             os.flush();
             os.close();  
             return true;
         }
         catch (Exception e)
         {
        	 e.printStackTrace();
         }
        return false;
        
     }
	 
    /**
     *  导出excel
     * @param values 是一个有序的Map的集合 
     * @param fileName 文件名
     * @param header  头的标题
     * @param response  
     */
	   
     public static boolean  exportUtil(List<LinkedHashMap<String,Object>> values,String[] keys,String fileName,String[] header,HttpServletResponse response){
         try
         {
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet(fileName);
             
             HSSFRow row0 = sheet.createRow(0);
             
             HSSFFont headfont = workbook.createFont();     
             //headfont.setFontName("黑体");     
             //headfont.setFontHeightInPoints((short) 22);// 字体大小     
             headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
             HSSFCellStyle headstyle = workbook.createCellStyle();     
             headstyle.setFont(headfont);     
             headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
             headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中     
             headstyle.setLocked(true);     
             headstyle.setWrapText(true);// 自动换行 
             for (int i = 0; i < header.length; i++)
             {
                 HSSFCell cell = row0.createCell(i);
                 sheet.setColumnWidth(i, 5000);
                 cell.setCellStyle(headstyle);
                 cell.setCellValue(header[i]);
             }

             // 生成并设置另一个样式
             HSSFCellStyle style2 = workbook.createCellStyle();
             style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
             style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
             style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
             style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
             style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
             style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
             DataFormat format = workbook.createDataFormat();
             style2.setDataFormat(format.getFormat("yyyy-MM-dd"));
             // 生成另一个字体
             HSSFFont font2 = workbook.createFont();
             font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
             // 把字体应用到当前的样式
             style2.setFont(font2);
             for (int i = 0; i < values.size(); i++)
             {
                 HSSFRow row = sheet.createRow(i+1);//创建一行 
//                 row.setRowStyle(row0.getRowStyle());
                 int j = 0;
                 HashMap obj = (HashMap) values.get(i);
                 for (int k = 0; k < keys.length; k++)
                {
                     Object value = obj.get(keys[k]);
                     if(value == null){
                         value = "";
                     }
                     HSSFCell cell = row.createCell(j);
                     cell.setCellStyle(style2);
                     cell.setCellValue(String.valueOf(value));
                     j++;
                }
                
             }
             response.reset();
             response.setCharacterEncoding("UTF-8");
             if (fileName!=null||!"".equals(fileName))
             {
                 //fileName = URLEncoder.encode(fileName, "utf-8");
             }
             response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
             response.setHeader("Content-Type", "application/force-download");
             response.setHeader("Content-Type", "application/vnd.ms-excel");
             OutputStream os = response.getOutputStream();
             workbook.write(os);
             os.flush();
             os.close();  
             return true;
         }
         catch (Exception e)
         {
        	 e.printStackTrace();
         }
        return false;
        
     }
     
}

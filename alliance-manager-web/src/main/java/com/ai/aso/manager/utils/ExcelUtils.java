package com.ai.aso.manager.utils;

import com.ai.aso.manager.web.vo.DataRecVo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * 表格工具
 *<p>Description:</p>
 *
 *
 *@date 2016年9月12日
 *
 */
public class ExcelUtils {
	 /**
     *  导出excel
     * @param values 是一个有序的Map的集合 
     * @param fileName 文件名
     * @param header  头的标题
     * @param response  
     */
	 private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    public static void exportUtil(List<LinkedHashMap<String,Object>> values, String[] keys, String fileName, String[] header, HttpServletResponse response){
    	 HSSFWorkbook workbook = null;
    	 try {
             workbook = new HSSFWorkbook();
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
                 @SuppressWarnings("rawtypes")
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
             if (fileName!=null||!"".equals(fileName)) {
                 //fileName = URLEncoder.encode(fileName, "utf-8");
             }
             response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
//             response.setHeader("Content-Type", "application/force-download");
             response.setHeader("Content-Type", "application/vnd.ms-excel");
             OutputStream os = response.getOutputStream();
             workbook.write(os);
             os.flush();
             os.close();
             workbook.close();
         } catch (Exception e) {
        	 log.error("导出Excel文件生成异常", e);
         } finally {
             if(null != workbook) {
                 try {
                     workbook.close();
                 } catch (IOException e) {
                     log.error("关闭Excel读写流异常", e);
                 }
             }
         }
     }
   
 	/**
 	 * DataRecDetailVo转成换成map
 	 * 
 	 * @param dataRecVoList
 	 * @return
 	 */
 	public static List<LinkedHashMap<String, Object>> DataRecDetailToMap(List<DataRecVo> dataRecVoList) {

 		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
 	
 		for (DataRecVo vo : dataRecVoList) {
 			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(0);
 			map.put("userNbr", vo.getUserNbr());
 			map.put("recNo", vo.getRecNo());
 			map.put("goodsId", vo.getGoodsId());
 			map.put("goodsName", vo.getGoodsName());
 			map.put("totalFee", vo.getTotalFee()/1000.00);
 			map.put("sBeginDate", vo.getsBeginDate());
 			map.put("custId", vo.getCustId());
 			map.put("custName", vo.getCustName());
 			map.put("costRegionName", vo.getCostRegionName());
 			map.put("StateName", vo.getStateName());
 			map.put("goodsModel", vo.getGoodsModel());
 			map.put("regionName", vo.getRegionName());
 			
 			list.add(map);
 		}

 		return list;
 	}
}

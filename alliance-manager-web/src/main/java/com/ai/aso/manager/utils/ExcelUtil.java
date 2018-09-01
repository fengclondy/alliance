package com.ai.aso.manager.utils;

import com.ai.aso.manager.web.vo.DataRecVo;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class ExcelUtil
{
	
	
	public static boolean  exportExcleUtil(List<LinkedHashMap<String,Object>> values, String[] keys, String fileName, String[] header, HttpServletResponse response, String filePath){
        InputStream  inputStream=null;
        XSSFWorkbook workbook=null;
        try
        {
       	 File  file=new File(filePath);
       	  inputStream=new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            long dataIndex = 0;

            XSSFRow row0 = sheet.getRow(2);

            for (int i = 0; i < values.size(); i++)
            {
                @SuppressWarnings("unused")
				long sheetIndex = dataIndex / 65535+ 1;
                XSSFRow row = sheet.createRow(i+2);//创建一行

                int j = 0;
                HashMap<?, ?> obj = (HashMap) values.get(i);
                for (int k = 0; k < keys.length; k++)
               {

                    Object value = obj.get(keys[k]);
                    if(value == null){
                        value = "";
                    }
                    XSSFCell cell = row.createCell(j);
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
        } finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(null!=workbook){
                try {
                    workbook.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
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
	   
    @SuppressWarnings("resource")
	public static boolean  exportUtil(List<LinkedHashMap<String,Object>> values, String[] keys, String fileName, String[] header, HttpServletResponse response){
        XSSFWorkbook workbook =null;
        try
        {
             workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(fileName);
            
            XSSFRow row0 = sheet.createRow(0);
            
            XSSFFont headfont = workbook.createFont();
            //headfont.setFontName("黑体");     
            //headfont.setFontHeightInPoints((short) 22);// 字体大小     
            headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
            XSSFCellStyle headstyle = workbook.createCellStyle();
            headstyle.setFont(headfont);     
            headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中     
            headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中     
            headstyle.setLocked(true);     
            headstyle.setWrapText(true);// 自动换行 
            for (int i = 0; i < header.length; i++)
            {
                XSSFCell cell = row0.createCell(i);
                sheet.setColumnWidth(i, 5000);
                cell.setCellStyle(headstyle);
                cell.setCellValue(header[i]);
            }

            // 生成并设置另一个样式
            XSSFCellStyle style2 = workbook.createCellStyle();
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
            XSSFFont font2 = workbook.createFont();
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);
            for (int i = 0; i < values.size(); i++)
            {
                XSSFRow row = sheet.createRow(i+1);//创建一行
//                row.setRowStyle(row0.getRowStyle());
                int j = 0;
                @SuppressWarnings("rawtypes")
				HashMap obj = (HashMap) values.get(i);
                for (int k = 0; k < keys.length; k++)
               {
                    Object value = obj.get(keys[k]);
                    if(value == null){
                        value = "";
                    }
                    XSSFCell cell = row.createCell(j);
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
        }finally {
            if(null!=workbook){
                try {
                    workbook.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
       return false;
       
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
// 			{ "userNbr", "recNo", "goodsId", "goodsName", "totalFee", "sBeginDate", "custId","custName","costRegionName","stateName",
//				"goodsModel", "regionName" };
 			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(0);
 			map.put("userNbr", vo.getUserNbr());
 			map.put("dataTypeName", vo.getDataTypeName());
 			map.put("dataVal", vo.getDataVal());
 			map.put("billFee", vo.getBillFee()/1000.00);
 			map.put("sendDate", vo.getsEndDate());
 			map.put("StateName", vo.getStateName());
 			map.put("errMesg", vo.getErrMesg());
 			map.put("billBatch", vo.getBillBatch());
 			map.put("billMonth", vo.getBillMonth());
 			
 			
// 			map.put("userNbr", vo.getUserNbr());
// 			map.put("recNo", vo.getRecNo());
// 			map.put("goodsId", vo.getGoodsId());
// 			map.put("goodsName", vo.getGoodsName());
// 			map.put("totalFee", vo.getTotalFee()/1000.00);
// 			map.put("sBeginDate", vo.getsBeginDate());
// 			map.put("custId", vo.getCustId());
// 			map.put("custName", vo.getCustName());
// 			map.put("costRegionName", vo.getCostRegionName());
// 			map.put("StateName", vo.getStateName());
// 			map.put("goodsModel", vo.getGoodsModel());
// 			map.put("regionName", vo.getRegionName());
 			
 			list.add(map);
 		}

 		return list;
 	}
	public static File writePFPCExcel(String fileName, String filePath, String tarFilePath, List<String> goodsNameList) throws Exception{
        String[] title = {"手机号", "商品类型、规格"};

        String[] txtList = goodsNameList.toArray(new String[0]);

        Workbook wb = null;
        Sheet sheet = null;
        InputStream inputStream = null;
        FileOutputStream out = null;

        try {
            File file = new File(filePath + File.separator + fileName);
            boolean isBlank = !file.exists();
            if (isBlank) {
                if (!file.getParentFile().exists()) {
                    //如果目标文件所在的目录不存在，则创建父目录
                    //目标文件所在目录不存在，准备创建它!
                    if (!file.getParentFile().mkdirs()) {
                        //创建目标文件所在目录失败！
                        throw new FileNotFoundException();
                    }
                }
                wb = new XSSFWorkbook();
                sheet = wb.createSheet();
                setBoldTile(title, wb, sheet);
            } else {
                inputStream = new FileInputStream(file);
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                if ("xls".equalsIgnoreCase(fileType)) {
                    wb = new HSSFWorkbook(inputStream);
                } else if ("xlsx".equalsIgnoreCase(fileType)) {
                    wb = new XSSFWorkbook(inputStream);
                } else {
                    inputStream.close();
                    throw new Exception("仅支持excel文件：xls、xlsx");
                }
                sheet = wb.getSheetAt(0);
            }

            setValidationData(sheet, 1, 65535, 1, 1, txtList);

            sheet.setColumnWidth(0, (int) (Math.floor((18 * 11 + 10) / 11 * 256)));
            sheet.setColumnWidth(1, (int) (Math.floor((22 * 11 + 10) / 11 * 256)));

            File myFile = new File(tarFilePath + File.separator + fileName);
            if (!myFile.exists()) {
                if (!myFile.getParentFile().exists()) {
                    if (!myFile.getParentFile().mkdirs()) {
                        throw new FileNotFoundException();
                    }
                }
                myFile.createNewFile();
            }

            out = new FileOutputStream(myFile);
            wb.write(out);
            out.flush();

            return myFile;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (null != out) out.close();
            if (null != wb) {
                try {
                    wb.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (null != inputStream) inputStream.close();
        }
	}

    private static void setBoldTile(String[] titles, Workbook wb, Sheet sheet) {
        Font font = wb.createFont();
        font.setBold(true);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        for (int i = 0; i < titles.length; i++) {
            Row row = sheet.getRow(0) == null ? sheet.createRow(0) : sheet.getRow(0);
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titles[i]);
        }
    }
	
	/** 
     * 添加数据有效性检查. 
     * @param sheet 要添加此检查的Sheet 
     * @param firstRow 开始行 
     * @param lastRow 结束行 
     * @param firstCol 开始列 
     * @param lastCol 结束列 
     * @param explicitListValues 有效性检查的下拉列表 
     * @throws IllegalArgumentException 如果传入的行或者列小于0(< 0)或者结束行/列比开始行/列小 
     */  
    private static void setValidationData(Sheet sheet, int firstRow,  int lastRow,  
            int firstCol,  int lastCol,String[] explicitListValues) throws IllegalArgumentException{  
        if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {  
            throw new IllegalArgumentException("Wrong Row or Column index : " + firstRow+":"+lastRow+":"+firstCol+":" +lastCol);  
        }  
        if (sheet instanceof XSSFSheet) {  
            XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet)sheet);  
            XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper  
                    .createExplicitListConstraint(explicitListValues);  
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);  
            XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);  
            validation.setSuppressDropDownArrow(true);  
            validation.setShowErrorBox(true);  
            sheet.addValidationData(validation);  
        } else if(sheet instanceof HSSFSheet){  
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);  
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);  
            DataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
            validation.setSuppressDropDownArrow(true);  
            validation.setShowErrorBox(true);  
            sheet.addValidationData(validation);  
        }  
    }
    
    
    public static void main(String[] args) throws Exception {
    	
    	List<String> goodsNameList = new ArrayList<String>();
    	goodsNameList.add("100001 - 全国通用 30M");
    	goodsNameList.add("100002 - 全国通用 50M");
    	goodsNameList.add("100003 - 全国通用 100M");
    	goodsNameList.add("100004 - 全国通用 300M");
    	goodsNameList.add("100005 - 全国通用 500M");
    	goodsNameList.add("200001 - 省内通用 30M");
    	goodsNameList.add("200002 - 省内通用 50M");
    	goodsNameList.add("200003 - 省内通用 100M");
    	goodsNameList.add("200004 - 省内通用 300M");
    	goodsNameList.add("200005 - 省内通用 500M");
    	
		ExcelUtil.writePFPCExcel("批量派发模板.xlsx", "C:\\Users\\wuqiang6\\Desktop", "C:\\Users\\wuqiang6\\Desktop\\1010111", goodsNameList);
	}
     
}

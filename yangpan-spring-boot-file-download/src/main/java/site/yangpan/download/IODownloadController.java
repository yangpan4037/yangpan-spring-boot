package site.yangpan.download;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 根据IO流下载
 * Created by yangpan on 2019-07-06 14:20.
 */
@Controller
@RequestMapping("/ioExport")
public class IODownloadController {

    @RequestMapping("/text")
    public void text(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OutputStream output = response.getOutputStream();
        response.reset();
        String filename = new String("测试".getBytes("GBK"), "ISO-8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + filename + ".txt");
        response.setContentType("application/msexcel");
        PrintWriter printWriter = new PrintWriter(output);
        printWriter.println("换行打印");
        printWriter.println("换行打印");
        printWriter.println("换行打印");
        printWriter.close();
        output.close();
    }


    /**
     * 导出excel
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/excel")
    public void excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("客户导入信息");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        sheet.setColumnWidth(2, "宽度".toString().length() * 5120);
        HSSFCellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(HSSFColor.TEAL.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();
        font.setColor(HSSFColor.WHITE.index);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        // 产生表格标题行
        HSSFRow row1 = sheet.createRow(0); // 标题行
        row1.setHeight((short) (1.5 * 250)); // 设置1.5倍行距
        String[] excelHead = { "电话号码", "客户姓名", "备注" };
        for (int i = 0; i < excelHead.length; i++) {
            HSSFCell cell = row1.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(excelHead[i]);
        }
        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("13541292110");
        row2.createCell(1).setCellValue("张三");
        row2.createCell(2).setCellValue("人工填写，可为任意内容，可为空");
        OutputStream output = response.getOutputStream();
        response.reset();
        String filename = new String("客户信息导入模板".getBytes("GBK"), "ISO-8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + filename + ".xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }

}

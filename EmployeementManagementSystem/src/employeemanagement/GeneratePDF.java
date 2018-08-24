package employeemanagement;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;

import employeemanagement.DBOperations.PaySalaryDBOperation;
import employeemanagement.model.Hr_EmpModel;
import employeemanagement.model.PaySalary;

/**
 * Servlet implementation class GeneratePDF
 */
@WebServlet("/GeneratePDF")
public class GeneratePDF extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	 public GeneratePDF() {
	  super();
	 }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request, response);
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			  
			  int empId = GetUserFromSession.getIdFromSession(request);
			  String month1 = request.getParameter("month");
			  int year1 = Integer.parseInt(request.getParameter("year"));
			  
			  Hr_EmpModel emp = Hr_EmployeeDBOperations.getHr_Emp(empId);
			  PaySalary sal = PaySalaryDBOperation.getSalByMonthYearId(empId, month1, year1);
			  
			  System.out.println(sal);
			  
			  if(sal.getEmpId()!=0)
			  {
			  
             /*OutputStream file = new FileOutputStream(new File("D:\\PDF_Java4s.pdf"));*/
        	 ServletOutputStream os = response.getOutputStream();
       	    //set the response content type to PDF
       	    response.setContentType("application/octet-stream"); 
        	response.setHeader("Content-Disposition",
       			"attachment;filename=payslip"+sal.getMonth()+""+sal.getYear()+""+".pdf");
              Paragraph para = new Paragraph();
              Document document = new Document();
              PdfWriter.getInstance(document, os);
 
                 document.open();
                 Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                   
          
                 para = new Paragraph("Value Minds Pvt Ltd",font1);
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 para = new Paragraph("Hi Tech City , Hyderabad,Telangana - 562112",font1);
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 Calendar cal = Calendar.getInstance();
                 java.util.Date d = new java.util.Date(cal.getTimeInMillis());
            /*     String month = new SimpleDateFormat("MMMM").format(d);
                 int year = cal.get(Calendar.YEAR);
                 System.out.println("Month "+month);*/
                
                 para = new Paragraph("Pay-slip for the month of " + sal.getMonth() +" " + sal.getYear(),font1 );
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 document.add(Chunk.NEWLINE);
                 PdfPTable table = new PdfPTable(3); // Code 1
                 table.getDefaultCell().setBorder(0);
         		// Code 2
         	
         		table.addCell(new Phrase("Name of Employee ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(emp.getName(), FontFactory.getFont(FontFactory.COURIER,10)));         		
         		// Code 3
         		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(emp.getDesignation(), FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 4
         		table.addCell(new Phrase("Department ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(emp.getDepartment(), FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("Pf No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("12345", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("PAN No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("SBA/CNO", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("Bank of Hyderabad", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("City Market,Hyderabad", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 5
         		
         		document.add(table);
         		
                document.add(Chunk.NEWLINE);
                
         		PdfPTable table1 = new PdfPTable(4); // 3 columns.
         		
         		 table1.getDefaultCell().setBorderWidth(1);
         		//table1.setTotalWidth(new float[]{ 136,60,110,45,110,90});
         		/*PdfPCell cell1 = new PdfPCell(new Paragraph("Earnings"));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Rs"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Deductions"));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Rs"));
                PdfPCell cell5 = new PdfPCell(new Paragraph("Other Details"));
                PdfPCell cell6 = new PdfPCell(new Paragraph("Rs"));
                table1.addCell(cell1);
                table1.addCell(cell2);
                table1.addCell(cell3);
                table1.addCell(cell4);
                table1.addCell(cell5);
                table1.addCell(cell6);*/
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("INCOME", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("AMOUNT ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("DEDUCTIONS", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("AMOUNT", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getBasicPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getProfessionalPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getDrPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Income Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getIncomeTaxPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Performance Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getPaPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("LOP ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getLopPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Allowances ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getOtherAllowancesPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getOtherDeductionsPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		     	
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(sal.getSpecialPay()+"", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Loyality bonus monthly comp  ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("825 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		 
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                
                double totalEarning = sal.getBasicPay()+sal.getDrPay()+sal.getOtherAllowancesPay()+sal.getPaPay()+sal.getSpecialPay();
                double totalDeductions = sal.getIncomeTaxPay()+sal.getLopPay()+sal.getOtherDeductionsPay()+sal.getProfessionalPay();
                
                table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            	table1.addCell(new Phrase("Total Earnings  ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(new Phrase(totalEarning+"", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            	table1.addCell(new Phrase("Total Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(new Phrase(totalDeductions+"", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            	
                document.add(table1);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                para = new Paragraph("www.itechsolutions.in",font1);
                para.setAlignment(Element.ALIGN_CENTER);
                document.add(para);
                document.close();
                 os.close();
                 System.out.println("Pdf generated normally");
			  }
			  else
			  {
				  request.setAttribute("msg", "No Payslip is available for given year month");
				  request.getServletContext().getRequestDispatcher("/downpayslip.jsp").forward(request, response);
			  }
             
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
		  
		  
    }

	 }

	
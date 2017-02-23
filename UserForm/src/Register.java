import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String d=request.getParameter("date");  
String e=request.getParameter("email");  
String p=request.getParameter("password"); 
String a=request.getParameter("address"); 
String po=request.getParameter("postcode"); 
String c=request.getParameter("country"); 

          
try{  
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/db_project","root","root");   
  
PreparedStatement ps=con.prepareStatement(  
"insert into userinfo values(?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,d);  
ps.setString(3,e);  
ps.setString(4,p);
ps.setString(5,a);  
ps.setString(6,po);  
ps.setString(7,c);  
          
int i=ps.executeUpdate();  
if(i>0) { 
System.out.println("You are successfully registered...");  
      
}
 
          
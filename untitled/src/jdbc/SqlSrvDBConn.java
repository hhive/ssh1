package jdbc;
import java.sql.*;

public class SqlSrvDBConn {
	private Statement stmt;
    private Connection conn;
    ResultSet rs;
    //�ڹ��췽���д������ݿ�����
    public SqlSrvDBConn(){
        //����������
        String driver = "com.mysql.cj.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://localhost:3306/webtest?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "8888";
    	stmt=null;
    	try{
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            conn = DriverManager.getConnection(url,user,password);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	rs=null;

    }
    //ִ�в�ѯ���SQL��䣬�з��ؼ�
    public ResultSet executeQuery(String sql)
    {
        try
        {
        	stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	rs=stmt.executeQuery(sql);
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;
    }

    /**
     * insert
     */
    public int executeUpdate(String sql) {
        int rows = 0;
        try
        {
            stmt=conn.createStatement();
            rows = stmt.executeUpdate(sql);

        }catch(SQLException e){
            System.err.println("Data.executeUpdate: " + e.getMessage());
        }
        return rows;
    }
    //�رն���
    public void closeStmt()
    {
        try
        {
            stmt.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
    public void closeConn()
    {
        try
        {
            conn.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}

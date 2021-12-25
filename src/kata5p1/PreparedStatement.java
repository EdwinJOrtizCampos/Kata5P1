package kata5p1;

/**
 *
 * @author edwin
 */ 
public class PreparedStatement {
    private String sql;
    
    public PreparedStatement(sql){
        this.sql = sql;
    }
    
    public void setString(String index, String email){
        sql.replace("direccion", index).replace("?", email); 
    }
    
    public void executeUpdate(){
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

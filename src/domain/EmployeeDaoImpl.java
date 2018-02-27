package domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl  implements EmployeeDAO{
    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public Employee getEmploye(int empId) {
        Employee e = (Employee)jdbcTemplate.queryForObject(this.employee_Select,
                new Object[]{new Integer(empId)},
                new RowMapper(){

                    public Object mapRow(ResultSet rs, int arg1)
                            throws SQLException {
                        Employee e = new Employee();
                        e.setEmployeeName(rs.getString("EMP_NAME"));
                        e.setEmployeeDept(rs.getString("EMP_DEPT"));
                        e.setEmailId(rs.getString("EMP_EMAILID"));
                        e.setEmpId(rs.getInt("EMP_ID"));
                        return e;
                    }

                });
        return e;
    }

    public void saveEmployee(Employee e) {
        this.jdbcTemplate.update(this.employee_insert, new Object[]{e.getEmployeeName(),e.getEmployeeDept(),e.getEmailId()});

    }


    public void updateEmployee(Employee e) {
        this.jdbcTemplate.update(this.employee_update, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmailId(), new Integer(e.getEmpId())} );

    }

    private final String employee_Select = "SELECT * FROM EMPLOYEE WHERE EMP_ID= ?";
    private final String employee_insert = "INSERT INTO EMPLOYEE( EMP_NAME, EMP_DEPT, EMP_EMAILID) VALUES(?,?,?)";
    private final String employee_update = "UPDATE EMPLOYEE SET EMP_NAME=?, EMP_DEPT=?,EMP_EMAILID=? WHERE EMP_ID = ?" ;

}
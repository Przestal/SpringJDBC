package domain;

public interface EmployeeDAO {

    public void saveEmployee(Employee e);
    public void updateEmployee(Employee e);
    public Employee getEmploye(int empId);
}

package domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeExec {


    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("resources/jdbc.xml");
        EmployeeDAO empDao = (EmployeeDAO)ctx.getBean("employeeDao");
        Employee employee = new Employee();
        employee.setEmployeeName("Przemek");
        employee.setEmployeeDept("IT");
        employee.setEmailId("przemek@email.pl");

        empDao.saveEmployee(employee);

        //getting the data
        Employee emp = empDao.getEmploye(5);

        System.out.println("Employee name :"+emp.getEmployeeName());
        System.out.println("Employee email :"+emp.getEmailId());
        System.out.println("Employee department:"+emp.getEmployeeDept());


    }

}
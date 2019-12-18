package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST 1: department findById =====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);
        System.out.println();

        System.out.println("===== TEST 2: department findAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===== TEST 3: department insert =====");
        Department newDepartment = new Department(null, "Musica");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());


        System.out.println("\n===== TEST 4: department update =====");
        newDepartment = departmentDao.findById(6);
        newDepartment.setName("Cars");
        departmentDao.update(newDepartment);
        System.out.println("Update completed");

        System.out.println("\n===== TEST 6: department delete =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");      
    }



}

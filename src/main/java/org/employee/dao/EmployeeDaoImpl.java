package org.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ord.employee.model.Employee;


public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Employee 	employee) {

		String sql = "insert into employee_info(firstname, lastname, email, hobby, phonenumber) values(?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { employee.getFirstname(), employee.getLastname(), employee.getEmail(), employee.getHobby(), employee.getPhonenumber() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Employee> read() {
		List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM employee_info", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();

				employee.setId(rs.getInt("emp_id"));
				employee.setFirstname(rs.getString("firstname"));
				employee.setLastname(rs.getString("lastname"));
				employee.setEmail(rs.getString("email"));
				employee.setHobby(rs.getString("hobby"));
				employee.setPhonenumber(rs.getLong("phonenumber"));

				return employee;
			}

		});

		return employeeList;
	}

	@Override
	public List<Employee> findEmployeeById(int id) {

		List<Employee> employeeList = jdbcTemplate.query("select * from employee_info where emp_id=?",
				new Object[] { id }, new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee employee = new Employee();

						employee.setId(rs.getInt("emp_id"));
						employee.setFirstname(rs.getString("firstname"));
						employee.setLastname(rs.getString("lastname"));
						employee.setEmail(rs.getString("email"));
						employee.setHobby(rs.getString("hobby"));
						employee.setPhonenumber(rs.getLong("phonenumber"));

						return employee;
					}

				});

		return employeeList;
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee_info set firstname=?, lastname=?, email=?, hobby=?, phonenumber=? where emp_id=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] {  employee.getFirstname(), employee.getLastname(), employee.getEmail(), employee.getHobby(), employee.getPhonenumber(), employee.getId() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		String sql = "delete from employee_info where emp_id=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { id });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
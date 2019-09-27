package com.hibernateinfo.client;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.service.EmployeeService;
import com.hibernateinfo.service.impl.EmployeeServiceImpl;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest2FetchDataUsingEmployeeId {

	public static void main(String[] args) 
	{
		getEmployeeAndAddressByEmployeeId();
	}	
	
	
	
	private static void getEmployeeAndAddressByEmployeeId() 
	{	
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
		System.out.println("**********************************");
		if (employee != null) {
			employee.getAddressList().forEach(System.out::println);
		}
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
fetch=FetchType.EAGER Hibernate will hit database just once!
Hibernate: 
    select
        employee0_.employee_id as employee_id1_1_0_,
        employee0_.date_of_join as date_of_join2_1_0_,
        employee0_.email as email3_1_0_,
        employee0_.employee_name as employee_name4_1_0_,
        employee0_.salary as salary5_1_0_,
        addresslis1_.employee_id as employee_id6_0_1_,
        addresslis1_.address_id as address_id1_0_1_,
        addresslis1_.address_id as address_id1_0_2_,
        addresslis1_.city_name as city_name2_0_2_,
        addresslis1_.employee_id as employee_id6_0_2_,
        addresslis1_.postal_code as postal_code3_0_2_,
        addresslis1_.state_name as state_name4_0_2_,
        addresslis1_.street_name as street_name5_0_2_ 
    from
        employee_table employee0_ 
    left outer join
        address_table addresslis1_ 
            on employee0_.employee_id=addresslis1_.employee_id 
    where
        employee0_.employee_id=?
Employee [employeeId=1, employeeName=Pasha Sadi, email=pasha.sn@gmail.com, doj=2019-01-01 00:00:00.000, addressList=[Address [addressId=2, street=Guy St, city=Montreal, state=Quebec, postalcode=19317], Address [addressId=3, street=Peel St, city=Montreal, state=Quebec, postalcode=19318]], salary=65001.0]
**********************************
Address [addressId=2, street=Guy St, city=Montreal, state=Quebec, postalcode=19317]
Address [addressId=3, street=Peel St, city=Montreal, state=Quebec, postalcode=19318]

*/
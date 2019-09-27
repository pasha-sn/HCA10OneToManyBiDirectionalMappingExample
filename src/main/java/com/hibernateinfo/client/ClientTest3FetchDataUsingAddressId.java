package com.hibernateinfo.client;

import org.hibernate.Session;

import com.hibernateinfo.entities.Address;
import com.hibernateinfo.util.HibernateUtil;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest3FetchDataUsingAddressId {

	public static void main(String[] args) 
	{
		getEmployeeAndAddressByAddressId();
	}	
	
	
	
	private static void getEmployeeAndAddressByAddressId() 
	{		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			Address address = session.get(Address.class, 2);
			System.out.println(address);
			System.out.println("**********************************");
			if (address != null) 
			{
				System.out.println(address.getEmployee());	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    select
        address0_.address_id as address_id1_0_0_,
        address0_.city_name as city_name2_0_0_,
        address0_.employee_id as employee_id6_0_0_,
        address0_.postal_code as postal_code3_0_0_,
        address0_.state_name as state_name4_0_0_,
        address0_.street_name as street_name5_0_0_,
        employee1_.employee_id as employee_id1_1_1_,
        employee1_.date_of_join as date_of_join2_1_1_,
        employee1_.email as email3_1_1_,
        employee1_.employee_name as employee_name4_1_1_,
        employee1_.salary as salary5_1_1_ 
    from
        address_table address0_ 
    left outer join
        employee_table employee1_ 
            on address0_.employee_id=employee1_.employee_id 
    where
        address0_.address_id=?
Hibernate: 
    select
        addresslis0_.employee_id as employee_id6_0_0_,
        addresslis0_.address_id as address_id1_0_0_,
        addresslis0_.address_id as address_id1_0_1_,
        addresslis0_.city_name as city_name2_0_1_,
        addresslis0_.employee_id as employee_id6_0_1_,
        addresslis0_.postal_code as postal_code3_0_1_,
        addresslis0_.state_name as state_name4_0_1_,
        addresslis0_.street_name as street_name5_0_1_ 
    from
        address_table addresslis0_ 
    where
        addresslis0_.employee_id=?
Address [addressId=2, street=Guy St, city=Montreal, state=Quebec, postalcode=19317]
**********************************
Employee [employeeId=1, employeeName=Pasha Sadi, email=pasha.sn@gmail.com, doj=2019-01-01 00:00:00.000, addressList=[Address [addressId=2, street=Guy St, city=Montreal, state=Quebec, postalcode=19317], Address [addressId=3, street=Peel St, city=Montreal, state=Quebec, postalcode=19318]], salary=65001.0]

*/
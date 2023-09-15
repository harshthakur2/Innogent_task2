package com.task2.file;

public class Class {

	public static void main(String[] args) {
		//Q-1	
		static List<Student>	 studentHavingPinCode(List<Student> studentList, List<Address> addressList, int pin_code)
		{

		//List<Address> newaddressList = 	addressList.stream().filter(a -> a.getPin_code() == pin_code).collect(Collectors.toList());

		//here firstly took one student id and check it in all address id's then if id matches then we check the pin_code if condition satisfies then collect it.
			//but here many streams will create
		List<Student> studentsOfPin_code = studentList.stream().filter(student -> addressList.stream().anyMatch(address -> address.getStudent_id() == student.getId() && address.getPin_code() == pin_code)).collect(Collectors.toList());

		//another way
		//here we firstly filter the address stream by pin_code and map that stream into its student_id and collect as list then we filter the student list by this student_id list.
		 List<Integer> newList= addressList.stream().filter(a -> a.getPin_code() == pin_code ).map(Address::getStudent_id).collect(Collectors.toList());
		 List<Student> studentsOfPin_codeX = studentList.stream().filter(student -> newList.contains(student.getId())).collect(Collectors.toList());
		 
		//If any filter is applied for example by gender then 
		 List<Student> newStudentsOfPin_codeX = studentsOfPin_codeX.stream().filter(s -> s.getGender().equals("F")).collect(Collectors.toList());   

		  
		 
		//return studentsOfPin_codeX;	
		return newStudentsOfPin_codeX;
		}

		//Q-2
		static List<Student>	 studentHavingCity(List<Student> studentList, List<Address> addressList, String  city)
		{
		List<Student> studentsOfCity= studentList.stream().filter(student -> addressList.stream().anyMatch(address -> address.getStudent_id() == student.getId() && address.getCity().equals(city))).collect(Collectors.toList());

		List<Integer> newList= addressList.stream().filter(a -> a.getCity().equals(city)).map(Address::getStudent_id).collect(Collectors.toList());
		 List<Student> studentsOfCityX = studentList.stream().filter(student -> newList.contains(student.getId())).collect(Collectors.toList());
		//If any filter is applied for example by age then 
		//List<Student> newStudentsOfCityX = studentsOfCityX.stream().filter(s -> s.getAge() > 20).collect(Collectors.toList());   

		return studentsOfCityX;	
		}

	}

}

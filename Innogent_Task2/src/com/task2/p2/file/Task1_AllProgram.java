package com.task2.p2.file;

import java.util.Comparator;
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1_AllProgram
{

	public Task1_AllProgram()
	{
		// TODO Auto-generated constructor stub
	}

//Q-1)
static List<Student> studentHavingPinCode(List<Student> studentList, List<Address> addressList, int pin_code)
{
//here we firstly filter the address stream by pin_code and map that stream into its student_id and collect as list then we filter the student list by this student_id list.
 List<Integer> newList= addressList.stream().filter(a -> a.getPin_code() == pin_code ).map(Address::getStudent_id).collect(Collectors.toList());
 List<Student> studentsOfPin_codeX = studentList.stream().filter(student -> newList.contains(student.getId())).collect(Collectors.toList());
 
//If any filter is applied for example by gender then 
 List<Student> newStudentsOfPin_codeX = studentsOfPin_codeX.stream().filter(s -> s.getGender().equals("F")).collect(Collectors.toList());   

 return studentsOfPin_codeX;	

}

//Q-2)
static List<Student>	 studentHavingCity(List<Student> studentList, List<Address> addressList, String  city)
{
List<Student> studentsOfCity= studentList.stream().filter(student -> addressList.stream().anyMatch(address -> address.getStudent_id() == student.getId() && address.getCity().equals(city))).collect(Collectors.toList());

List<Integer> newList= addressList.stream().filter(a -> a.getCity().equals(city)).map(Address::getStudent_id).collect(Collectors.toList());
 List<Student> studentsOfCityX = studentList.stream().filter(student -> newList.contains(student.getId())).collect(Collectors.toList());
//If any filter is applied for example by age then 
//List<Student> newStudentsOfCityX = studentsOfCityX.stream().filter(s -> s.getAge() > 20).collect(Collectors.toList());   

return studentsOfCityX;	
}

//Q.3)
public static List<Student> getPassingStudents(List<Student> studentList) {
    return studentList.stream()
            .filter(student -> student.getMarks() >= 50)
            .collect(Collectors.toList());
}

public static List<Student> getFailingStudents(List<Student> studentList) {
    return studentList.stream()
            .filter(student -> student.getMarks() < 50)
            .collect(Collectors.toList());
}

public static List<Student> getHighestMarkAchievers(List<Student> studentList) {
    return studentList.stream()
            .sorted(Comparator.comparingInt(Student::getMarks).reversed())
            .limit(3)
            .collect(Collectors.toList());
}

public static List<Student> assignRanksToHighestMarkAchievers(List<Student> studentList) {
    List<Student> highestMarkAchievers = getHighestMarkAchievers(studentList);
    for (int i = 0; i < highestMarkAchievers.size(); i++) {
        highestMarkAchievers.get(i).setName("Rank " + (i + 1) + ": " + highestMarkAchievers.get(i).getName());
    }
   return highestMarkAchievers;
}



//Q-4)
static List<Student>	 passedStudents(List<Student> studentList)
{
List<Student> passedStudents = studentList.stream().filter(student -> student.getMarks() >= 50).collect(Collectors.toList());

//If any filter is applied for example by age then 
List<Student> newPassedStudents = passedStudents.stream().filter(s -> s.getAge() < 50).collect(Collectors.toList());   

return passedStudents;	
//return newPassedStudents;	
}

//Q-5
static List<Student>	 failedStudents(List<Student> studentList)
{
List<Student> failedStudents = studentList.stream().filter(student -> student.getMarks() < 50).collect(Collectors.toList());
return failedStudents;	

}


//Q-6
static List<Student>	 studentHavingClass(List<Student> studentList, List<Class> ClassList, String  class1)
{
List<Integer> newList= ClassList.stream().filter(c -> c.getName().equals(class1)).map(Class::getId).collect(Collectors.toList());
List<Student> studentsOfClassX = studentList.stream().filter(student -> newList.contains(student.getClass_id())).collect(Collectors.toList());

//If any filter is applied for example by age then 
//List<Student> newStudentsOfClassX = studentsOfClassX.stream().filter(s -> s.getAge() < 45).collect(Collectors.toList());   

return studentsOfClassX;	
//return newStudentsOfClassX;	
}


//Q-7
static List<Student>	 failedStudentsByAge(List<Student> studentList)
{
List<Student> failedStudentsByAge = studentList.stream().filter(student -> student.getAge() < 20).collect(Collectors.toList());

//If any filter is applied for example by age then 
//List<Student> newFailedStudentsByAge = failedStudentsByAge.stream().filter(s -> s.getAge() < 35).collect(Collectors.toList()); 

return failedStudentsByAge;	
//return newFailedStudentsByAge;	
}

//Q.8
public static void deleteStudent(List<Student> studentList, List<Address> addressList, int studentId) {
    studentList.removeIf(student -> student.getId() == studentId ); // public boolean removeIf(Predicate filter)
    addressList.removeIf(address -> address.getStudent_id() == studentId);
}

//Q.9
public static List<Class> deleteClass(List<Student> studentList, List<Class> ClassList) {
List<Integer> newIdList =   studentList.stream().map(Student::getClass_id).collect(Collectors.toList());
List<Class> newClassList = ClassList.stream().filter(Class ->newIdList.contains(Class.getId())).collect(Collectors.toList());
return newClassList;
}



//Q.10
static List<Student>	getFemaleStudentsList(List<Student> studentList)
{
List<Student> femaleStudents = studentList.stream()
.filter(student -> student.getGender().equals("F"))
.collect(Collectors.toList());
return femaleStudents;
}

public static List<Student> getFirstFemaleListInRange(List<Student> studentList, int start, int end) {
    return getFemaleStudentsList(studentList).stream()
            .skip(start - 1)
            .limit(end - start + 1)
            .collect(Collectors.toList());
}

private static List<Student> getFemaleOrderByName(List<Student> studentList, int start, int end) {
    return getFemaleStudentsList(studentList).stream()
            .sorted(Comparator.comparing(Student::getName))
            .skip(start - 1)
            .limit(end - start + 1)
            .collect(Collectors.toList());
}

private static List<Student> getFemaleOrderByMarks(List<Student> studentList, int start, int end) {
    return getFemaleStudentsList(studentList).stream()
            .sorted(Comparator.comparingInt(Student::getMarks).reversed())
            .skip(start - 1)
            .limit(end - start + 1)
            .collect(Collectors.toList());
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> studentList  	= ReadCsv.studentList;
		List<Address> addressList   = ReadCsv.addressList;
		List<Class>   ClassList     = ReadCsv.classList;
		//1
		List<Student> updatedStudentList1 = studentHavingPinCode(studentList, addressList, 452002);
		System.out.println(updatedStudentList1);
		
		//2
		List<Student> updatedStudentList2 = studentHavingCity(studentList, addressList, "indore");
		//System.out.println(updatedStudentList2);
		
		//3
		//System.out.println(getPassingStudents(studentList));
		//System.out.println(getFailingStudents(studentList));
		//System.out.println(assignRanksToHighestMarkAchievers(studentList));
		
		//4
		List<Student> updatedStudentList4 = passedStudents(studentList);
		//System.out.println(updatedStudentList4);
		
		//5
		List<Student> updatedStudentList5 = failedStudents(studentList);
		//System.out.println(updatedStudentList5);
		
		//6
		List<Student> updatedStudentList6 = studentHavingClass(studentList, ClassList, "A");
		//System.out.println(updatedStudentList6);
		
		//7
		List<Student> updatedStudentList7 = failedStudentsByAge(studentList);
		//System.out.println(updatedStudentList7);
		
		//8
		//deleteStudent(studentList, addressList,100);

		//9
		//System.out.println(deleteClass(studentList,ClassList));
		
		//10
		/*
		System.out.println(getFemaleStudentsList(studentList));
		System.out.println(getFirstFemaleListInRange(studentList,1,9));
		System.out.println(getFemaleOrderByName(studentList,7,8));
		System.out.println(getFemaleOrderByMarks(studentList,1,5));
		System.out.println(getFemaleOrderByMarks(studentList,9,50));
		*/

		
	}

}
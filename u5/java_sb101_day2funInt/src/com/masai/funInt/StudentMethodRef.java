package com.masai.funInt;

@FunctionalInterface
interface Demo1{
public void printDetail(StudentMethodRef st);
};


public class StudentMethodRef {
		String name;

		public StudentMethodRef(String name) {
			
			this.name = name;
		}
		
		public void printStudentDetail(StudentMethodRef st) {
	        System.out.println("Name: " + st.name );
	    }
		static public void printStudentDetailStatic(StudentMethodRef st) {
	        System.out.println("Name: " + st.name );
	    }

		@Override
		public String toString() {
			return "StudentMethodRef [name=" + name + "]";
		}
		
		public static void main(String[] args) {
			
			
//			method ref of obj method 
			
			StudentMethodRef st = new StudentMethodRef("John Doe");
			Demo1 demo1 = st::printStudentDetail;
			demo1.printDetail(st);
			
//			method ref of static method 
			
			Demo1 demo2 = StudentMethodRef::printStudentDetailStatic;
			demo2.printDetail(new StudentMethodRef("Naveen") );
			
//			Demo1 demo3 = StudentMethodRef::new;
			

			
		}
}

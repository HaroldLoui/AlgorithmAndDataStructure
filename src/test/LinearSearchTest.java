package test;

import main.algorithm.LinearSearch;
import main.common.Student;

public class LinearSearchTest {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 23, 43, 14, 565, 87, 231, 2314, 567, 123};
        int target = 0;
        System.out.println(LinearSearch.search(data, target));

        Student[] students = new Student[3];
        students[0] = new Student("A", "111");
        students[1] = new Student("B", "222");
        students[2] = new Student("C", "333");

        Student student = new Student("B", "222");
        System.out.println(LinearSearch.search(students, student));
    }
}

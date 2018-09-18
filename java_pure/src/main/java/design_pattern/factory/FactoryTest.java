package design_pattern.factory;

import design_pattern.factory.instance.StudentWorkFactory;
import design_pattern.factory.instance.TeacherWorkFactory;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class FactoryTest {

    public static void main(String[] args) {
        StudentWorkFactory studentWorkFactory = new StudentWorkFactory();
        TeacherWorkFactory teacherWorkFactory = new TeacherWorkFactory();

        studentWorkFactory.getWork().doWork();
        teacherWorkFactory.getWork().doWork();
    }
}

package design_pattern.factory.instance;

import design_pattern.factory.StudentWork;
import design_pattern.factory.TeacherWork;
import design_pattern.factory.Work;
import design_pattern.factory.WorkFactory;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TeacherWorkFactory implements WorkFactory {
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}

package design_pattern.factory;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class StudentWork implements Work {
    @Override
    public void doWork() {
        System.out.println(getClass().getSimpleName() + " do work...");
    }
}

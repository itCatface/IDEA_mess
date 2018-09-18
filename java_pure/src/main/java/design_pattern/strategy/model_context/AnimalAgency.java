package design_pattern.strategy.model_context;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class AnimalAgency {

    private Animal mAnimal;

    public AnimalAgency(Animal animal) {
        mAnimal = animal;
    }

    public void call() {
        mAnimal.doCall();
    }

}

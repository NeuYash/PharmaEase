package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Builder.BuilderAPI;

public abstract class AbstractFactory<T> {
    public abstract T getObject(BuilderAPI<T> buildObject);

}

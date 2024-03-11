package com.wipro.designpatterns.factory;

public class FactoryPatternDemo {

    public static void main(String[] args){

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circleShape = shapeFactory.getShape("Circle");
        circleShape.draw();

        Shape rectangleShape = shapeFactory.getShape("Rectangle");
        rectangleShape.draw();

        Shape squareShape = shapeFactory.getShape("Square");
        squareShape.draw();
    }
}

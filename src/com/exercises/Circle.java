package com.exercises;

import java.util.Objects;

public class Circle {
    private String name;
    private int radius;

    public Circle() {}

    public Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "{" + '\n' +
                "name : " + name + '\n' +
                "radius : " + radius + '\n' +
                "area : " + getArea() + '\n' +
                "perimeter : " + getPerimeter() + '\n' +
                '}' + ',' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, radius);
    }

}

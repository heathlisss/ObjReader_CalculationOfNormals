package com.cgvsu.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorOperationsTest {

    @Test
    void vector() {
        Vector3f expectedResult = new Vector3f(0.0F, 0.0F, -1.0F);
        Vector3f result = VectorOperations.vector(new Vector3f(1.0F, 0.0F, 1.0F),
                new Vector3f(1.0F, 0.0F, 0.0F));
        Assertions.assertTrue(expectedResult.equals(result));
        expectedResult = new Vector3f(-1.0F, 1.0F, -1.0F);
        result = VectorOperations.vector(new Vector3f(1.0F, 0.0F, 1.0F),
                new Vector3f(0.0F, 1.0F, 0.0F));
        Assertions.assertTrue(expectedResult.equals(result));
    }

    @Test
    void vectorProduct() {
        Vector3f expectedResult = new Vector3f(1.0F, 1.0F, 0.0F);
        Vector3f result = VectorOperations.vectorProduct(new Vector3f(0.0F, 0.0F, -1.0F),
                new Vector3f(-1.0F, 1.0F, -1.0F));
        Assertions.assertTrue(expectedResult.equals(result));

    }

    @Test
    void summaVector() {
        Vector3f expectedResult = new Vector3f(1.0F, 1.0F, 1.0F);
        Vector3f result = VectorOperations.summaVector(new Vector3f(1.0F, 1.0F, 0.0F),
                new Vector3f(0.0F, 0.0F, 1.0F));
        Assertions.assertTrue(expectedResult.equals(result));
        expectedResult = new Vector3f(1.0F, 0.0F, 1.0F);
        result = VectorOperations.summaVector(new Vector3f(1.0F, 1.0F, 1.0F),
                new Vector3f(0.0F, -1.0F, 0.0F));
        Assertions.assertTrue(expectedResult.equals(result));
    }

    @Test
    void quotient() {
        Vector3f expectedResult = new Vector3f(1.0F / 3, 0.0F, 1.0F / 3);
        Vector3f result = VectorOperations.quotient(new Vector3f(1.0F, 0.0F, 1.0F), 3);
        Assertions.assertTrue(expectedResult.equals(result));
    }

    @Test
    void normalize() {
        Vector3f expectedResult = new Vector3f((float) (1.0F / Math.sqrt(2)), 0.0F, (float) (1.0F / Math.sqrt(2)));
        Vector3f result = VectorOperations.normalize(new Vector3f(1.0F / 3, 0.0F, 1.0F / 3));
        Assertions.assertTrue(expectedResult.equals(result));
    }

    @Test
    void normalize2() {
        Vector3f expectedResult = new Vector3f(0, 0,0);
        Vector3f result = VectorOperations.normalize(new Vector3f(0, 0, 0));
        //Assertions.assertTrue(expectedResult.equals(result));
    }

}
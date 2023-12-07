package com.cgvsu.model;

import com.cgvsu.math.Vector3f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class NormalTest {

    @Test
    void normalsVertex() {
        Model model = new Model();
        model.vertices = new ArrayList<>(List.of(new Vector3f[]{
                new Vector3f(1.0f, 0.0f, 1.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 0.0f)
        }));
        model.polygons = new ArrayList<>(List.of(new Polygon[]{
                new Polygon(new ArrayList<>(List.of(new Integer[]{0, 1, 2, 3}))),
                new Polygon(new ArrayList<>(List.of(new Integer[]{3,2,5,4}))),
                new Polygon(new ArrayList<>(List.of(new Integer[]{0, 4, 5, 1}))),
                new Polygon(new ArrayList<>(List.of(new Integer[]{1, 5, 2}))),
                new Polygon(new ArrayList<>(List.of(new Integer[]{0, 3, 4})))
        }));
        ArrayList<Vector3f> resultNormalsVertex = Normal.normalsVertex(model.vertices, model.polygons);
        ArrayList<Vector3f> expectedResultNormalsVertex = new ArrayList<>(List.of(new Vector3f[]{
                new Vector3f((float) (1.0f / Math.sqrt(2)), 0.0f, (float) (1.0f / Math.sqrt(2))),
                new Vector3f((float) (1.0f / Math.sqrt(2)), 0.0f, (float) (-1.0f / Math.sqrt(2))),
                new Vector3f(0.0f, (float) (1.0f / Math.sqrt(2)), (float) (-1.0f / Math.sqrt(2))),
                new Vector3f(0.0f, (float) (1.0f / Math.sqrt(2)), (float) (1.0f / Math.sqrt(2))),
                new Vector3f((float) (-1.0f / Math.sqrt(3)), (float) (-1.0f / Math.sqrt(3)), (float) (1.0f / Math.sqrt(3))),
                new Vector3f((float) (-1.0f / Math.sqrt(3)), (float) (-1.0f / Math.sqrt(3)), (float) (-1.0f / Math.sqrt(3)))
        }));
        for(int i=0;i<resultNormalsVertex.size();i++){
            Assertions.assertTrue(resultNormalsVertex.get(i).equals(expectedResultNormalsVertex.get(i)));
        }
    }
}
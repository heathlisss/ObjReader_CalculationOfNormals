package com.cgvsu.model;

import com.cgvsu.math.Vector3f;
import com.cgvsu.math.VectorOperations;

import java.util.ArrayList;

public class Normal {
    private static final ArrayList<Vector3f> normalsVertex = new ArrayList<Vector3f>();
    private static final ArrayList<Vector3f> normalsPolygon = new ArrayList<Vector3f>();

    private static Vector3f normalPolygon(Polygon polygon, ArrayList<Vector3f> vertices) {
        ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
        try {
            return VectorOperations.vectorProduct(VectorOperations.vector(vertices.get(vertexIndices.get(0)), vertices.get(vertexIndices.get(1))),
                    VectorOperations.vector(vertices.get(vertexIndices.get(0)), vertices.get(vertexIndices.get(2))));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("известно менее 3 вершин (у полигона)");
        }
        return null;
    }

    public static ArrayList<Vector3f> normalsVertex(ArrayList<Vector3f> vertices, ArrayList<Polygon> polygons) {
        Integer[] count = new Integer[vertices.size()];
        Vector3f[] normalSummaVertex = new Vector3f[vertices.size()];
        for (int i = 0; i < polygons.size(); i++) {
            normalsPolygon.add(i, normalPolygon(polygons.get(i), vertices));
            ArrayList<Integer> vertexIndices = polygons.get(i).getVertexIndices();

            polygons.get(i).setNormalIndices(vertexIndices);

            for (int j = 0; j < vertexIndices.size(); j++) {
                if (normalSummaVertex[vertexIndices.get(j)] == null) {
                    normalSummaVertex[vertexIndices.get(j)] = normalsPolygon.get(i);
                    count[vertexIndices.get(j)] = 1;
                } else {
                    normalSummaVertex[vertexIndices.get(j)] = VectorOperations.summaVector(normalSummaVertex[vertexIndices.get(j)], normalsPolygon.get(i));
                    count[vertexIndices.get(j)]++;
                }

            }
        }
        for (int i = 0; i < count.length; i++) {
            normalsVertex.add(i, VectorOperations.normaliz(VectorOperations.quotient(normalSummaVertex[i], count[i])));
        }
        return normalsVertex;
    }

}

package bodies;

import java.util.ArrayList;
import core.Vector;

/**
 * Created by Jordan on 2016-11-06.
 */
public class Shape {

    /**
     * Identifies a shape as one of the following:
     * Each category uses a different collision detection method
     * */
    public ShapeType shapeType;

    /**
     * Stores the vertices of this shape as a core.Vector array
     */
    public Vector[] vertices;

    /**
     * Used when creating a new shape using an editor
     */
    private ArrayList<Vector> tempVertices;

    // Constructor
    public Shape(Vector[] vertices, ShapeType shapeType) {
        this.shapeType = shapeType;
        this.vertices = vertices;
    }

    public Shape() {
        shapeType = ShapeType.POLYGON;
        tempVertices = new ArrayList<>();
    }


    /**
     * Adds a Vertex vector to the arrayList
     */
    public void addVertex(Vector v) {
        tempVertices.add(v);
    }

    /**
     * Converts the tempVertices ArrayList to a core.Vector array
     * */
    public void createShape() {
        if (tempVertices != null) {
            vertices = tempVertices.toArray(vertices);
        }
    }


    // Getters and Setters
    public ArrayList<Vector> getTempVertices() {
        return tempVertices;
    }
}

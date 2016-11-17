package collision;

import bodies.Body;
import core.MyVector;

/**
 * Created by Jordan on 2016-11-06.
 */
public class Manifold {

    public Body body1;
    public Body body2;
    public float penetration;
    public MyVector normal;


    // Constructor
    public Manifold(Body body1, Body body2, float penetration, MyVector normal) {
        this.body1 = body1;
        this.body2 = body2;
        this.penetration = penetration;
        this.normal = normal;
    }

    public Manifold(CollisionPair collisionPair) {

    }
}

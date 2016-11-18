package collision;

import bodies.Body;
import core.MyVector;

/**
 * Created by Jordan on 2016-11-06.
 */
public class Manifold {

    public Body body1;
    public Body body2;
    public int contactCount;
    public float penetration;
    public MyVector normal;

    public float restitutionAvg;
    public float staticFricAvg;
    public float dynamicFricAvg;


    // Constructor
    public Manifold(Body body1, Body body2) {
        this.body1 = body1;
        this.body2 = body2;

    }

    public Manifold(CollisionPair collisionPair) {
        collisionPair.body1 = body1;
        collisionPair.body2 = body2;
    }

    /**
     *
     * */
    public void initialize() {
        // Calculate average restitution
        restitutionAvg = min(body1.material.restitution, body2.material.restitution);

        // Calculate static and dynamic friction
        staticFricAvg = (float)StrictMath.sqrt(body1.material.staticFriction * body2.material.staticFriction);
        dynamicFricAvg = (float)StrictMath.sqrt(body1.material.dynamicFriction * body2.material.dynamicFriction);
    }

    /**
     *
     * */
    public void solve() {

    }

    /**
     * Returns the minimum of two flaot values
     * */
    public float min(float v1, float v2) {
        return v1 < v2 ? v1 : v2;
    }
}

package collision;

import bodies.Body;

/**
 * Created by Jordan on 2016-11-06.
 */
public class CollisionPair {

    public Body body1;
    public Body body2;

    // Constructor
    public CollisionPair(Body body1, Body body2) {
        this.body1 = body1;
        this.body2 = body2;
    }

}

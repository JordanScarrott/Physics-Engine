package bodies;

import core.MyVector;

/**
 * Created by Jordan on 2016-11-06.
 */
public class Body {

    public Shape shape;
    public Transform transform;
    public Material material;
    public MassData massData;
    public MyVector location;
    public MyVector velocity;
    public MyVector forces;
    public float angularVelocity;
//    private int gravityScale;

    // Constructor
    public Body(Shape shape, Material material, MassData massData, MyVector location) {
        this.shape = shape;
        this.material = material;
        this.massData = massData;
        this.location = location;
        this.velocity = new MyVector();
        this.forces = new MyVector();
        angularVelocity = 0.0f;
    }
    public Body(Shape shape, MaterialType materialType, MassData massData, MyVector location) {
        this(shape, new Material(materialType), massData, location);
    }

    /**
     * Apply a new Force to the Body represented by this instance
     * @param force the forces to be applied
     * */
    public void applyForce(MyVector force) {
        forces.add(force);
    }

    /**
     * Apply an impulse to the Body represented by this instance
     * @param impulse the impulse {@code MyVector} to be applied
     * @param contactVector
     * */
    public void applyImpulse(MyVector impulse, MyVector contactVector) {
        // v += invMass * impulse;
        // angV += invInertia * CrossProd(contactVector, impulse);
        velocity.add(impulse.mult(massData.invMass));
//        angularVelocity += massData.invInertia * contactVector.cross(impulse);
    }

    /**
     * Sets this Body to STATIC
     * */
    void SetStatic() {
        this.material = new Material(MaterialType.STATIC);
        this.massData.setSTATIC();
    }

    /**
     * Returns true if the MaterialType of the Body represented by this
     * instance is the same as the specified MaterialType
     *
     * @param materialType the material type to which this instance will be compared
     * @return true if the MaterialType of the Body represented by this
     * instance is the same as the specified MaterialType and false if not
     * */
    public boolean isType(MaterialType materialType) {
        if (this.material.density == materialType.getDensity()) {
            if (this.material.restitution == materialType.getRestitution()) {
                return true;
            }
        }
        return false;
    }
    public boolean isSTATIC() {
        return this.material.density == 0.0;
    }

    // Getters and Setters

}

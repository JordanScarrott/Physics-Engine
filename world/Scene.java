package world;

import bodies.*;
import core.MyVector;

import java.util.Vector;

/**
 * Created by Jordan on 2016-11-17.
 */
public class Scene {

    // Using Vector because it is apparently synchronized
    private Vector<Body> bodies;
    private MyVector gravity;
    private float dt;
    private float invDt;

    // Constructor
    public Scene(MyVector gravity, float dt) {
        this.bodies = new Vector<>();
        this.gravity = gravity;
        this.dt = dt;
        this.invDt = 1 / dt;
    }

    /**
     * Add a new Body to the Vector of bodies handled by the physics engine
     * */
    public void addBody(Shape shape, Material material, MassData massData, MyVector location) {
        bodies.add(new Body(shape, material, massData, location));
    }

    /**
     * Integrates the velocity of a Body
     *
     * */
    public void integrateVelocity(Body b, float dt) {
        if (b.isSTATIC()) return;

        // v += 1 / mass * force * dt
        // Vector f = b.force.mult(b.massData.invMass * dt);
        // b.velocity.add(f);
        b.velocity.add(b.force.mult(b.massData.invMass * dt));

        integrateForces(b, dt);
    }

    /**
     * Integrates the Forces acting on a Body
     * @param b the body who's forces will be integrated
     * @param dt the time interval to integrate by
     * */
    public void integrateForces(Body b, float dt) {
        // x += v * dt
        b.location.add(b.velocity.mult(dt));
    }


    // Getters and Setters
    public Vector<Body> getBodies() {
        return bodies;
    }
}

package world;

import bodies.*;
import collision.Manifold;
import core.MyVector;

import java.util.Vector;

/**
 * Created by Jordan on 2016-11-17.
 */
public class Scene {

    // Using Vector because it is apparently synchronized
    private Vector<Body> bodies;
    private Vector<Manifold> contacts;
    private MyVector gravity;
    private float dt;
    private float invDt;

    // Constructor
    public Scene(MyVector gravity, float dt) {
        this.bodies = new Vector<>();
        this.contacts = new Vector<>();
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

    public void step(float dt) {
        // Generate new collision info
        for (int i = 0; i < bodies.size(); i++) {
            Body a = bodies.get(i);
            for (int j = i + 1; j < bodies.size(); j++) {
                Body b = bodies.get(j);
                if (a.massData.invMass == 0 && b.massData.invMass == 0) continue;

                Manifold m = new Manifold(a, b);
                m.solve();
                /**NEEDS MORE STUFF HERE*/
                if (m.contactCount > 0) {
                    contacts.add(m);
                }
            }
        }

        // Integrate forces
        for (Body b : bodies) {
            integrateForces(b, dt);
        }
        // Initialize collision
        for (Manifold m : contacts) {
            m.initialize();
        }
        // Solve collisions

        // Integrate velocities
        for (Body b : bodies) { // note that this is the second time integrating forces this iteration!?
            integrateVelocity(b, dt);
        }
        // Correct positions

        // Clear all forces
        for (Body b : bodies) {
            b.forces.set(0, 0);
        }
    }

    /**
     * Integrates the velocity of a Body
     *
     * */
    public void integrateVelocity(Body b, float dt) {
        if (b.isSTATIC()) return;

        // v += 1 / mass * forces * dt
        b.velocity.add(b.forces.mult(b.massData.invMass * dt));

        integrateForces(b, dt);
    }

    /**
     * Integrates the Forces acting on a Body
     * @param b the body who's forces will be integrated
     * @param dt the time interval to integrate by
     * */
    public void integrateForces(Body b, float dt) {
        if (b.isSTATIC()) return;

        // x += v * dt
        b.location.add(b.velocity.mult(dt));
    }


    // Getters and Setters
    public Vector<Body> getBodies() {
        return bodies;
    }
}

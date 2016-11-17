package core;

import com.sun.javafx.geom.Vec2f;

/**
 * A 2-dimensional, single-precision, floating-point vector with operator methods
 * @author Jordan Scarrott
 * @see com.sun.javafx.geom.Vec2f
 */
public class Vector extends Vec2f {

    // Constructors
    public Vector() {
        super(0, 0);
    }

    public Vector(float vx, float vy) {
        super(vx, vy);
    }

    /**
     * Returns the sum of two <code>Vectors</code>
     */
    public static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Returns the difference of two <code>Vectors</code>
     */
    public static Vector sub(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * Returns a copy of the specified <code>core.Vector</code> as a new <code>core.Vector</code>
     *
     * @param v the <code>core.Vector</code> to be copied
     * @return a copy of the specified <code>core.Vector</code> as a new <code>core.Vector</code>
     */
    public static Vector copy(Vector v) {
        return new Vector(v.x, v.y);
    }

    /**
     * Returns the product of a specified <code>core.Vector</code> and a specified scalar number
     * as a <code>core.Vector</code>
     *
     * @param v the <code>core.Vector</code> to be multiplied
     * @param m the scalar to be multiplied with the components of the specified
     *          <code>core.Vector</code>
     * @return a new <code>core.Vector</code> that is the product of the specified
     * <code>core.Vector</code> and the specified scalar
     */
    public static Vector mult(Vector v, float m) {
        return new Vector(v.x *= m, v.y *= m);
    }

    /**
     * Sets the components, x and y, of this <code>core.Vector</code>
     */
    public void set(Vector v) {
        set(v.x, v.y);
    }

    /**
     * Returns a copy of this <code>core.Vector</code> as a <b>new</b> <code>core.Vector</code>
     *
     * @return a copy of this <code>core.Vector</code> as a <b>new</b> <code>core.Vector</code>
     */
    public Vector copy() {
        return copy(this);
    }

    /**
     * Adds the components of the specified <code>core.Vector</code> to
     * this <code>core.Vector</code> and them returns this <code>core.Vector</code>
     *
     * @param vx the X component to be added to this <code>core.Vector</code>
     * @param vy the Y component to be added to this <code>core.Vector</code>
     * @return this <code>core.Vector</code> after the addition
     */
    public Vector add(float vx, float vy) {
        this.x += vx;
        this.y += vy;
        return this;
    }

    /**
     * Adds the components of the specified <code>core.Vector</code> to
     * this <code>core.Vector</code> and them returns this <code>core.Vector</code>
     *
     * @param v the <code>core.Vector</code> to be added to this <code>core.Vector</code>
     * @return this <code>core.Vector</code> after the addition
     */
    public Vector add(Vector v) {
        return this.add(v.x, v.y);
    }

    /**
     * Subtracts the components of the specified <code>core.Vector</code> from
     * this <code>core.Vector</code> and them returns this <code>core.Vector</code>
     *
     * @param vx the X component to be subtracted from this <code>core.Vector</code>
     * @param vy the Y component to be subtracted from this <code>core.Vector</code>
     * @return this <code>core.Vector</code> after the subtraction
     */
    public Vector sub(float vx, float vy) {
        this.x -= vx;
        this.y -= vy;
        return this;
    }

    /**
     * Subtracts the components of the specified <code>core.Vector</code> from
     * this <code>core.Vector</code> and them returns this <code>core.Vector</code>
     *
     * @param v the <code>core.Vector</code> to be subtracted from this <code>core.Vector</code>
     * @return this <code>core.Vector</code> after the subtraction
     */
    public Vector sub(Vector v) {
        return this.sub(v.x, v.y);
    }

    /**
     * Multiplies this <code>core.Vector</code> by the specified scalar, m
     *
     * @param m the scalar number by which this <code>core.Vector</code>
     *          will be multiplied
     * @return this <code>core.Vector</code> after the mulitplication
     */
    public Vector mult(float m) {
        this.x *= m;
        this.y *= m;
        return this;
    }

    /**
     * Returns the quotient of the specified <code>core.Vector</code> and the
     * specified scalar number as a <b>new</b> <code>core.Vector</code>
     *
     * @param v the <code>core.Vector</code> to be divided
     * @param m the scalar by which the specified <code>Vectors</code> components
     *          will be divided
     * @return a new <code>core.Vector</code> that is the quotient of the specified
     * <code>core.Vector</code> and the specified scalar
     */
    public Vector div(Vector v, float m) {
        return new Vector(this.x / m, this.y / m);
    }

    /**
     * Divides this <code>core.Vector</code> by the specified scalar, m
     *
     * @param m the scalar number by which this <code>core.Vector</code>
     *          will be divided
     * @return this <code>core.Vector</code> after the division
     */
    public Vector div(float m) {
        this.x /= m;
        this.y /= m;
        return this;
    }

    /**
     * Computes magnitude (length) of the relative magnitude vector represented
     * by this instance.
     * @return magnitude of the vector
     */
    public float magnitude() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Computes the magnitude squared of the specified core.Vector
     * @return the square magnitude of the specified core.Vector
     * @throws NullPointerException if the specified {@code core.Vector} is null
     * */
    public static float magSq(Vector vector) {
        return vector.x * vector.x + vector.y * vector.y;
    }

    /**
     * Normalizes the relative magnitude vector represented by this instance.
     * Returns a vector with the same direction and magnitude equal to 1.
     * If this is a zero vector, a zero vector is returned.
     * @return the normalized {@code core.Vector}
     */
    public Vector normalize() {
        final float mag = magnitude();

        if (mag == 0.0) {
            return new Vector(0.0f, 0.0f);
        }

        return new Vector(this.x / mag, this.y / mag);
    }

    /**
     * Computes dot (scalar) product of the vector represented by this instance
     * and the specified vector.
     * @param x the X magnitude of the other vector
     * @param y the Y magnitude of the other vector
     * @return the dot product of the two vectors
     */
    public float dotProduct(float x, float y) {
        return this.x * x + this.y * y;
    }

    /**
     * Computes dot (scalar) product of the vector represented by this instance
     * and the specified vector.
     * @param vector the other vector
     * @return the dot product of the two vectors
     * @throws NullPointerException if the specified {@code vector} is null
     */
    public float dotProduct(Vector vector) {
        return dotProduct(vector.x, vector.y);
    }

    /**
     * Computes dot (scalar) product of two Vectors
     * @param v1 the first core.Vector
     * @param v2 the second core.Vector
     * @return the dot product of the two vectors
     * @throws NullPointerException if the specified {@code vector} is null
     */
    public static float dotProduct(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    /**
     * Computes the angle (in degrees) between two Vectors
     * @param v1 the first core.Vector
     * @param v2 the second core.Vector
     * @return the angle between the two vectors measured in degrees
     */
    public static float angle(Vector v1, Vector v2) {
        final float delta = (v1.x * v2.x + v1.y * v2.y) / (float)Math.sqrt(
                (v1.x * v1.x + v1.y * v1.y) * (v2.x * v2.x + v2.y * v2.y));

        if (delta > 1.0) {
            return 0.0f;
        }
        if (delta < -1.0) {
            return 180.0f;
        }

        return (float)Math.toDegrees(Math.acos(delta));
    }

    /**
     * Computes the angle (in degrees) between this core.Vector and
     * the specified core.Vector.
     * @param vx the X magnitude of the other vector
     * @param vy the Y magnitude of the other vector
     * @return the angle between the two vectors measured in degrees
     */
    public float angle(float vx, float vy) {
        return angle(this, new Vector(vx, vy));
    }

    /**
     * Computes the angle (in degrees) between this core.Vector and the
     * specified core.Vector
     * @param vector the other vector
     * @return the angle between the two vectors measured in degrees,
     *         {@code NaN} if any of the two vectors is a zero vector
     * @throws NullPointerException if the specified {@code vector} is null
     */
    public float angle(Vector vector) {
        return angle(this, vector);
    }

    /**
     * Returns a <code>String</code> that represents the value
     * of this <code>Vec2d</code>.
     *
     * @return a string representation of this <code>Vec2d</code>.
     */
    @Override
    public String toString() {
        return "core.Vector[" + x + ", " + y + "]";
    }
}

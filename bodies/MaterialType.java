package bodies;

/**
 * Created by Jordan on 2016-11-17.
 */
public enum MaterialType {

//    This is what we want to be able to say
//    Material m1 = MaterialType.ROCK;

    ROCK(0.6f, 0.1f),
    WOOD(0.3f, 0.2f),
    METAL(1.2f, 0.05f),
    BOUNCYBALL(0.3f, 0.8f),
    SUPERBALL(0.3f, 0.95f),
    PILLOW(0.1f, 0.2f),
    STATIC(0.0f, 0.4f);

    private float density;
    private float restitution;

    MaterialType(float density, float restitution) {
        this.density = density;
        this.restitution = restitution;
    }


    // Getters and Setters
    public float getDensity() {
        return density;
    }

    public float getRestitution() {
        return restitution;
    }
}

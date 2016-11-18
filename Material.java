package bodies;

/**
 * Created by Jordan on 2016-11-06.
 */
public class Material {

    public float density;
    public float restitution;
    public float staticFriction;
    public float dynamicFriction;

    // Constructor
    public Material(float density, float restitution/*, float staticFriction, float dynamicFriction*/) {
        this.density = density;
        this.restitution = restitution;
        /*this.staticFriction = staticFriction;
        this.dynamicFriction = dynamicFriction;*/
    }

    public Material(MaterialType materialType) {
        this(materialType.getDensity(), materialType.getRestitution());
    }
}

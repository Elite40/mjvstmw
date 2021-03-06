package nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.models.enemy;

/**
 * Created by tiesbaltissen on 20-04-17.
 */
public enum ScalingSize {
    Default(1.0f),
    Small(0.7f),
    Large(1.3f);

    private final float value;

    ScalingSize(final float newValue) { value = newValue; }
    public float getValue() { return value; }
}

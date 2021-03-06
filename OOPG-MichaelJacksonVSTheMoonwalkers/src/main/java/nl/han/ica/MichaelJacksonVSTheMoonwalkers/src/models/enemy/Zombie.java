package nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.models.enemy;

import com.sun.istack.internal.Nullable;
import nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.classes.GameSession;
import nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.classes.MichaelJacksonVSTheMoonwalkers;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PGraphics;

import java.util.List;

public class Zombie extends AnimatedSpriteObject implements IMovableZombie {

    private ScalingSize size;
    private int xPosition;
    private float velocity;
    private int damage;
    private int points;
    private Direction direction;
    private MichaelJacksonVSTheMoonwalkers game;

    public Zombie(Direction direction, int xPosition, float velocity, int damage, int points, Sprite sprite, MichaelJacksonVSTheMoonwalkers game) {
        super(sprite, 2);
        this.size = size;
        this.direction = direction;
        this.xPosition = xPosition;
        this.velocity = velocity;
        this.damage = damage;
        this.game = game;
        this.points = points;
        setCurrentFrameIndex((direction == Direction.Left) ? 0 : 1);
    }

    @Override
    public void move(Direction direction) {
        setX((direction == Direction.Left) ? getX() - (2 * getVelocity()) : getX() + (2 * getVelocity()));
    }

    public int getDamage() {
        return damage;
    }

    public float getVelocity() {
        return velocity;
    }

    public int getPoints() {
        return points;
    }

    public Direction getIncomingDirection() { return direction; }

    public static String zombieSprites(ZombieType type) {
        switch(type) {
            case ZombieLanky:
                return getLankySprite();
            case ZombieBird:
                return getBirdSprite();
            case ZombieBoss:
                return getBossSprite();
        }
        return getLankySprite();
    }

    private static String getLankySprite() {
        return "src/main/java/nl/han/ica/MichaelJacksonVSTheMoonwalkers/res/drawable/ZombieLanky/zombielanky_movement.png";
    }

    private static String getBirdSprite() {
        return "src/main/java/nl/han/ica/MichaelJacksonVSTheMoonwalkers/res/drawable/ZombieBird/zombiebird_movement.png";
    }

    private static String getBossSprite() {
        return "src/main/java/nl/han/ica/MichaelJacksonVSTheMoonwalkers/res/drawable/ZombieSuperior/zombiesuperior_movement.png";
    }

    @Override
    public void update() {
        switch (direction) {
            case Left:
                move(Direction.Left);
                break;
            case Right:
                move(Direction.Right);
                break;
        }
    }
}

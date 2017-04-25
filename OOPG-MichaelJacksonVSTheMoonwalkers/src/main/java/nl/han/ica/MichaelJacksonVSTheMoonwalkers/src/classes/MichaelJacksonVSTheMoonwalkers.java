package nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.classes;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import nl.han.ica.waterworld.tiles.BoardsTile;
import nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.helpers.ButtonCreator;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by tiesbaltissen on 21-04-17.
 */
public class MichaelJacksonVSTheMoonwalkers extends GameEngine {

    private final int worldWidth = 1000;
    private final int worldHeight = 518;

    private Dashboard dashboard;


    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.MichaelJacksonVSTheMoonwalkers.src.classes.MichaelJacksonVSTheMoonwalkers"});}
    @Override
    public void setupGame() {

        loadCustomFont();

        try {
            showMainMenu();

            createViewWithoutViewport(worldWidth, worldHeight);
            GameSession.sharedInstance().setupGameSession(this);

        } catch (Exception e) {
            println(e);
        }
    }

    private void loadCustomFont() {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/nl/han/ica/MichaelJacksonVSTheMoonwalkers/res/fonts/ARCADECLASSIC.TTF")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
            System.out.println("Error loading custom font...");
        }
    }

    @Override
    public void update() {

    }



    public int[] getScreenSize() {
        return new int[]{ worldWidth, worldHeight };
    }

    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/MichaelJacksonVSTheMoonwalkers/res/drawable/Backgrounds/sprite-bg.png"));

        setView(view);
        size(screenWidth, screenHeight);
    }

    private void createDashboard(int dashboardWidth,int dashboardHeight) {
//        Dashboard dashboard = new Dashboard(0,0, dashboardWidth, dashboardHeight);
//        TextObject dashboardText=new TextObject("");
//        dashboard.addGameObject(dashboardText);
//        addDashboard(dashboard);
    }

    private void showMainMenu(){
        this.dashboard = new Dashboard(0,0, this.worldWidth, this.worldHeight);
        TextObject mjText = new TextObject("Michael Jackson");
        mjText.setCustomFont("ArcadeClassic");
        mjText.setX((this.worldWidth/2) - 170);

        TextObject vsText = new TextObject("VS");
        vsText.setX((this.worldWidth/2));
        vsText.setY(50);

        TextObject theMW = new TextObject("the moonwalkers");
        theMW.setX((this.worldWidth/2) - 170);
        theMW.setY(100);

        this.dashboard.addGameObject(mjText);
        this.dashboard.addGameObject(vsText);
        this.dashboard.addGameObject(theMW);

        addDashboard(dashboard);

        placeButtons();
    }

    private void placeButtons() {
        ButtonCreator playButton = new ButtonCreator("Play", (this.worldWidth/2)-50, 170);
        playButton.setBackgroundColor(Color.pink);
        playButton.setButtonTextColor(Color.white);

        ButtonCreator highScoreButton = new ButtonCreator("Highscore", (this.worldWidth/2)-50, 250);
        highScoreButton.setBackgroundColor(Color.pink);
        highScoreButton.setButtonTextColor(Color.white);

        this.dashboard.addGameObject(playButton);
        this.dashboard.addGameObject(highScoreButton);
    }
}

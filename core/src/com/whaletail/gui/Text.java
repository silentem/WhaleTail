package com.whaletail.gui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author Whaletail
 * @email silentem1113@gmail.com
 */

public class Text extends Actor {

    private String text;
    private BitmapFont font;
    private GlyphLayout glyphLayout;
    private float x;
    private float y;
    private Stage stage;

    public Text(String text, BitmapFont font) {
        this.text = text;
        this.font = font;
        glyphLayout = new GlyphLayout(font, text);
    }

    public Text(String text, BitmapFont font, Stage stage) {
        this.text = text;
        this.stage = stage;
        this.font = font;
        glyphLayout = new GlyphLayout(font, text);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (stage != null) {
            font.draw(batch, text,
                    stage.getWidth() - getWidth() - 10,
                    stage.getCamera().position.y + stage.getHeight() / 2 - 10);

        } else {
            font.draw(batch, text, x, y);
        }
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public void setText(String text) {
        this.text = text;
        glyphLayout.setText(font, text);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getWidth() {
        return glyphLayout.width;
    }

    @Override
    public float getHeight() {
        return glyphLayout.height;
    }
}

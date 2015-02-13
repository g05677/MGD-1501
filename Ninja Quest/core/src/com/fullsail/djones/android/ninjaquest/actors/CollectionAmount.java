package com.fullsail.djones.android.ninjaquest.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.fullsail.djones.android.ninjaquest.enums.GameStates;
import com.fullsail.djones.android.ninjaquest.utils.Constants;
import com.fullsail.djones.android.ninjaquest.utils.GameManagement;

/**
 * Created by David on 2/12/15.
 */
public class CollectionAmount extends Actor {

    // For displaying score
    private BitmapFont itemFont;
    private Rectangle bounds;
    public int quantity;


    public CollectionAmount(Rectangle bounds){
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        quantity = 0;
        setupFont();
    }

    @Override
    public void act (float delta) {
        super.act(delta);

        if (GameManagement.getInstance().getCurrentState() != GameStates.RUNNING){
            return;
        }
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (getScore() == 0) {
            return;
        }

        itemFont.drawWrapped(batch, String.format("%d", getScore()), bounds.x, bounds.y,
                bounds.width, BitmapFont.HAlignment.CENTER);
    }

    public void setupFont() {
        // For score
        FreeTypeFontGenerator typeGenerator = new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParam.size = 40;
        itemFont = typeGenerator.generateFont(fontParam);
        itemFont.setColor(.21f, .22f, .21f, 1f);
        typeGenerator.dispose();
    }

    public int getScore() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

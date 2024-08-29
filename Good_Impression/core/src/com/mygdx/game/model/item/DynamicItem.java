package com.mygdx.game.model.item;

import com.badlogic.gdx.graphics.Texture;

public class DynamicItem extends Item {
    private boolean visible;
    private boolean cross;
    private final boolean isClothes;

    private int actionCount;
    private final int cleanTime = 12;
    public DynamicItem(String name, Texture image, Texture chosenImage, float x, float y, float width
            , float height, float overlap, boolean cross, boolean isClothes) {
        super(name, image, chosenImage, x, y, width, height, overlap);
        this.visible = true;
        this.cross = cross;
        this.isClothes = isClothes;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public int getCleanTime() {
        return cleanTime;
    }

    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isCross() {
        return cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
    }

    public boolean isClothes() {
        return isClothes;
    }
}

package com.mygdx.game.controller.item.activity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.model.item.StaticItem;
import com.mygdx.game.view.effect.MakeSound;

import java.util.ArrayList;

public class GetItem {
    public void takeItemStatic(Player player, ArrayList<DynamicItem> dynamicItems) {
        if (player.getContainer() == null || player.getItemHolding() != null
                || player.getContainer().getNumber()==0 || player.getContainer().getItems().isEmpty()) return;
        ArrayList<DynamicItem> dynamic = player.getContainer().getItems();
        DynamicItem dynamicItem = dynamic.get(dynamic.size() - 1);
        player.setItemHolding(dynamicItem);
        dynamicItem.setVisible(true);
        dynamicItem.setPosition(player.getX() + (player.getWidth() - dynamicItem.getWidth()) / 2
                , player.getY() + 0.6f * player.getHeight());
        dynamic.remove(dynamicItem);
        dynamicItems.add(dynamicItem);
        MakeSound.makeSound("sounds/soItemPickup.ogg", 0.8f);
    }

    public void pickItemFloor(ArrayList<DynamicItem> dynamicItems, Player player){
        for (DynamicItem item : dynamicItems){
            if (item.getDiscover() && player.getItemHolding() == null &&
                    !item.getName().equals("puddle") && item.getPlayerDiscover().equals(player)) {
                player.setItemHolding(item);
                MakeSound.makeSound("sounds/soItemPickup.ogg", 0.8f);
            }
        }
    }
}

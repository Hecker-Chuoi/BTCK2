package com.mygdx.game.controller.handleinput.firstplayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.controller.handleinput.Handle;
import com.mygdx.game.controller.item.activity.GetItem;
import com.mygdx.game.controller.item.activity.throwitem.ThrowItem;
import com.mygdx.game.controller.player.ManagerPlayer;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.model.item.StaticItem;

import java.util.ArrayList;

public class HandleEnter extends Handle {


    public HandleEnter(){
    }

    public void handle(Player player, ArrayList<DynamicItem> dynamicItems
            , ArrayList<StaticItem> staticItems) {;
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            managerPlayer.handleStatus(player, dynamicItems, staticItems);
        }
    }
}

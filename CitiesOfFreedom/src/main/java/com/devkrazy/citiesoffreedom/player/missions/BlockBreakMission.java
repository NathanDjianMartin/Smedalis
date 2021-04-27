/*
 * Copyright (c) 2021, Nathan DJIAN-MARTIN (DevKrazy).
 * This BlockBreakMission.java file is a part of the Smedalis project.
 * Smedalis cannot be copied and/or distributed without the express permission of Nathan DJIAN-MARTIN (DevKrazy)
 *
 */

package com.devkrazy.citiesoffreedom.player.missions;

import com.devkrazy.citiesoffreedom.player.missions.types.CountMission;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakMission extends CountMission {

    private Material blockType;

    public BlockBreakMission(String name, Player player, Material guiMaterial, int xpReward, int emeraldsReward, int goal, MissionScope missionScope, Material blockType) {
        super(name, player, guiMaterial, xpReward, emeraldsReward, goal, missionScope);
        this.blockType = blockType;
    }

    /**
     * Processed a given event and updates the mission status if necessary.
     * @param event the event to process
     */
    @Override
    public void processEvent(Event event) {
        if (event instanceof BlockBreakEvent) {
            if (((BlockBreakEvent) event).getBlock().getType() == this.blockType) {
                this.incrementCounterOf(1);
                if (this.isGoalReached() == true) {
                    this.completeAndReward();
                }
            }
        }
    }
}
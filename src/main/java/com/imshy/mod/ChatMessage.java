package com.imshy.mod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class ChatMessage {
    private final ComeBack comeback = new ComeBack();
    @SubscribeEvent
    public void chatMessage(ClientChatReceivedEvent e) {


        Message message = new Message(e.message.getUnformattedText());
        if(message.isDerogatory()
                && !message.getSender().equals(Minecraft.getMinecraft().thePlayer.getName())
                && BetterEz.getInstance().onhypixel()
        )
        {
            comeback.sendEasy();
            logMeanPlayer(message.getSender());
        }
    }

    private void logMeanPlayer(String player)
    {
        System.out.println("Player: " + player + " is mean");
    }
}

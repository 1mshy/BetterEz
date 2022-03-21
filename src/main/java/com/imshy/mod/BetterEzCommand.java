package com.imshy.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.Random;

public class BetterEzCommand extends CommandBase {
    private final String[] messages = ("Wait... This isn't what I typed!\n" +
            "Anyone else really like Rick Astley?\n" +
            "Hey helper, how play game?\n" +
            "Sometimes I sing soppy, love songs in the car.\n" +
            "I like long walks on the beach and playing Hypixel\n" +
            "Please go easy on me, this is my first game!\n" +
            "You're a great person! Do you want to play some Hypixel games with me?\n" +
            "In my free time I like to watch cat videos on Youtube\n" +
            "When I saw the witch with the potion, I knew there was trouble brewing.\n" +
            "If the Minecraft world is infinite, how is the sun spinning around it?\n" +
            "Hello everyone! I am an innocent player who loves everything Hypixel.\n" +
            "Plz give me doggo memes!\n" +
            "I heard you like Minecraft, so I built a computer in Minecraft in your Minecraft so you can Minecraft while you Minecraft\n" +
            "Why can't the Ender Dragon read a book? Because he always starts at the End.\n" +
            "Maybe we can have a rematch?\n" +
            "I sometimes try to say bad things then this happens :(\n" +
            "Behold, the great and powerful, my magnificent and almighty nemisis!\n" +
            "Doin a bamboozle fren.\n" +
            "Your clicks per second are godly. :eek:\n" +
            "What happens if I add chocolate milk to macaroni and cheese?\n" +
            "Can you paint with all the colors of the wind\n" +
            "Blue is greener than purple for sure\n" +
            "I had something to say, then I forgot it.\n" +
            "When nothing is right, go left.\n" +
            "I need help, teach me how to play!\n" +
            "Your personality shines brighter than the sun.\n" +
            "You are very good at the game friend.\n" +
            "I like pineapple on my pizza\n" +
            "I like pasta, do you prefer nachos?\n" +
            "I like Minecraft pvp but you are truly better than me!\n" +
            "I have really enjoyed playing with you! <3\n" +
            "ILY <3\n" +
            "Pineapple doesn't go on pizza!\n" +
            "Lets be friends instead of fighting okay?").split("\n");

    @Override
    public String getCommandName() {
        return "ez";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/ez";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        sendEasy();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }


    public void sendEasy() {
        Minecraft.getMinecraft().thePlayer.sendChatMessage(randomEasyMessage());
    }

    public void sendEasyThread() {
        BetterEz.getInstance().THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(easyCreator());
            }
        });
    }

    private String randomEasyMessage() {
        return messages[new Random().nextInt(messages.length)];
    }
    @Deprecated
    // hypixel will block the same message from being sent
    // so we need to send a different variation of the message each time
    private String easyCreator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < random.nextInt(20) + 1; i++) {
            sb.append("e");
        }
        for(int i = 0; i < random.nextInt(20) + 1; i++) {
            sb.append("z");
        }
        return sb.toString();
    }
}

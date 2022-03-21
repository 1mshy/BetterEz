package com.imshy.mod;

import net.minecraft.client.Minecraft;

import java.util.Random;

public class ComeBack {
    public void sendEasyThread() {
        BetterEz.getInstance().THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(easyCreator());
            }
        });
    }

    public void sendEasy() {
        sendEasyThread();
    }
    // hypixel will block the same message from being sent
    // so we need to send a different variation of the message each time
    private String easyCreator() {
       Random random = new Random();
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i < random.nextInt(10) + 1; i++) {
           sb.append("e");
       }
        for(int i = 0; i < random.nextInt(10) + 1; i++) {
            sb.append("z");
        }

        return sb.toString();
    }
}

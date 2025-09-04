package com.websocket.chat.model;

import java.awt.*;

public enum MessageType {
    CHAT,
    JOIN;
   // LEAVE;
    public static final TrayIcon.MessageType LEAVE = TrayIcon.MessageType.valueOf("LEAVE");
}
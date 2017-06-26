package com.tanktrouble.game.log;

import com.tanktrouble.game.reference.References;

import java.io.IOException;

/**
 * Created by GFXNever on 6/20/2017.
 */
public class ErrorReporting {

    public static void consoleError(Exception e) {
        System.err.println(References.TITLE + " Crash! The game has crashed. Call da doctors. Details:");
        e.printStackTrace();
    }
}

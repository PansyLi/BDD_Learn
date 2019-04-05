package config;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class SmartRobot extends Robot {
    public SmartRobot()throws AWTException{
        super();
    }
    public void pressChar(){
        keyPress(KeyEvent.VK_A);
    }
    public void paste(){
        keyPress(KeyEvent.VK_CONTROL);
        keyPress(KeyEvent.VK_V);
        delay(50);
        keyRelease(KeyEvent.VK_CONTROL);
        keyRelease(KeyEvent.VK_V);
    }
    public void Type(String text){
        writeToClipboard(text);
        paste();
    }
    private void writeToClipboard(String string) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(string);
    }
}

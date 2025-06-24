import java.awt.Graphics;
import java.awt.Point;
import javax.swing.ImageIcon;

public abstract class Sprite implements Drawable{
    protected Room currentRoom;
    protected ImageIcon image;

    public Sprite(){
        currentRoom = null;
        image = null;
    }

    /*setter */
    public void setCurrentRoom(Room r){
        currentRoom = r;
    }
    /*getter */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void moveSouth(){
        if (currentRoom.hasSouthExit()){
            currentRoom=currentRoom.getSouthExit();
        }
    }

    public void moveNorth(){
        if (currentRoom.hasNorthExit()){
            currentRoom=currentRoom.getNorthExit();
        }
    }

    public void moveEast(){
        if (currentRoom.hasEastExit()){
            currentRoom=currentRoom.getEastExit();
        }
    }

    public void moveWest(){
        if (currentRoom.hasWestExit()){
            currentRoom=currentRoom.getWestExit();
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Sprite){
            Sprite other  = (Sprite) o;
            if (this.getCurrentRoom() == other.getCurrentRoom()){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public void draw(Graphics g){
        if (currentRoom != null){
            Point position = currentRoom.getPosition();
            image.paintIcon(null, g, position.x+6, position.y+8);
        }
    }
}

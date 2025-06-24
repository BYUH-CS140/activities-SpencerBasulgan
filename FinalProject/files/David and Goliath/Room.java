import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Room implements Drawable{
    public static final int SIZE = 50;
    private Point pos;
    private Room exitEast;
    private Room exitWest;
    private Room exitNorth;
    private Room exitSouth;
    

    public Room(int x, int y){
        pos = new Point(x,y);
        exitEast = null;
        exitWest = null;
        exitNorth = null;
        exitSouth = null;
    }

    public void setEastExit(Room r) {
        this.exitEast = r;
        r.exitWest = this;
    }

    public void setNorthExit(Room r){
        this.exitNorth = r;
        r.exitSouth = this;
    }

    public void setWestExit(Room r){
        this.exitWest = r;
        r.exitEast = this;
    }

    public void setSouthExit(Room r){
        this.exitSouth = r;
        r.exitNorth = this;
    }

    public Point getPosition(){
        return pos;
    }

    //David movements
    public boolean hasNorthExit(){
        if (exitNorth == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean hasSouthExit(){
        if (exitSouth == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean hasEastExit(){
        if (exitEast == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean hasWestExit(){
        if (exitWest == null){
            return false;
        } else {
            return true;
        }
    }

    public Room getNorthExit(){
        return exitNorth;
    }

    public Room getSouthExit(){
        return exitSouth;
    }

    public Room getEastExit(){
        return exitEast;
    }

    public Room getWestExit(){
        return exitWest;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(pos.x,pos.y, SIZE, SIZE); //background 
        if (exitEast != null){
            g.setColor(Color.YELLOW);
            g.drawLine(pos.x+SIZE, pos.y+(SIZE/2-5), pos.x+SIZE, pos.y+(SIZE/2+5));
            g.setColor(Color.BLACK);
            g.drawLine(pos.x+SIZE, pos.y+(SIZE/2-5), pos.x+SIZE+10, pos.y+(SIZE/2-5));
            g.drawLine(pos.x+SIZE, pos.y+(SIZE/2+5), pos.x+SIZE+10, pos.y+(SIZE/2+5));
        }
        if (exitNorth != null){
            g.setColor(Color.YELLOW);
            g.drawLine(pos.x+(SIZE/2-5), pos.y+0, pos.x+(SIZE/2+5), pos.y+0);
            g.setColor(Color.BLACK);
            g.drawLine(pos.x+(SIZE/2-5), pos.y+0, pos.x+(SIZE/2-5), pos.y-10);
            g.drawLine(pos.x+(SIZE/2+5), pos.y+0, pos.x+(SIZE/2+5), pos.y-10);
        }
        if (exitWest != null){
            g.setColor(Color.YELLOW);
            g.drawLine(pos.x+0, pos.y+(SIZE/2-5), pos.x+0, pos.y+(SIZE/2+5));
        }
        if (exitSouth != null){
            g.setColor(Color.YELLOW);
            g.drawLine(pos.x+(SIZE/2-5), pos.y+SIZE, pos.x+(SIZE/2+5), pos.y+SIZE);
        }


    }    
}

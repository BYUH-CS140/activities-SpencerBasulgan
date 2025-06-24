import javax.swing.ImageIcon;

public class David extends Sprite{
    private int numStone;

    public David(){
        super();
        image = new ImageIcon("david.png");
        numStone = 0;
    }

    public void pickUpStone(){
        numStone++;
    } 

    public boolean isArmed(){
        if (numStone == 5){
            return true;
        } else {
            return false;
        }
    }

    public void reset(){
        numStone = 0;
    }

    
}

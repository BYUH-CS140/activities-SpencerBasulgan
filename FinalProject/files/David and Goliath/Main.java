import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class Main extends JPanel implements KeyListener{
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Stone> stones = new ArrayList<>();
    ArrayList<Drawable> drawing = new ArrayList<>();
    David david;
    Goliath goliath;
    public Main(){
        addKeyListener(this);
        /*Goliath Sprite */
        goliath = new Goliath();
        /*david Sprite */
        david = new David();
        /*stone Sprite and add to drawing arraylist*/
        for (int i =0; i<5; i++){
            stones.add(new Stone());
            drawing.add(stones.get(i));
        }
        /*instantiate rooms and add to drawing arraylist */
        int x = 5;
        int y = 0;
        for (int i = 0; i<4; i++){
            y+=(Room.SIZE+10);
            for (int m=0; m<4; m++){
                rooms.add(new Room(x,y));
                x+=(Room.SIZE+10);
            }
            x=5;
        }
        for (var r : rooms){
            drawing.add(r);
        }
        /*adding to drawing arraylist */
        drawing.add(goliath);
        drawing.add(david);
        /*hallways in the maze */
        rooms.get(0).setEastExit(rooms.get(1));
        rooms.get(1).setEastExit(rooms.get(2));
        rooms.get(2).setEastExit(rooms.get(3));
        rooms.get(4).setEastExit(rooms.get(5));
        rooms.get(6).setEastExit(rooms.get(7));
        rooms.get(5).setNorthExit(rooms.get(1));
        rooms.get(8).setNorthExit(rooms.get(4));
        rooms.get(8).setSouthExit(rooms.get(12));
        rooms.get(9).setSouthExit(rooms.get(13));
        rooms.get(10).setSouthExit(rooms.get(14));
        rooms.get(11).setSouthExit(rooms.get(15));
        rooms.get(9).setNorthExit(rooms.get(5));
        rooms.get(9).setEastExit(rooms.get(10));
        rooms.get(10).setNorthExit(rooms.get(6));
        rooms.get(11).setNorthExit(rooms.get(7));
        rooms.get(11).setSouthExit(rooms.get(15));
        rooms.get(12).setEastExit(rooms.get(13));
        rooms.get(13).setEastExit(rooms.get(14));
        /*position of sprites */
        david.setCurrentRoom(rooms.get(12));
        goliath.setCurrentRoom(rooms.get(3));
        stones.get(0).setCurrentRoom(rooms.get(0));
        stones.get(1).setCurrentRoom(rooms.get(4));
        stones.get(2).setCurrentRoom(rooms.get(9));
        stones.get(3).setCurrentRoom(rooms.get(14));
        stones.get(4).setCurrentRoom(rooms.get(15));
    }

    @Override
    public void paintComponent(Graphics g){
        if (!hasFocus()) {
        requestFocusInWindow();
        }
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, getWidth(), getHeight());
        /*draw sprites in the maze */
        for (var s : drawing){
            s.draw(g);
        }
        
    }

    private void reset(){
        david.setCurrentRoom(rooms.get(12));
        goliath.setCurrentRoom(rooms.get(3));
        stones.get(0).setCurrentRoom(rooms.get(0));
        stones.get(1).setCurrentRoom(rooms.get(4));
        stones.get(2).setCurrentRoom(rooms.get(9));
        stones.get(3).setCurrentRoom(rooms.get(14));
        stones.get(4).setCurrentRoom(rooms.get(15));
        david.reset();
    }

    public static void main (String[] args){
        var window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize ((Room.SIZE+10)*5+10,(Room.SIZE+10)*6);
        window.setContentPane(new Main());
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //Controls for David Arrow Keys
        if (keyCode == KeyEvent.VK_UP) {
            david.moveNorth();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            david.moveSouth();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            david.moveWest();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            david.moveEast();
        }
        //Controls for Goliath WASD keys
        else if(keyCode == KeyEvent.VK_W){
            goliath.moveNorth();
        } else if (keyCode == KeyEvent.VK_S) {
            goliath.moveSouth();
        } else if (keyCode == KeyEvent.VK_A) {
            goliath.moveWest();
        } else if (keyCode == KeyEvent.VK_D) {
            goliath.moveEast();
        }

        for (var s : stones){
            if (david.equals(s)){ 
                david.pickUpStone();
                s.setCurrentRoom(null);
            }
        }
        repaint();
        if (david.equals(goliath)){
            if(david.isArmed()==true){
                JOptionPane.showMessageDialog(null, "Congratulations David! You slew Goliath!");
            } else {
                JOptionPane.showMessageDialog(null, "Oh no David! Goliath got you! Try again.");
            }
            reset();
        }
        repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}  
}

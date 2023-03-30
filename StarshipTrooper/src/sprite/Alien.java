package sprite;

import javax.swing.ImageIcon;

//Define how an alien will look and move
public class Alien extends Sprite{
    private Bomb bomb;

    //move the alien 
    public Alien (int x, int y){
        initAlien(x,y);
    }

    //moves the alien and gives it an image
    private void initAlien(int x, int y){
        this.x=x;
        this.y=y;
        bomb=new Bomb(x,y);
        var alienImg="/StarshipTrooper/images/alien.png";
        var img=new ImageIcon(alienImg);

        setImage(img.getImage());
    }

    //sets x direction of where the alien moves
    public void act(int direction){
        this.x+=direction;
    }

    public Bomb getBomb(){
        return bomb;
    }
    
    //inner bomb class for aliens. where they move, what they do, and how they look
    public class Bomb extends Sprite{
        private boolean destroyed;

        //move the bomb
        public Bomb(int x,int y){
            initBomb(x,y);
        }
        
        //sets location for bomb
        private void initBomb(int x,int y){
            setDestroyed(true);

            this.x=x;
            this.y=y;

            var bombImg="src/images/bomb.png";
            var img=new ImageIcon(bombImg);
            setImage(img.getImage());
        }
        public void setDestroyed(boolean destroyed){
            this.destroyed=destroyed;
        }
        public boolean isDestroyed(){
            return destroyed;
        }
    }

}

package code.src.main.java.concurrency.threads.numberstore2;

public class NumberStore {
    private int x, y, z, w;
    public NumberStore(){
        this.x=0;
        this.y=0;
        this.z=0;
        this.w=0;
    }
    // public void increment(){
    //     x++;
    //     y++;
    //     z++;
    //     w++;
    // }

    //to stop any optimization by reodering

    public synchronized void increment(){
        x++;
        y++;
        z++;
        w++;
    }


    //synchronize all these function for solution
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }
    public int getW() {
        return w;
    }

    




    // public NumberStore(){
    //     this.x=0;
    // }
    // public synchronized void increment(){
    //     x++;
    // }


}

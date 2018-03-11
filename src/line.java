
public class line {
    point newPoint1 = new point();
    point newPoint2 = new point();
    public line(){

    }

    public void getLine(){
        int k, b;
        k = (newPoint1.getY() - newPoint2.getY())/(newPoint1.getX() - newPoint2.getX());
        b = newPoint1.getY() - k*(newPoint1.getX());
        System.out.print("y = " + k  + "x +" + b);
    }
}

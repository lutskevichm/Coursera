import edu.duke.*;

import java.awt.*;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int number = getNumPoints(s);
        double average = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points" + number);
        System.out.println("average length" + average);
        System.out.println("largest side" + largest);
        System.out.println("largest X" + largestX);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }

    public void getNumPoints(Shape s){
        int count = 0;
        for (Point currPt:s.getPoints()){
            count++;
        }
        return count;
    }
    public void getAverageLength(Shape s){
        double avg = getPerimeter(s)/(getNumPoints(s)/2);
        return avg;
    }
    public void getLargestSide(Shape s){
        double lar = 0;
        Point prev=s.getLastPoint();
        for (Point currPt:s.getPoints()){
            double curr=prev.distance(currPt);
            if(curr>lar)
                lar=curr;
            prev=currPt;
        }
        return lar;
    }

    public void getLargestX(Shape s){
        double larX = 0;
        for (Point currPt:s.getPoints()){
            double currX = currPt.getX();
            if (currX>larX)
                larX=currX;
        }
        return larX;
    }
}

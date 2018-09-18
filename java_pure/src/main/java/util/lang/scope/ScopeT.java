package util.lang.scope;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class ScopeT {

    /**
     * is point in area
     */
    public static boolean isInner(Point2D.Double point, List<Point2D.Double> points) {
        return isInner(point, points, true);
    }

    public static boolean isInner(Point2D.Double point, List<Point2D.Double> points, boolean isBoundInner) {

        int pointsNum = points.size();
        int intersectCount = 0;//cross points count of x
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point2D.Double p1, p2;//neighbour bound vertices
        Point2D.Double p = point; //当前点

        p1 = points.get(0);//left vertex
        for (int i = 1; i <= pointsNum; ++i) {//check all rays
            if (p.equals(p1)) {
                return isBoundInner;//p is an vertex
            }

            p2 = points.get(i % pointsNum);//right vertex
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }

            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {//ray is crossing over by the algorithm (common part of)
                if (p.y <= Math.max(p1.y, p2.y)) {//x is before of ray
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {//overlies on a horizontal ray
                        return isBoundInner;
                    }

                    if (p1.y == p2.y) {//ray is vertical
                        if (p1.y == p.y) {//overlies on a vertical ray
                            return isBoundInner;
                        } else {//before ray
                            ++intersectCount;
                        }
                    } else {//cross point on the left side
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y
                        if (Math.abs(p.y - xinters) < precision) {//overlies on a ray
                            return isBoundInner;
                        }

                        if (p.y < xinters) {//before ray
                            ++intersectCount;
                        }
                    }
                }
            } else {//special case when ray is crossing through the vertex
                if (p.x == p2.x && p.y <= p2.y) {//p crossing over p2
                    Point2D.Double p3 = points.get((i + 1) % pointsNum); //next vertex
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {//p.x lies between p1.x & p3.x
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }

        if (intersectCount % 2 == 0) {//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }
    }


    /**
     * is point in circle
     */
    public static boolean isInner(Point2D.Double point, Point2D.Double center, double radius) {
        return isInner(point, center, radius, true);
    }

    public static boolean isInner(Point2D.Double point, Point2D.Double center, double radius, boolean isBoundInner) {
        double distance = Math.sqrt((point.x - center.x) * (point.x - center.x) + (point.y - center.y) * (point.y - center.y));
        return isBoundInner ? distance <= radius : distance < radius;
    }





    public static void main(String[] args) {
        Point2D.Double point = new Point2D.Double(0, 0);

        List<Point2D.Double> pts = new ArrayList<Point2D.Double>();
        pts.add(new Point2D.Double(0, 0));
        pts.add(new Point2D.Double(0, 5));
        pts.add(new Point2D.Double(1, 7));
        pts.add(new Point2D.Double(2, 5));
        pts.add(new Point2D.Double(3, 2));
        pts.add(new Point2D.Double(1, 0));

        System.out.println(isInner(point, pts, false));

        Point2D.Double aPoint = new Point2D.Double(0, 0);
        Point2D.Double bPoint = new Point2D.Double(0, 2);

        System.out.println(isInner(aPoint, bPoint, 2, false));
    }
}

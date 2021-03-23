package ga.veee.day12.annotation;

import java.lang.reflect.Field;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface In {
    String value() default "helloworld";
}

public class GenericsDemo {
    public static void main(String[] args) throws Exception {
        PaintBrush<Paint> brush = PaintContainer.getPaintBrush();
        Paint paint = (Paint) brush.obj;
        System.out.println(brush.getObj());
        PaintBrush<Water> waterBrush = WaterContainer.getPaintBrush();
        Water water = (Water) waterBrush.getObj();
        System.out.println(waterBrush.getObj());
    }
}

class PaintContainer {
    public static PaintBrush<Paint> getPaintBrush() throws Exception {
        PaintBrush<Paint> pb = new PaintBrush<>();
        Paint obj = new RedPaint();
        Field field = pb.getClass().getDeclaredField("obj");
        field.setAccessible(true);
        In in = field.getAnnotation(In.class);
        if (in != null) {
            pb.setObj(obj);//dependency injection
        }
        return pb;
    }
}

class WaterContainer {
    public static PaintBrush<Water> getPaintBrush() throws Exception {
        PaintBrush<Water> pb = new PaintBrush<>();
        Water obj = new Water();
        Field field = pb.getClass().getDeclaredField("obj");
        field.setAccessible(true);
        In in = field.getAnnotation(In.class);
        if (in != null) {
            String s = in.value();
            System.out.println("The value..is:" + s);
            pb.setObj(obj);//dependency injection}
        }
        return pb;
    }
}

abstract class Paint {

}

class RedPaint extends Paint {

}

class BluePaint extends Paint {

}

class PaintBrush<T> {
    //Paint paint;
    //Object obj;//generic
    //real generics is
    @In//(value="helloworld")
            T obj;

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

class Water {
}
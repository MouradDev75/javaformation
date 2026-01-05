package fr.dawan.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat("Chat", 5);

        //Class annotation
        if(cat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("Very important class.....");
        }

        //Method annotation

        for(Method m : cat.getClass().getMethods()){
            if(m.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = m.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    m.invoke(cat);
                }
            }
        }

        //field annotation
        for(Field f : cat.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(ReadField.class)){
                f.setAccessible(true);
                Object obj = f.get(cat);
                System.out.println(obj.toString());
            }
        }

        List<Object> objects = new ArrayList<>();
        objects.add(new Dog());
        objects.add(new Dog());
        objects.add(new Cat());

        int i = 0;

        for(Object o : objects){
            if(o.getClass().isAnnotationPresent(Archivable.class)){
                i++;
            }
        }

        System.out.println("archivable = "+i);

    }
}

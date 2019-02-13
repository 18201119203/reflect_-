package com.example.day2_fanshe;
import com.example.day2_fanshe.entity.Preson;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {

        /**
         * 第一种方法,类的类类型
         */
        Class<Preson> presonClass = Preson.class;

        /**
         * 第二种
         */
        Preson preson = new Preson();
        Class<Preson> aClass = (Class<Preson>) preson.getClass();

        /**
         * 第三种
         */
         Class<Preson> aClass1 = (Class<Preson>) Class.forName("com.example.day2_fanshe.entity.Preson");


        /**
         * 实例一:通过class类型创建对象 调用公共方法
         */
            //通过class类型创建对象
            Preson preson1 = presonClass.newInstance();
            //执行共有方法
            preson1.fun0();

        /**
         * 实例二:通过反射构造器创建对象 调用公共方法
         */
            //获取共有构造器
            Constructor<Preson> constructor = presonClass.getConstructor(null);
            //通过反射构造器创建对象
            Preson preson2 = constructor.newInstance(null);
            //执行共有方法
            preson2.fun0();

        /**
         * 实例三: 调用公有方法
         */
            //获取方法: 第一个参数:方法名    第二个参数:参数类型(Class类型)
            Method fun1 = presonClass.getMethod("fun1", int.class);
            //执行方法: 第一个参数:类的对象  第二个参数:参数值传递
            fun1.invoke(presonClass.newInstance(),200);

        /**
         * 实例四:暴力破解调用 私有方法
         */
            //获取方法: 第一个参数:方法名    第二个参数:参数类型(Class类型)
            Method fun2 = presonClass.getDeclaredMethod("fun2", int.class);
            //暴力破解私有方法
            fun2.setAccessible(true);
            //执行方法: 第一个参数:类的对象  第二个参数:参数值传递
            fun2.invoke(presonClass.newInstance(),300);

        /**
         *实例五:调用共有构造器
         */
            //获取构造器
            Constructor<Preson> constructor2 = presonClass.getConstructor(int.class);
            //通过反射构造器创建对象
            constructor2.newInstance(400);

        /**
         * 实例六:暴力破解调用私有构造器
         */
            //获取私有有参构造器
            Constructor<Preson> constructor1 = aClass.getDeclaredConstructor(int.class, String.class);
            //暴力破解私有构造器
            constructor1.setAccessible(true);
            //通过反射构造器创建对象
            constructor1.newInstance(100,"张三");


        /**
         * 实例七:修改域对象
         */
            //获取域对象
            Field age = presonClass.getDeclaredField("age");
            //暴力破解
            age.setAccessible(true);
            //修改域对象
            age.set(preson,500);
            preson.getAge();


        /**
         * 实例九:遍历所有共有的域，成员变量
         */
            //获取所有共有域
            Field[] fields = presonClass.getFields();
            if (fields!=null&&fields.length>0){
                for (Field field : fields) {
                    System.out.println("fname==="+field.getName()+" ftype==="+field.getType());
                }
            }

        /**
         * 实例十:遍历所有的域，成员变量
         */
            //获取所有域
            Field[] declaredFields = presonClass.getDeclaredFields();
            if (declaredFields!=null&&declaredFields.length>0){
                for (Field declaredField : declaredFields) {
                    System.out.println("fname==="+declaredField.getName()+" ftype==="+declaredField.getType());
                }
            }
    }

}

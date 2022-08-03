import com.bean.User.User;
import com.bean.User.UserController;
import com.bean.User.UserController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 13:40
 * @Version 1.0
 */

public class App4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        /*User user1 = context.getBean("user1",User.class);
        System.out.println(user1);
        User user2 = context.getBean("user2",User.class);
        System.out.println(user2);*/

        UserController2 user = context.getBean("userController2",UserController2.class);
        user.sayHi();
    }

}

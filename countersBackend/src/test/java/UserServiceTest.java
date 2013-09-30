import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.aksndr.entity.Address;
import ru.aksndr.entity.User;
import ru.aksndr.service.AddressService;
import ru.aksndr.service.UserService;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 10:31
 */
public class UserServiceTest {
    private static ApplicationContext context;
    private static UserService userService;
    private static AddressService addressService;
    public static void main(String[] args) {

        initContext();

//        addUser("FirstName","LastName","MiddleName", "Password");

        String userName = getUserNameById(1);
        System.out.print(userName);
        Address address = getUserAdressById(1);
        if (address==null) {
            address = new Address();
        }
            address.setUserId(2);
            address.setCountry("Россия");
            address.setCity("Ростов");
            address.setStreet("Садовая");
            address.setHouse("51");
            address.setFlat("3");
            address.setIndex(344000);


        addressService.addAddress(address);
    }

    private static Address getUserAdressById(int i) {
        return addressService.getAddressByUserId(i);
    }

    private static String getUserNameById(int i) {
        User user = userService.getUserById(i);
        if (user!=null){
            return user.getFirstName();
        } else {
            return "no user with id "+i;
        }

    }

    private static void addUser(String firstName, String lastName, String middleName, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setPass(password);

        userService.addUser(user);
    }

    private static void initContext() {
        context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        userService = (UserService) context.getBean("userService");
        addressService = (AddressService) context.getBean("addressService");
    }
}

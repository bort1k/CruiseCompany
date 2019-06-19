import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Order;
import com.bortni.model.Ship;
import com.bortni.service.OrderService;
import org.junit.Test;

import java.util.List;

public class OrderTest {
    private DaoFactory daoFactory = new MySqlDaoFactory();
    private GenericDao genericDao = daoFactory.getDao(Order.class);
    OrderService orderService = new OrderService();

    @Test
    public void getAllOrders() throws ReadException {
        List orderList = genericDao.getAll();
        System.out.println(orderList);
        orderList = genericDao.getAll();
        System.out.println(orderList);
        orderList = genericDao.getAll();
        System.out.println(orderList);

        orderList = genericDao.getAll();
        System.out.println(orderList);

        orderList = genericDao.getAll();
        System.out.println(orderList);
    }
}

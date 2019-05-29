import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Ship;
import org.junit.Test;

import java.util.List;

public class ShipTest {

    @Test
    public void printAllShips() throws ReadException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        GenericDao genericDao = daoFactory.getDao(Ship.class);

        List ship = genericDao.getAll();
        System.out.println(ship);
        genericDao.close();
    }

}

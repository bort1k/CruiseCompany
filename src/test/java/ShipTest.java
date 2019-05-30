import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Ship;
import org.junit.Test;

import java.util.List;

public class ShipTest {
    private DaoFactory daoFactory = new MySqlDaoFactory();
    private GenericDao genericDao = daoFactory.getDao(Ship.class);

    @Test
    public void printAllShips() throws ReadException {
        List ship = genericDao.getAll();
        System.out.println(ship);

    }


    @Test
    public void printOneShipByKey() throws ReadException{
        Ship ship = (Ship)genericDao.getByPK(5);
        System.out.println(ship);
    }

}
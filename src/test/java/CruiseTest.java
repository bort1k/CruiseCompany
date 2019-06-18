import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlCruiseDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CruiseTest {
    private DaoFactory daoFactory = new MySqlDaoFactory();
    private GenericDao genericDao = daoFactory.getDao(Cruise.class);

    @Test
    public void printAllCruises() throws ReadException {
        List cruises = genericDao.getAll();
        System.out.println(cruises);
    }

    @Test
    public void printCruisesByShipId() throws ReadException, SQLException {
        List cruises = ((MySqlCruiseDao) genericDao).getCruisesByShipId(1);
        System.out.println(cruises);
    }

    @Test
    public void printCruisesWithShip() throws ReadException {
        List cuises = ((MySqlCruiseDao) genericDao).getCruisesWithShips();
        System.out.println(cuises);
    }

}

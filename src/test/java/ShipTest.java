import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;
import com.bortni.model.Ship;
import com.bortni.service.CruiseService;
import com.bortni.service.PersonalService;
import com.bortni.service.ShipService;
import org.junit.Test;

import java.util.List;

public class ShipTest {
    private DaoFactory daoFactory = new MySqlDaoFactory();
    private GenericDao genericDao = daoFactory.getDao(Ship.class);
    private ShipService shipService = new ShipService();
    private PersonalService personalService = new PersonalService();
    private CruiseService cruiseService = new CruiseService();

    @Test
    public void printAllShips() throws ReadException {
        List ship = genericDao.getAll();
        System.out.println(ship);

        ship = genericDao.getAll();
        System.out.println(ship);
    }


    @Test
    public void printOneShipByKey() throws ReadException{
        int id = 1;
        Ship ship = shipService.getById(id);
        Personal personal = personalService.getPersonalByShipId(id);
        List cruises = cruiseService.getCruisesByShipId(id);
        ship.setPersonal(personal);
        ship.setCruises(cruises);
        System.out.println(ship);
    }

}

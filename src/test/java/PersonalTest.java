import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;
import org.junit.Test;

import java.util.List;

public class PersonalTest {
    private DaoFactory daoFactory = new MySqlDaoFactory();
    private GenericDao genericDao = daoFactory.getDao(Personal.class);

    @Test
    public void printAllShips() throws ReadException {
        List personal = genericDao.getAll();
        System.out.println(personal);
    }


    @Test
    public void printOneShipByKey() throws ReadException{
        Personal personal = (Personal) genericDao.getByPK(5);
        System.out.println(personal);
    }
}

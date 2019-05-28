import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlPersonalDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonalTest {

    @Test
    public void printAllPersonals() throws SQLException, ReadException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        GenericDao genericDao = daoFactory.getDao(Personal.class);

        List personals = genericDao.getAll();

        System.out.println(personals);

    }
}

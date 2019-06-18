import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlPortDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Port;
import com.bortni.service.PortService;
import org.junit.Test;

import java.util.List;

public class PortTest {
    private PortService portService = new PortService();
    @Test
    public void printPortsByCruiseId() {
        int id = 1;
        List ports = portService.getPortsByCruiseId(id);
        System.out.println(ports);
    }
}

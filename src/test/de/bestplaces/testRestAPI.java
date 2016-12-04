package de.bestplaces;

import de.bestplaces.model.User;
import org.junit.Test;

/**
 * Created by franz on 02.12.2016.
 */
public class testRestAPI {

    @Test
    public void createUserTest(){
        User testUser = new User("iskaNeumann", "Franziska", "Neumann", "shaundasschaf.neumann@gmx.de", "1234", "Karlsruhe");
    }
}

package test.com.bari.gestionecorsi.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.businesscomponent.idgenerator.CorsoIdGenerator;


class CorsoIdGeneratorTest {

	@Test
	void test() {
		try {
			CorsoIdGenerator idGen = CorsoIdGenerator.getInstance();
			assertNotNull(idGen);
			long id = idGen.getNextId();
			assertEquals(id, idGen.getNextId() -1);
		}catch(ClassNotFoundException|IOException|DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

}

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.util.FileManager;

public class FileManagerTest extends MyAbstractTest{

	@Autowired
	private FileManager fileManager;
	
	@Test
	public void saveFileTest() throws Exception{
		fileManager.saveFile("resources/upload/test");
		System.out.println();
	}
	
	

}

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("rumenul.rimon@testpro.io");
        providePassword("27041575");
        clickSubmit();
        deleteAPlaylist();
    }
}

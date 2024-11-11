import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renameAPlayList() throws InterruptedException {
        provideEmail("rumenul.rimon@testpro.io");
        providePassword("27041575");
        clickSubmit();
        renamePlayList();
    }
}

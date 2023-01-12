package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifTest(){

        //qualitydemi anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.cookieButton.click();
        ReusableMethods.bekle(3);

        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());
    }
}

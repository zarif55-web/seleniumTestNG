package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("nutella testi", "kullanici amazonda nutella arayabilmeli");

        // amazona gidelim
        extentTest.info("amazon anasayfaya gidildi");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella aratalim
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        extentTest.info("nutella yazilip arama yapildi");

        //sonuclarin nutella icerdigini test edin
        String actualSonucYazisi= amazonPage.aramaSonucuElementi.getText();
        String expected="nutella";
        extentTest.info("arama sonuclari kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expected));
        extentTest.pass("arama sonuclarinin nutella icerdigi test edildi");


    }
}

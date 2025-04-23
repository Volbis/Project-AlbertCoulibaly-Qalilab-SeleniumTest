package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HrmOrangeTest {
    WebDriver driver;

    // Methodes avants de commencer les tests
    @BeforeMethod
    public void setUp(){
        //Definir le chemin du webDriver
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Debut des tests
    @Test
    public void loginTest(){
        // Utilisation des waitters car de base les elements ne charge pas vite

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Après 15s locate and vérifier que le bouton est clickable puis click
        WebElement usernameForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")) ) ;
        usernameForm.sendKeys("Admin");

        WebElement passwordForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")) ) ;
        passwordForm.sendKeys("admin123");

        // Cliquer sur le bouton connexion
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action")) ) ;
        loginBtn.click();

        // S'assurer que la page d'accueil est bien chargée
        String title = driver.getTitle();
        assert title.contains("OrangeHRM");
    }

    @Test
    public void ajoutEmployeTest (){

        // ON SE CONNECTE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Après 15s locate and vérifier que le bouton est clickable puis click
        WebElement usernameForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")) ) ;
        usernameForm.sendKeys("Admin");

        WebElement passwordForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")) ) ;
        passwordForm.sendKeys("admin123");

        // Cliquer sur le bouton connexion
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action")) ) ;
        loginBtn.click();

        // S'assurer que la page d'accueil est bien chargée
        String title = driver.getTitle();
        assert title.contains("OrangeHRM");

        // ON ACCEDE A LA PARTIE PIM
        WebElement pimSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
        pimSection.click();

        // Attente de la disponibilité du bouton "Ajouter"
        wait.until(driverWeb -> driverWeb.findElement(By.xpath("//button[normalize-space()='Add']")).isEnabled());

        // Cliquer sur le bouton "Ajouter"
        WebElement boutonAjouter = wait.until(driverWeb -> driverWeb.findElement(By.xpath("//button[normalize-space()='Add']")));
        boutonAjouter.click();

        // Remplir les champs du formulaire employé
        WebElement champFirstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")));
        champFirstName.clear();
        champFirstName.sendKeys("Albert-Code :)");

        WebElement champMiddleName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")));
        champMiddleName.clear();
        champMiddleName.sendKeys("Coulibaly");

        WebElement champLastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")));
        champLastName.clear();
        champLastName.sendKeys("Volbis");

        // Soumettre le formulaire
        WebElement saveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")));
        saveBtn.click();

        // Attendre que la page de détails de l'employé soit chargée
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[contains(@class, 'orangehrm-main-title')]")));

        // Aller à la liste des employés pour vérifier l'ajout
        WebElement employeeListBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")));
        employeeListBtn.click();

        // Attendre que la liste des employés soit chargée
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait2.until(d -> d.findElement(By.xpath("//div[@role='table']")).isDisplayed());

        // Rechercher l'employé dans la liste
        WebElement fullName = wait2.until(d -> d.findElement(
                By.xpath("//div[@role='table']//div[contains(., 'Albert-Code :)')]")));

        Assert.assertTrue(fullName.isDisplayed(), "Nobody is here.");
        Assert.assertTrue(fullName.getText().contains("Albert-Code :) Coulibaly"),
                "Oupss");
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
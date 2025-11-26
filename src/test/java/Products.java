import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class Products extends Base {

    ProductsPage productsPage;

    @Test(priority = 1, description = "Verify Products are clickable")
    public void verifyProductsClickable() {
        productsPage = new ProductsPage(driver, wait);
        productsPage.clickMacBook();
        productsPage.clickIPhone();
        productsPage.clickAppleCinema();
        productsPage.ClickCanonEOS5D();

        Assert.assertTrue(productsPage.isAddToCartVisible(), "Add To Cart button is not visible!");
        Assert.assertTrue(productsPage.isAddToWishlistVisible(), "Add To Wishlist button is not visible!");
        Assert.assertTrue(productsPage.isSelectOptionisVisible(), "Select Option is not visible!");

        productsPage.fillProductOptions();
    }

    @Test(priority = 2, description = "Verify MacBook image is visible")
    public void verifyMacBookImageVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isMacBookImageVisible(), "MacBook image is not visible!");
    }

    @Test(priority = 3, description = "Verify MacBook price is visible")
    public void verifyMacBookPriceVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isMacBooktPriceVisible(), "MacBook price is not visible!");
    }

    @Test(priority = 4, description = "Verify iPhone Image is visible")
    public void verifyIphoneImageVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isiphoneImageVisible(), "iPhone Image is not visible");
    }

    @Test(priority = 5, description = "Verify iPhone Price is visible")
    public void verifyIphonePriceVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isiphonePriseVisible(), "iPhone price is not visible");
    }

    @Test(priority = 6, description = "Verify Apple Cinema 30 Image is visible")
    public void verifyAppleCinema30Image() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isAppleCinema30ImageVisible(), "Apple Cinema 30 Image is not visible");
    }

    @Test(priority = 7, description = "Verify Apple Cinema 30 Price is visible")
    public void verifyAppleCinema30Price() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isAppleCinema30PriceVisible(), "Apple Cinema 30 Price is not visible");
    }

    @Test(priority = 8, description = "Verify Canon EOS 5D Image is Visible")
    public void verifyCanonEOS5DImageVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isCanonEOS5DImageVisible(), "Canon EOS 5D Image is not visible");
    }

    @Test(priority = 9, description = "Verify Canon EOS 5D Price is Visible")
    public void verifyCanonEOS5DPriceVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isCanonEOS5DPriceVisible(), "Canon EOS 5D Price is not visible");
    }

    @Test(priority = 10, description = "Verify Add To Wishlist button is visible")
    public void verifyAddToWishlistVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isAddToWishlistVisible(), "Add To Wishlist button is not visible!");
    }

    @Test(priority = 11, description = "Verify Add To Cart button is visible")
    public void verifyAddToCartVisible() {
        productsPage = new ProductsPage(driver, wait);
        Assert.assertTrue(productsPage.isAddToCartVisible(), "Add To Cart button is not visible!");
    }

    @Test(priority = 12, description = "Verify file upload works")
    public void verifyFileUpload() {
        productsPage = new ProductsPage(driver, wait);
        String filePath = "";
        productsPage.uploadFile(filePath);
    }
}
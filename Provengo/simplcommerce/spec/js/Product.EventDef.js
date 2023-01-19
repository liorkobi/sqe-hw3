/* @Provengo summon selenium */



/**
 * the GoToProduct defines the selenium action for clicking on specific product from the home page
 */
defineEvent(SeleniumSession, "GoToProduct", function(session) {
    session.click("/html/body/div[4]/div[2]/div[2]/div/a");
})

/**
 * the GoToNewProduct defines the selenium action for returning to home page from the current window
 * clicking on different product from home page
 */
defineEvent(SeleniumSession, "GoToNewProduct", function(session,event) {
    session.click("/html/body/div[2]/div/div/div[1]/a/img");
    session.click("/html/body/div[4]/div[2]/div[2]/div/a/img");
})

/**
 * the AddNewtoCompareList defines the selenium action for clicking on the Add-To-Compare button and then on the Compare button
 * in the compare list click on remove
 */
defineEvent(SeleniumSession, "AddNewtoCompareList", function(session) {
    session.click("/html/body/div[4]/div[1]/div[1]/div[2]/div[4]/form/div[2]/ul/li[2]/a");
    session.waitForVisibility("//*[@id=\"shopModal\"]/div/div",20000);
    session.click("//*[@id=\"shopModal\"]/div/div/div[3]/a");
    session.waitForVisibility("/html/body/div[4]/h1",20000);
    session.click("/html/body/div[4]/table/tbody/tr[1]/td[2]/a");

})

/**
 * the AddProductToCompare defines the selenium action for clicking on the Add-To-Compare button and then on the Compare button
 */
defineEvent(SeleniumSession, "AddProductToCompare", function(session) {
  session.click("/html/body/div[4]/div[1]/div[1]/div[2]/div[4]/form/div[2]/ul/li[2]/a");
  session.waitForVisibility("//*[@id=\"shopModal\"]/div/div",20000);
  session.click("//*[@id=\"shopModal\"]/div/div/div[3]/a");
})

/**
 * the Login defines the selenium action for entering the information of the user who wants to log in to the store
 */
defineEvent(SeleniumSession, "Login", function (session, event) {
    with (session) {
        click("//*[@id=\"cookieConsent\"]/div/div/div/button");
        click("/html/body/div[1]/div/ul/li[1]/a");
        writeText('//*[@id="Email"]', event.email);
        writeText('//*[@id="Password"]', event.password);
        click("/html/body/div[4]/div/div[1]/section/form/div[5]/div/button");
        if (event.expectedWelcome)
            waitForVisibility("//span[text()='" + event.expectedWelcome + "']", 20000)
    }
});

/**
 * the GoToDashboard defines the selenium action for clicking on the dashboard button in order to open the admin menu
 */
defineEvent(SeleniumSession, "GoToDashboard", function(session) {
    session.click("/html/body/div[1]/div/ul/li[2]/a\n");
})

/**
 * the GoToCatalog defines the selenium action for clicking on the catalog menu
 */
defineEvent(SeleniumSession, "GoToCatalog", function(session) {
    session.click("/html/body/div[1]/div/div[2]/ul/li[2]/a");
})

/**
 * the Product1 defines the selenium action for clicking on the product button 
 * in order to navigate to the page contains all products of the store
 */
defineEvent(SeleniumSession, "Product1", function(session) {
    session.click("/html/body/div[1]/div/div[2]/ul/li[2]/ul/li[1]/a\n");
})


/**
 * the DeleteProduct defines the selenium action for clicking on 'X' button in order to delete a product
 * and the selenium action for confirm the pop-up message
 */
defineEvent(SeleniumSession, "DeleteProduct", function(session) {
    session.waitForVisibility("/html/body/div[2]/div/table/tbody[1]/tr[19]/td[10]",20000);
    session.click("/html/body/div[2]/div/table/tbody[1]/tr[19]/td[10]/button[2]");
})



/**
 * the assertInCompare defines the selenium action for compare between the text shown in the page and the String <productName>
 * this case the product need to be in the compare list
 */
defineEvent(SeleniumSession, "assertInCompare", function(session) {
    session.waitForVisibility("/html/body/div[4]/h1");
    session.assertText("/html/body/div[4]/table/tbody/tr[3]/td[2]/strong","Esprit Ruffle Shirt");
})


/**
 * the assertNotInCompare defines the selenium action for compare between the text shown in the page and the String <productName>
 * this case the compare list need to be empty
 */
defineEvent(SeleniumSession, "assertNotInCompare", function(session) {
    session.waitForVisibility("/html/body/div[4]/h1");
    session.assertText("/html/body/div[4]/p","There is no product to compare");
})

/**
 * the assertNotExist defines the selenium action for compare between the text shown in the page and the String <productName>
 * this case the compare list need to be empty
 */
defineEvent(SeleniumSession, "assertNotExist", function(session) {
    session.click("//*[@id=\"cookieConsent\"]/div/div/div/button");
    session.writeText("//*[@id=\"Query\"]", "Esprit Ruffle Shirt")
    session.click("/html/body/div[2]/div/div/div[2]/form/button/i")
    session.assertText("//small[@class='badge-results']","0 Results")
})
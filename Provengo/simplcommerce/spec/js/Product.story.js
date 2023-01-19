/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to google.com, and searches for a pizza.
 */

story('add a product to the compare list', function () {
  let s2 = new SeleniumSession().start('http://localhost:5000/')
  s2.login({email:"liorkob@post.bgu.ac.il",password:"123456789"})
    s2.goToProduct()
    s2.addProductToCompare();
})


/**
 * This story opens a new browser window, goes to out local simplecommere site, log in with an Admin acount
 * delete from the store the same product the user added in the prev story.
 */
story('admin delete a product', function () {
 let s1 = new SeleniumSession().start('http://localhost:5000/');
  s1.login({email:"admin@simplcommerce.com",password:"1qazZAQ!"})
  s1.goToDashboard();
  s1.goToCatalog();
  s1.product1();
  s1.deleteProduct();
    })


/**
 * This story opens a new browser window, goes to out local simplecommere site, log in with regular user
 * and test the case where a user add to its compare list a product before the admin delete it from the store .
 * check that before the delation the product is in ths users compare list (assertInCompare)
 * check that the product doesn't exist in the compare list (assertNotInCompare)
 */
story('user add product to compare before admin delete a product', function () {
    with(new SeleniumSession().start('http://localhost:5000/')){
        login({email:"liorkob@post.bgu.ac.il",password:"123456789"})
        on(Any('EndOfAction').and(Any({eventName:"AddProductToCompare"})),function (){
        interrupt(Any('EndOfAction').and(Any({eventName: "DeleteProduct"})),function (){
                goToProduct();
                addProductToCompare();
                assertInCompare();
        })
            on(Any('EndOfAction').and(Any({eventName:"DeleteProduct"})),function (){
                goToNewProduct({});
                addNewtoCompareList();
                assertNotInCompare();
}) })}})


/**
 * This story opens a new browser window, goes to out local simplecommere site, log in with regular user
 * and test the case where a user add to its compare list a product after the admin delete it from the store .
 * in thi case
 */
story('user add product to compare after admin delete a product', function () {
    on(Any('EndOfAction').and(Any({eventName: "DeleteProduct"})), function () {
        interrupt(Any('StartOfAction').and(Any({eventName: "AddProductToCompare"})), function () {
            with (new SeleniumSession().start('http://localhost:5000/')) {
                assertNotExist();
            }

        })
    })
})


// story('deleteall2', function () {
//     with(new SeleniumSession().start('http://localhost:5000/')){
//         on(Any('StartOfAction').and(Any({eventName:"AddProductToCompare"})),function (){
//             interrupt(Any('StartOfAction').and(Any({eventName: "DeleteProduct"})), function () {
//                 initSession()
//         })
//         })
//     }})
// story('deleteall1', function () {
//     with(new SeleniumSession().start('http://localhost:5000/')){
//         on(Any('StartOfAction').and(Any({eventName:"DeleteProduct"})),function (){
//             interrupt(Any('StartOfAction').and(Any({eventName: "AddProductToCompare"})), function () {
//                 initSession()
//         })
//         })
//     }})

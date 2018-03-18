

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

package finalprojectB;

import junit.framework.TestCase;
import java.util.*;




public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        //random manual testing
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("http://www.google.com/"));
        assertTrue(urlVal.isValid("ftp://www.google.com:80/test1?=action=view"));
        assertTrue(urlVal.isValid("ftp://255.255.255.255:80"));
        assertFalse(urlVal.isValid("://www.google.com"));
        assertFalse(urlVal.isValid("ftp://www.google.com:80/test1//file?=action=view"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
    
    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    //all good URL parts
    assertTrue(urlVal.isValid("http://www.google.com:80/test1/test1?action=view"));
    assertTrue(urlVal.isValid("ftp://go.com:0/t123/t123?action=edit&mode=up"));
    //all bad URL parts
    assertFalse(urlVal.isValid("3ht://256.256.256.256:65a/../.."));
    assertFalse(urlVal.isValid("://aaa.:-1/..//file/../"));
    
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    //one bad for each part of the url
    assertFalse(urlVal.isValid("3ht://google.com"));
    assertFalse(urlVal.isValid("http://aaa"));
    assertFalse(urlVal.isValid("http://google.com:-1"));
    assertFalse(urlVal.isValid("http://google.com:80/.."));
    assertFalse(urlVal.isValid("http://google.com:80/test1//#/file")); //odd
    //one missing for each part of the url
    assertFalse(urlVal.isValid("http://:80"));
    assertTrue(urlVal.isValid("http://google.com/test1"));
    assertTrue(urlVal.isValid("http://google.com:80/test1/test1"));
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
    
    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

    //find the length of the arrays of the parts to randomize later
    int testUrlSchemeLength = testUrlScheme.length;
    int testUrlAuthorityLength = testUrlAuthority.length;
    int testUrlPortLength = testUrlPort.length;
    int testUrlPathLength = testPath.length;
    int testUrlPathOptionsLength = testUrlPathOptions.length;
    int testUrlQueryLength = testUrlQuery.length;

    int testUrlSchemeNum;
    int testUrlAuthorityNum;
    int testUrlPortNum;
    int testUrlPathNum;
    int testUrlPathOptionsNum;
    int testUrlQueryNum;
    
    //declare all of the strings for the URLs
    String testUrlSchemeString;
    String testUrlAuthorityString;
    String testUrlPortString;
    String testUrlPathString;
    String testUrlPathOptionsString;
    String testUrlQueryString;

    //URL to append all items, isValid to see if the randomized result is valid
    String url;

    // randomizer
    Random rand = new Random();
    int i = 0;
    Boolean isValid;
    
    // used 17010 because it's half of all of the array combinations possible
    while (i < 17010) {
        testUrlSchemeNum = rand.nextInt(testUrlSchemeLength);
        testUrlAuthorityNum = rand.nextInt(testUrlAuthorityLength);
        testUrlPortNum = rand.nextInt(testUrlPortLength);
        testUrlPathNum = rand.nextInt(testUrlPathLength);
        testUrlPathOptionsNum = rand.nextInt(testUrlPathOptionsLength);
        testUrlQueryNum = rand.nextInt(testUrlQueryLength);

        isValid = true;
        //place random item in each url part's array into a string
        testUrlSchemeString = testUrlScheme[testUrlSchemeNum].item;
        testUrlAuthorityString = testUrlAuthority[testUrlAuthorityNum].item;
        testUrlPortString = testUrlPort[testUrlPortNum].item;
        testUrlPathString = testPath[testUrlPathNum].item;
        testUrlPathOptionsString = testUrlPathOptions[testUrlPathOptionsNum].item;
        testUrlQueryString = testUrlQuery[testUrlQueryNum].item;

        // append the strings to build a URL
        url = testUrlSchemeString
                +testUrlAuthorityString
                +testUrlPortString
                +testUrlPathString
                +testUrlPathOptionsString
                +testUrlQueryString;

        //check to see if the URL result is valid or not
        if (testUrlScheme[testUrlSchemeNum].valid == false||
            testUrlAuthority[testUrlAuthorityNum].valid == false||
            testUrlPort[testUrlPortNum].valid == false ||
            testPath[testUrlPathNum].valid == false||
            testUrlPathOptions[testUrlPathOptionsNum].valid == false||
            testUrlQuery[testUrlQueryNum].valid == false) {
                isValid = false;
                }
            
        //check to see if assumption is correct
        if (urlVal.isValid(url) == isValid) {
            assertTrue(true);
        } else {
            assertFalse(false);
        }
        //print to console
        System.out.println(url + " is " + isValid);
        //next URL
        i++;
    }
   }
   

   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */

    ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                             new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
                                    new ResultPair("/t123", true),
                                    new ResultPair("/$23", true),
                                    new ResultPair("/..", false),
                                    new ResultPair("/../", false),
                                    new ResultPair("/test1/", true),
                                    new ResultPair("/#", false),
                                    new ResultPair("", true),
                                    new ResultPair("/test1/file", true),
                                    new ResultPair("/t123/file", true),
                                    new ResultPair("/$23/file", true),
                                    new ResultPair("/../file", false),
                                    new ResultPair("/..//file", false),
                                    new ResultPair("/test1//file", true),
                                    new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };

}

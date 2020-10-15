# NDTV_Weather_API_Test
This project captures the Temp from UI and API, compares the same using the variance 


# Pre Requisite
  Java is installed and configured on the system 
  
    confirm by typing 
  ```
  java –version
  ```
  on CMD prompt  
  Maven is installed and configured on the system
    
    confirm by typing 
  ```
  mvn –version 
  ```
  on CMD prompt

  RestAssured is used to send API requests 
  Selenium with Java is used to perform operations on UI

# Steps to run the project
  Unzip the folder to any location
  
  Open CMD prompt, CD to the folder extracted above
  
    Run the following command 
  ```
  mvn clean test -DsuiteXMLFile=testng.xml  
  ```

  __The variance for temperature difference set is as 10 
  The results with failures (Differences is greater than variance (10) 
  Difference between the temp_UI (captured on UI) and (temp_API captured using API)__


# Description of files
   MyLogger: Log all the activities
   Evidences Captured

   Screenshots – Evidences captured for all cities

   JSON_Resp – JSON response captured for each city

   APIUtils: All methods to fetch Response, Status Code, Status Line, Response Header, etc

   Utilities:
     Common utilities to tskeScreenShot, Select Value from list, Select value from Drop Down, Actions like Move to, Mouse Hover etc
     Constants: maintain the values for URL, ApiKey, paths etc
  
  Utils to convert temperature


# Tests Added
     Capture all Cities
        Uncheck all cities on Pin your City List
      UI (tempUI) Temperature 
        Find the city on Pin your City
        Check the city
        Store  the temperature in Degree C and F – Capture the screenshot
  
    API (tempAPI) Temperature
      Get the JSON response for City above – Store the JSON Response 
      Get the temp in K from the JSON response	
      Convert temperature from Degree K to C
  
    Find the difference (should not exceed the variance – set to 10)
      Compare tempUI and tempAPI, if the difference exceeds 10 – mark the test as Fail and attach the screen shot captured



# ToDo
    Capture the results in Excel sheet
    Convert the test in BDD 
    Add a utility to email the report
    Run the test on different browsers
    Supply the data from excel sheet if required
    Email the report with evidences
    Integrate with ANT and CI

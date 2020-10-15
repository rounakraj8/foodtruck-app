# foodtruck-app

This app can be used to get list of all food trucks that are open in San Francisco at the current time.

### Idea

The first thing is to fetch data from the given public API. Since this is a simple command-line application, I have used simple HttpURLConnection instead of clients like Rest Template or Feign client. We have to find food-trucks based on the current date, so one thing that will help us to receive significantly fewer data from the API is using the `dayorder` request-param. Then we need to filter based on the current date and each food truck's time range. Now we have to sort the list alphabetically by name. To display the output I have used String.format and Sysout. Some of the methods which can be used for extending the application are kept in util packages.

Since we are using JSON data from API, we need to use libraries to unmarshal the raw JSON data into Java objects, I have used Jackson for this purpose. Jackson is added in pom dependency so that we don't have to explicitly install this. For building the artifact I have used Maven. Also, there is a "start.sh" script which will help to build and run the application.

### Data Source

   San Francisco government’s website has a public data    
   Data API URL - https://data.sfgov.org/Economy-and-Community/Mobile-Food-Schedule/jjew-r69b

### Prerequisites

The following should be installed to build & run this app:
1. JRE 1.8 or above
2. Maven 3.6 or above

### Dependencies

1. **jackson-databind** -  It is the only external dependency used in the app. 
Since this is mentioned in the pom.xml file as a dependency, so we don't need to explicitly install this.
    Maven will download this dependency automatically.
    
### Build the App
1. We need to clone this repository. - `git clone https://github.com/rounakraj8/foodtruck-app.git`
2. Go inside the directory. - `cd foodtruck-app`
3. Build this app & generate the artifact(*.jar), using _mvn_ command. - `mvn clean package`.
    This command will compile the programs & generate a *.jar with all required dependencies.

Sample artifact(*.jar) name - `foodtruck-app-1.0-SNAPSHOT.jar`
    
### Run the App(manually)

To run this app, you can use `java -jar target/foodtruck-app-1.0-SNAPSHOT.jar` in the location where generated artifact(*.jar) is present.

If you have more than 10 food-truck available, you will get option to either continue or exit.

For continuing, we need to enter 1 & for exiting, we need to enter 0

### Build & Run the App(using _start.sh_ script)

There is a _start.sh_ script in the root folder which can be used to build the artifact(*.jar) and run the app.

`./start.sh `

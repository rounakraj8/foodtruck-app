# foodtruck-app

This app can be used to get list of all food trucks that are open in San Francisco at the current time.

### Data Source

   San Francisco government’s website has a public data
   URL - https://data.sfgov.org/Economy-and-Community/Mobile-Food-Schedule/jjew-r69b

### Prerequisites

The following should be installed to build & run this app:
1. JRE 1.8 or above
2. Maven 3.6 or above

### Install Dependencies

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

### Build & Run the App(using _start.sh_ script)

There is a _start.sh_ script in the root folder which can be used to build the artifact(*.jar) and run the app.

`./start.sh `

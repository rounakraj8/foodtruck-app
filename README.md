# foodtruck-app

This app can be used to get list of all food trucks that are open at the current time.

### Prerequisites

The following  should be installed to build & run this app:
1. JRE 1.8 or above
2. Maven 3.6 or above

### Install Dependencies

_jackson-databind_ -  It is the only external dependency used in the app. 
Since this is mentioned in the pom.xml file as a dependency, so we don't need to explicitly install this.
    Maven will download this dependency in _install/package_ phase.
    
### Build the App
First we need to clone this repository `git clone https://github.com/rounakraj8/foodtruck-app.git`

Now to build this app & generate the artifact(JAR), we will use Maven command.

`mvn clean package`

This command will compile the programs & generate a JAR with all required dependencies.
This generated artifact(JAR) is standalone and can be run anywhere. 

Sample artifact(JAR) name - `foodtruck-app-1.0-SNAPSHOT.jar`
    
### Run the App(manually)

To run this app, you can use `java -jar target/foodtruck-app-1.0-SNAPSHOT.jar` in the location where generated artifact(JAR) is present.

### Build & Run the App(using start.sh script)

There is a _start.sh_ script in the root folder which can be used to build the artifact(JAR) and run the app.

`./start.sh `

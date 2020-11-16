# Java-Hibernate-Sample
This project demonstrates how to perform crud operations on DB using MySQL and hibernate. This also demonstrates how to connect Java with DB and how to use Native SQL along with hibernate.

## Please follow below steps to run this project:

1. Download/pull the project and save it locally in your system.
2. Open project appropriately in eclipse.
3. Now click on Project and run.
4. Once the project is started successfully, you will be prompted options to perform operations. Please follow as per requirements.

## Project details:

1. I have created a POJO class(named DBPasswordTable.class) to map with database table.
2. I have created a seperate class (DBOperations.class) to define functions of crud operation. Everytime you select an option, a function will be called from this class.
3. All the hibernate configurations are defined in hibernate.cfg.xml.
4. DB connectivity and disconnection are done in 2 seperate private functions defined in DBOperations.class to make code reuseable in rest of functions.
5. Program runs in loop till exit is selected from options. Once you select exit, loop ends and program terminates.


Thank you.

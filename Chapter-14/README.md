# Ch. 14 - Database Programming
DBMS(DataBase Management System) is the software that helps many computer users to record or access data in database. It provides convenient and effective environment for searching information in the database or saving information on it. DBMS integrates data so that it enables other applications to share and to systematically use information.

These are functions DBMS supports.

1. Definition of accumulated data structure
2. Accumulation of data according to data structrue
3. Data search and update by database language
4. Concurrent execution control of data processing on multiple users
5. Restoration of status when an error arises while updating
6. Security of information

Typical type of DBMS is relational where Oracle, Sybase, and Infomix are included. Some familiar programs such as Microsoft Access for a small group of people or SQL Server supporting a great number of users are DBMS, too.

DBMS defines, manipulates, and controls the data with SQL(Structured Query Language). It is the query language for database containing DDL and DML, being used widely. It can be contained within online device or within C or Java programs. It is device-independent, executes operations by table, rather than an individual record. Moreover, it is easy to use since it has similar grammar to English sentenses.

## DDL
DDL(Data Definition Language) defines, changes, or deletes schema, domain, table, view, and index. There are CREATE, ALTER, and DROP in DDL.

| Command | Function |
| :-: | :-: |
| CREATE | Creates schema, domain, table, view, and index. (Define) |
| ALTER | Alters definition of table. (Change) |
| DROP | Drops schema, domain, table, view, and index. (Delete) |

### 1. Schema Definition
Schema is a logical collection that groups tables and other database objects associated with a user. Define the schema's name, and define its owner or permission on it. Use CREATE for the definition.

    CREATE SCHEMA schema_name AUTHORIZATION owner_name;
    
If you do not need the schema anymore, use DROP to delete it. Command CASCADE drops all objects referring to the schema, but command RESTRICT cancels the deletion if an object has it as a reference.

    DROP SCHEMA schema_name [ CASCADE | RESTRICT ];

### 2. Domain Definition
Domain is the collection of values that a data element may contain. For example, a domain for gender column (field) in a table handling information on people would be "Male", "Female". Define it like below.

    CREATE DOMAIN domain_name type
    [DEFAULT default_value]
    [CONSTRAINT VALID-domain_name CHECK(range_value)];
    
    CREATE DOMAIN GENDER CHAR(1)
    DEFAULT 'M'
    CONSTRAINT VALID-GENDER CHECK(VALUE IN ('M', 'F'));

To delete it, DROP it.

    DROP DOMAIN domain_name [ CASCADE | RESTRICT ];

### 3. Table Definition
Tables are database objects that contain all the data in a database. Set constraints to a column or a collection of columns to define a table. PRIMARY KEY, UNIQUE, and FOREIGN KEY are the examples of the constraints. Also, define CHECK constraint to limit the value range of the column.

    CREATE TABLE table_name (
    column1_name type1 [NOT NULL],
    column2_name type2 [NOT NULL],
    ...,
    [PRIMARY KEY(column_name, ...)]
    [UNIQUE (column_name, ...)]
    [FOREIGN KEY(column_name, ...) REFERENCES reference_table_name(primary_key_column_name)]
    [CONSTRAINT constraint_name] [CHECK conditional_expression]
    );
    
    CREATE TABLE STUDENT(
    NAME VARCHAR(20) NOT NULL,
    NUMBER CHAR(8),
    MAJOR CHAR(3),
    SEX GENDER,
    PRIMARY KEY(NUMBER)
    FOREIGN KEY(MAJOR) REFERENCES DEPARTMENT(CODE)
    );

To change the definition of the table, follow these commands. ADD to add a new field, and ALTER to modify a column definition, and DROP to delete a column.

    ALTER TABLE table_name ADD column_name type;
    ALTER TABLE table_name ALTER column_name type;
    ALTER TABLE table_name DROP column_name;

Delete a table with DROP command.

    DROP TABLE table_name [ CASCADE | RESTRICT ];

### 4. View Definition
View is the virtual table whose data are derived from one or more tables using FROM clause. It is created by SELECT statement used as a subquery.

    CREATE VIEW view_name [(column1_name, column2_name, ...)]
    AS select_statement
    
    CREATE VIEW MALE
    AS SELECT NAME, NUMBER
    FROM STUDENT
    WHERE SEX = 'M';

The way to delete a view is identical to others.

    DROP VIEW view_name [ CASCADE | RESTRICT ];

### 5. Index Definition
Index is a data structure to make search faster. It allows to duplicate value unless you use command UNIQUE. ASC lists data in ascending order, and DESC in descending order. Default is ASC.

    CREATE [UNIQUE] INDEX index_name ON table_name (column1_name [ ASC | DESC ], column2_name [ ASC | DESC ], ...);
    
    CREATE INDEX NUMINDEX ON STUDENT (NUMBER ASC);

Delete an index uising DROP.

    DROP INDEX index_name [ CASCADE | RESTRICT ];

## DML
DML(Data Manipulation Language) manipulates data on a database table using INSERT, UPDATE, DELETE, and SELECT.

### Data Insertion
INSERT adds a new tuple (row) into a table.

    INSERT INTO table_name(column1_name[, column2_name, ...]) VALUES(column1_value[, column2_value, ...])
    
    INSERT INTO STUDENT(NAME, NUMBER, MAJOR, SEX) VALUES ('HongGilDong', '20102211', '044', 'F')
    
### Data Update
UPDATE modifies the value of a column on the table.

    UPDATE table_name SET column1_name = column1_value[, column2_name = column2_value, ...] [WHERE conditional_expression]
    
    UPDATE STUDENT SET MAJOR = 042 WHERE NUMBER = '20102211'
    
### Data Deletion
DELETE removes a tuple from the table.

    DELETE FROM table_name [WHERE conditional_expression]
    
    DELETE FROM STUDENT WHERE NUMBER = '20102211'
    
### Data Selection
SELECT searches the value of a column on the table. GROUP BY groups values by specific column, and ORDER BY sorts them based on appointed column. ASC and DESC also can be used.

    SELECT * | [DISTINCT] column1_name[, column2_name, ...] expression [AS nickname], ...
    FROM table_name
    [WHERE condition]
    [GROUP BY column1_name[, column2_name, ...] [HAVING group_condition]]
    [ORDER BY column1_name[, column2_name, ...] [ ASC | DESC ]]
    
    SELECT NAME, NUMBER, MAJOR
    FROM STUDENT WHERE SEX = 'F'
    ORDER BY MAJOR ASC
    
## JDBC
**JDBC**(Java DataBase Connectivity) is an API for Java, whose driver acts as a bridge between an application and a DBMS. If the application sends a query with requests to the DBMS via JDBC API, the driver converts it into the query type the DBMS can recognize. Since Java provides only JDBC API, a user should use JDBC driver made by the DBMS company or a third party.

### Type 1: JDBC-ODBC Bridge
JDBC-ODBC Bridge converts JDBC functions called by JDBC API into ODBC(Open DataBase Connectivity) functions. The outcomes are delivered to the DBMS via ODBC driver, so that they produce their execution results. The strength of this type of driver interface is it does not require additional costs for the connection to the supporting DBMSs. However, each client should have ODBC module, and downloading via network is impossible on some programs like Applet.

### Type 2: Native Bridge
Native Bridge converts JDBC API calls to DBMS's own client API calls. Therefore, Java uses native methods partially to interface with binary files, provided from a vendor. (Vendor database: Database with which interacted through JDBC using special drivers) Native methods are the codes programmed by other languages such as C or C++. They can access computer components where JVM cannot do, and be executed on specific OS or CPU.

If you want to interface with a database with a Native Bridge driver as a client, you should have a library in binary code format provided by DBMS vendor. On account of Native Bridge using native methods, it cannot download through network on some programs.

### Type 3: Net Protocol
Net Protocol driver is the most flexible among the JDBC driver types. When a user access a middleware server, it helps him to approach to various DBMS. After the JDBC driver communicates JDBC API, converted to DBMS-independent net protocol, to the middleware server, it converts it to a protocol unique on DBMS, and conveys it to the server. The driver without native codes has the advantage of being downloaded via network, and of driver processing being simplified.

### Type 4: Native Protocol
Native Protocol JDBC driver is a small and fast driver that access to a DBMS directly, converting JDBC calls from client into the DBMS-exclusive protocol. Additionally, it is a pure Java driver available by downloading it through network. Nevertheless, it is bigger than Net Protocol driver, because of containing all process for accessing the DBMS.

### Conclusion
Type 1 and Type 2 are the temporary solutions to utilize JDBC in some locations unable to use pure Java drivers directly. Type 3 and Type 4 is the optimized ways to access a database through JDBC, and between them Type 4 is the fastest. If you need to deal with various types of database with one program, it is good to choose Type 3.

## JDBC Connection
Check [Appendix](https://github.com/reruo321/Java_Practice/blob/main/Appendix/README.md#jdbc-connection) and Example 01 for JDBC connection.

## JDBC-Related Class

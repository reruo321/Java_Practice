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
Domain is the collection of values that a data element may contain. For example, a domain for gender column in a table handling information on people would be "Male", "Female". Define it like below.

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

Delete the table with DROP command.

    DROP TABLE table_name [ CASCADE | RESTRICT ];

### 4. View Definition

### 5. Index Definition

## DML


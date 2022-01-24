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

    DROP SCHEMA schema_name { CASCADE | RESTRICT };

### 2. Domain Definition

### 3. Table Definition

### 4. View Definition

### 5. Index Definition

## DML


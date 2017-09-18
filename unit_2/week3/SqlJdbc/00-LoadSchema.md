## Loading the sdvid Example Database
Our examples and exercises use a schema called `sdvid`, which will be created by a SQL script with defines the tables and inserts their data.

### Install MySQL (as part of MAMP)
See [MAMP](../MAMP/README.md)

### Download `sdvid.sql`
* The instructor will show you how to download `sdvid.sql` to your ~/SD/ folder.

### Run the script using `mysql`.
Open a terminal and `cd` to where you placed `sdvid.sql`, and run it as the MySQL `root` user:

```bash
cd ~/SD
mysql -u root -p < sdvid.sql
## password is 'root'. less-than sign (<) redirects input to come from the sdvid.sql file.
```

### Add a 'student' account with access to the new schema:
```bash
mysql -u root -p
Enter password: 
```
```sql
mysql> CREATE USER student@localhost IDENTIFIED BY 'student';
mysql> GRANT INSERT,UPDATE,DELETE,SELECT on sdvid.* TO student@localhost;
```

### Log In to the `sdvid` Schema
```bash
mysql -u student -p sdvid
## no less-than sign. sdvid is the name of the schema to use.
mysql> show tables;
mysql> exit;
```

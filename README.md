# Spring-Boot-Security

### 1. Spring security basic
Basic in memory authentication with hard coded user/password
````
- http://localhost:8080/
- http://localhost:8080/user
- http://localhost:8080/admin
- http://localhost:8080/logout
````
### 2. Spring security ldap
Basic LDAP authentication
````
LDAP Details - 
- 'ldap://localhost:8389/dc=springframework,dc=org', root DN is 'dc=springframework,dc=org'
- http://localhost:8080/api/ldap/check
Username: ben
Password: benspassword
````

### 3. Spring Security JDBC
````
h2 console: http://localhost:8080/h2-console/
- http://localhost:8080/
- http://localhost:8080/user
- http://localhost:8080/admin
- http://localhost:8080/logout
````

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

### 4. Spring Security JPA
````
h2 console: http://localhost:8080/h2-console/
- http://localhost:8080/
- http://localhost:8080/user
- http://localhost:8080/admin
- http://localhost:8080/logout
````

### 5. Spring Security JWT
````
curl http://localhost:8080/hello
HTTP Response - {"timestamp":"2020-10-17T08:00:10.213+0000","status":403,"error":"Forbidden","message":"Access Denied","path":"/hello"}

curl -i -H "Content-Type: application/json" -X POST -d "{\"username\": \"user\", \"password\": \"pass\"}' http://localhost:8080/authenticate
HTTP Response - {"jwt":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjAyOTU4Nzk4LCJpYXQiOjE2MDI5MjI3OTh9.ty4j6zwOC2ypQl6oXfQbLkDDc8s4Bhvusop3vbjeGtk"}

curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjAyOTU4Nzk4LCJpYXQiOjE2MDI5MjI3OTh9.ty4j6zwOC2ypQl6oXfQbLkDDc8s4Bhvusop3vbjeGtk" http://localhost:8080/hello
HTTP Response - Hello World
````

### 6. Spring Security OAUTH2
````
curl http://localhost:8080/user
HTTP Response - {"error":"unauthorized","error_description":"Full authentication is required to access this resource"}

generate oauth access token
curl -X POST -u "client-id:secret" -d "grant_type=password&username=user&password=pass&scope=trust" http://localhost:8080/oauth/token
HTTP Response - {"access_token":"ef3bfd25-2dfd-4323-8a32-ae407b8a43ee","token_type":"bearer","refresh_token":"662405f8-978a-4bf6-be1f-2300924e8e3c","expires_in":3417,"scope":"trust"}

curl http://localhost:8080/user -H "Authorization: Bearer ef3bfd25-2dfd-4323-8a32-ae407b8a43ee"
HTTP Response - Hello User
````

### 7. Spring Security Kerberos
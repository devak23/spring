#Where I made mistakes#
1. Forgot that you dont need to specify the JoinColumn and Column both in the Employee class
2. SpringBoot tried connecting to "test.emp" even after specifying "EMP" in the model. This was fixed by specifying the
following property in the application.properties:
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
3. After fixing that, i got into the following error: Caused by: org.hibernate.PropertyAccessException: Null value was
assigned to a property [class com.ak.learning.employee.models.Employee.commission] of primitive type setter of
com.ak.learning.employee.models.Employee.commission
This was because I had set the commission field of the Employee class as double instead of Double and therefore null value couldn't be set into it.
4. After that, the application ran fine but i couldn't see the employees on the console. So I overrode the toString() method and ran the app again.
This time it threw org.hibernate.LazyInitializationException: could not initialize proxy - no Session at me. This was because the toString() was referring
to two relationships

Setup Instructions:

1. Setup a MySQL db and change its root password to "AdithyaBM".

2. Unzip the project and open it in eclipse IDE.

3. Click on the project directory on the left pane and right click on it to Run As -> Maven Install

4. Select /src/main/java/net/javaguides/lms/LibraryManagementAppApplication.java and Run As -> Java Application

5. Go to localhost:8080 and test out these urls:

URLs:

____________________________________________
AUTHOR:

GET:

http://localhost:8080/api/author
http://localhost:8080/api/author/{id}

POST:
http://localhost:8080/api/author

PUT:
http://localhost:8080/api/author/{id}

DELETE:
http://localhost:8080/api/author/{id}

______________________________________________

BOOK:

GET:

http://localhost:8080/api/books
http://localhost:8080/api/books/{id}
http://localhost:8080/api/books/byAuthor/{name}
http://localhost:8080/api/books/borrowed
http://localhost:8080/api/books/available

POST:
http://localhost:8080/api/books

PUT:
http://localhost:8080/api/books/{id}

DELETE:
http://localhost:8080/api/books/{id}

________________________________________________

RENTAL:

GET:

http://localhost:8080/api/rental
http://localhost:8080/api/rental/{id}
http://localhost:8080/api/rental/overdue/{days}

POST:
http://localhost:8080/api/rental/{bookId}/borrow/{userId}
http://localhost:8080/api/rental/{bookId}/return

DELETE:
http://localhost:8080/api/rental/{id}

______________________________________________


THANK YOU.






.

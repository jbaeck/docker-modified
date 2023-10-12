# docker-modified
Showcase modified timestamp behaviour for bind-mounts

The sample is based on https://github.com/bechhansen/docker-win-5543/tree/master.

I just added the possibility to specify the base path where to create the files.

To run the programm:

1. Clone the repositor  
```git clone git@github.com:jbaeck/docker-modified.git```

4. Start a java container  
```docker run --rm -ti -v .:/tmp/bind-mount -w /tmp/bind-mount/docker-modified eclipse-temurin:17 /bin/bash```

3. Compile the java-class  
```javac ModifiedTest.java```

4. Run the programm / this will showcase the difference in the timestamps  
```java ModifiedTest```

5. Run the program outside the bind-mounted directory / timestamps are equal  
```java ModifiedTest /tmp```


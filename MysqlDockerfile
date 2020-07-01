# Derived from official mysql image (our base image)
FROM mysql:5.7
# Add a database
ENV MYSQL_DATABASE mkrestds
ENV MYSQL_ROOT_USERNAME=root
ENV MYSQL_ROOT_PASSWORD=root

# All scripts in docker-entrypoint-initdb.d/ are automaticaly by mapping sql-scripts/ directory 
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

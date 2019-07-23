cd to dir where repo cloned

copy StaticFeed-NO.json and DynamicFeed-NO.json to src/main/resources dir

make sure that src/main/resources/application.properties file define proper names of two json files previously copied

run mvn spring-boot:run

after app is started two endpoints should be available:
http://localhost:9000/fuel/v1.0/bulk/static/NO
http://localhost:9000/fuel/v1.0/bulk/dynamic/NO
# ClientServer-CNT4504
## TODO
- [x] fix errors
- [x] compile
- [x] create threads for client
- [ ] figure out how to write server code
- [ ] Make sure server and client communicate properly
- [ ] Thorough testing of all functionality
- [ ] Make sure everyone understands the functionality
- [ ] Record all response times and start the research paper

#### This was a good starting point
```
For (i=0; i<=10; ++i)
New Threadi;
```
```
For (i=0; i<=10; ++i)
Thread[i].start();
```

#### To compile: 
```
javac ThreadHandler.java
javac Client.java
```
#### To run: 
`java ThreadHandler 192.168.100.108 500` (second argument can be whatever port number)

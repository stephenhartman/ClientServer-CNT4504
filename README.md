# ClientServer-CNT4504 #
- TODO
	1. fix errors
	1. compile
	1. figure out how to write server code
	1. create threads for client
```
For (i=0; i<=10; ++i)
New Threadi;
```
```
For (i=0; i<=10; ++i)
Thread[i].start();
```

# Errors #

- Client.java:34: error: unreported exception IOException; must be caught or declared to be thrown
	`BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));`
                                                                                                        ^
- Client.java:36: error: unreported exception IOException; must be caught or declared to be thrown
	`PrintWriter out = new PrintWriter(s.getOutputStream(), true);`
                                                                           ^
- Client.java:110: error: unreported exception IOException; must be caught or declared to be thrown
	`while((answer = input.readLine()) != null && !answer.equals("ServerDone"))`
                                                      ^
3 errors

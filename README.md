# How to build

Run

```
./gradlew clean build
```

Notes
* No java doc on public methods or classes
* Domain object mixed with persistence layer 
* No SLF4J


Manual URIs testing
* Request GET http://localhost:8080/v1/com/abc/accounts/001/orders
* Response [{"id":1,"items":[{"id":1,"name":"100 Watt","description":"Bulb"}]}]
